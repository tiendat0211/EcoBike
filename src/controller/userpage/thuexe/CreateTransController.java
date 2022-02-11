package controller.userpage.thuexe;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import api.ApiBike;
import api.ApiEBike;
import api.ApiStation;
import api.ApiTrans;
import api.ApiUser;
import api.BankApi;
import model.Bike;
import model.EBike;
import model.Station;
import model.Transaction;
import model.User;
import view.userpage.thuexe.CreateTrans;
import view.userpage.thuexe.RentBike;

public class CreateTransController {
	private CreateTrans view;
	private ArrayList<User> listu = new ArrayList<User>();
	private ArrayList<Transaction> listt = new ArrayList<Transaction>();
	private ArrayList<Bike> listb = new ArrayList<Bike>();
	private ArrayList<EBike> liste = new ArrayList<EBike>();
	private ArrayList<Station> lists = new ArrayList<Station>();
	private ApiUser apiu = new ApiUser();
	private ApiTrans apit = new ApiTrans();
	private ApiBike apiBike = new ApiBike();
	private ApiEBike apiEBike = new ApiEBike();
	private ApiStation apis = new ApiStation();
	private BankApi apibank = new BankApi();

	public CreateTransController(CreateTrans view) {
		super();
		this.view = view;
	}

	public void getRentBike(String name) {
		view.setVisible(false);
		new RentBike(name);
		
	}

	public User getUserbyName(String name) {
		listu = apiu.getData();
		User u = new User(); 
		for(User user:listu) {
			if (name.equals(user.getUsername())) {
				u =user;
			}
		}
		return u;
	}

	public void creatran(User user, String type, String bikename, int idstation) {
		listt = apit.getData();
		listb = apiBike.getData();
		liste = apiEBike.getData();
		lists = apis.getData();
		listu = apiu.getData(); 
		Bike bike = new Bike();
		EBike eBike = new EBike();
		int check = 0;
		if (type.equals("Bike") && user.getTotalMoney()>400000) {
			for(Bike bike2 : listb) {
				if (bikename.equals(bike2.getBikename())) {
					bike= bike2;
					break;
				}
			}
			Transaction transaction = new Transaction(user,bike,null,0);
			listt.add(transaction);
			apibank.DatCoc(user.getMycard(), 400000);
			for (User u:listu) {
				if (u.getUsername().equals(user.getUsername())) {
					u.setTotalMoney(user.getTotalMoney());
				}
			}
			check = 1;
		}else if (type.equals("EBike")&&user.getTotalMoney()>700000){
			for (EBike eBike2 : liste) {
				if (bikename.equals(eBike2.getBikename())) {
					eBike= eBike2;
					break;
				}
			}
			Transaction transaction = new Transaction(user,null,eBike,0);
			listt.add(transaction);
			apibank.DatCoc(user.getMycard(), 700000);
			for (User u:listu) {
				if (u.getUsername().equals(user.getUsername())) {
					u.setTotalMoney(user.getTotalMoney());
				}
			}
			check = 1;
		}
		if (check == 1 ) {
			apit.updateData(listt);
			apiu.updateData(listu);
			JOptionPane.showMessageDialog(view,"Thuê xe thành công");
			Station staion = lists.get(idstation - 1);
			int idx = 0;
			if (type.equals("Bike")) {
				idx = staion.getidxBike(bikename);
				lists.get(idstation - 1).getListbike().remove(idx);
			} else {
				idx = staion.getidxEBike(bikename);
				lists.get(idstation - 1).getListebike().remove(idx);
			}
			apis.updateData(lists);
			
			view.setVisible(false);
			new RentBike(user.getUsername());
		}else {
			JOptionPane.showMessageDialog(view,"Bạn không đủ tiền");
		}
		
	}

	
}


