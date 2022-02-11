package controller.userpage.traxe;


import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import api.ApiStation;
import api.ApiTrans;
import api.ApiUser;
import api.BankApi;
import model.Bike;
import model.Station;
import model.Transaction;
import model.User;
import view.userpage.UserPage;
import view.userpage.traxe.InfoTrans;
import view.userpage.traxe.ReturnBike;


public class ReturnBikeController {
	
	private ArrayList<Station> lists = new ArrayList<Station>();
	private ArrayList<User> listu = new ArrayList<User>();
	private ReturnBike view;
	private ApiTrans apitrans = new ApiTrans();
	private ApiStation apista= new ApiStation();
	private ApiUser apiu= new ApiUser();
	private Transaction tras = new Transaction();
	private BankApi apibank= new BankApi();
	
	public ReturnBikeController(ReturnBike view) {
		super();
		this.view = view;
	}
	
	public ArrayList<Station> getListSation() {
		lists = apista.getData();
		return lists;
	}

	public void getUserPage(String name) {
		view.setVisible(false);
		new UserPage(name);
	}

	public Transaction getTransactionByName(String name) {
		tras = apitrans.getTransbyName(name);
		return tras;
	}


	public void checkCardNumber(String cardnumber,Transaction trans,int idstation, String hours) {
		String card = String.valueOf(trans.getCard());
		if(card.equals(cardnumber)) {
			int rentMoney =  apibank.Tinhtien(trans.getType(),hours);
			System.out.println(rentMoney);
			System.out.println(hours);
			System.out.println(trans.getType());
			view.setVisible(false);
			new InfoTrans(trans,idstation,hours,rentMoney);
		} else {
			JOptionPane.showMessageDialog(view, "Nhập sai mã số thẻ");
		}
	}

	public void showMessage(String string) {
		JOptionPane.showMessageDialog(view, string);
	}

	public void getUserMoney(String name) {
		listu = apiu.getData();
		for (User u : listu) {
			if (u.getUsername().equals(name)) {
				JOptionPane.showMessageDialog(view, "Số tiền của bạn: "+u.getTotalMoney()+" VND");
			}
			
		}
		
	}

}
