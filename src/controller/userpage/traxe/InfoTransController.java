package controller.userpage.traxe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import org.junit.validator.PublicClassValidator;

import api.ApiBike;
import api.ApiEBike;
import api.ApiStation;
import api.ApiTrans;
import api.ApiUser;
import model.Bike;
import model.EBike;
import model.Station;
import model.Transaction;
import model.User;
import view.userpage.traxe.InfoTrans;
import view.userpage.traxe.ReturnBike;

public class InfoTransController {
	
	private InfoTrans view;
	private ApiTrans api = new ApiTrans();
	private ApiUser apiu = new ApiUser();
	private ArrayList<Transaction> listtrans = new ArrayList<Transaction>();
	private ArrayList<Station> lists = new ArrayList<Station>();
	private ArrayList<User> listu = new ArrayList<User>();
	private ApiStation apis = new ApiStation();

	public InfoTransController(InfoTrans view) {
		super();
		this.view = view;
	}


	public void getReturnBike(String name) {
		view.setVisible(false);
		new ReturnBike(name);
		
	}

	public void getPay(int idstation, Transaction trans, String hours, int money) {
		if (trans.getTotalMoney()<money) {
			JOptionPane.showMessageDialog(view, "Bạn không đủ tiền");
		}else {
			listu=apiu.getData();
			listtrans = api.getData();
			System.out.println(listtrans.size());
			if (trans.getType().equals("Bike")) {
				updateMoneyUser(listu, trans, 400000, money);
			}else {
				updateMoneyUser(listu, trans, 700000, money);
			}
			apiu.updateData(listu);
			api.updateTransbyName(trans.getUsername(),listtrans);
			api.updateData(listtrans);
			upDateStation(idstation, trans);
			JOptionPane.showMessageDialog(view, "Thanh toán thành công");
			view.setVisible(false);
			new ReturnBike(trans.getUsername());
		}
	}
	
	public void updateMoneyUser(ArrayList<User> listu,Transaction trans,int tiencoc, int tienthue) {
		for (User u:listu) {
			if (u.getUsername().equals(trans.getUsername())) {
				int newMoney = trans.getTotalMoney()+ tiencoc -tienthue;
				u.setTotalMoney(newMoney);
				System.out.println(u.getTotalMoney());
			}
		}
	}
	
	public void upDateStation(int id, Transaction trans) {
		lists = apis.getData();
		for (Station station : lists) {
			if (station.getIdStaion() == (id -1) && trans.getType().equals("Bike")) {
				addBike(station.getListbike(), trans.getBike());
			}else {
				addEBike(station.getListebike(), trans.getEbike());
			}	
		}
		apis.updateData(lists);
	}
	
	public void addBike(ArrayList<Bike> list, Bike bike ) {
		list.add(bike);
	};
	
	public void addEBike(ArrayList<EBike> list, EBike ebike ) {
		list.add(ebike);
	};
	
}
