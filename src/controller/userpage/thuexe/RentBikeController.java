package controller.userpage.thuexe;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import api.ApiBike;
import api.ApiEBike;
import api.ApiStation;
import api.ApiUser;
import api.BankApi;
import model.Bike;
import model.EBike;
import model.Station;
import model.User;
import view.userpage.UserPage;
import view.userpage.thuexe.CreateTrans;
import view.userpage.thuexe.RentBike;
import view.userpage.traxe.InfoTrans;

public class RentBikeController {
	
	private RentBike view;
	private ArrayList<Station> lists = new ArrayList<Station>();
	private ArrayList<User> listu = new ArrayList<User>();
	private ArrayList<Bike> listb = new ArrayList<Bike>();
	private ArrayList<EBike> liste = new ArrayList<EBike>();

	private ApiStation apis = new ApiStation();
	private ApiUser apiu = new ApiUser();
	private BankApi apibank = new BankApi();
	private ApiBike apib = new ApiBike();
	private ApiEBike apie = new ApiEBike();

	public RentBikeController(RentBike view) {
		super();
		this.view = view;
	}


	public ArrayList<Station> getListStation() {
		lists = apis.getData();
		return lists;
	}


	public void getUserPage(String name) {
		view.setVisible(false);
		new UserPage(name);
	}


	public void checkCarNumber(String cardnumber, String name, String bikename, String type,int idstation) {
		listu = apiu.getData();
		String card = null;
		for(User u:listu) {
			if (name.equals(u.getUsername())) {
				card = String.valueOf(u.getCardmumber());
			}
		}
		if(card.equals(cardnumber)) {
			if (type.equals("Bike")) {
			}
			view.setVisible(false);
			new CreateTrans(name,bikename,idstation,type);
		}else {
			JOptionPane.showMessageDialog(view, "Nhập sai mã số thẻ");
		}
	}


	public ArrayList<Bike> searchBike(String bikename) {
		listb = apib.getData();
		liste = apie.getData();
		ArrayList<Bike> list = new ArrayList<Bike>();
		for (Bike b:listb) {
			if (bikename.equals(b.getBikename())) {
				list.add(b);
			}
			
		}
		for (Bike e:liste) {
			if (bikename.equals(e.getBikename())) {
				list.add(e);
			}
			
		}
		return list;
	}
	
	
}
