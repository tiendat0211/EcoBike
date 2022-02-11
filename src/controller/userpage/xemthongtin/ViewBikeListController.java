package controller.userpage.xemthongtin;

import java.util.ArrayList;
import java.util.Iterator;

import api.ApiBike;
import api.ApiEBike;
import api.ApiStation;
import model.Bike;
import model.EBike;
import model.Station;
import view.userpage.xemthongtin.ViewBike;
import view.userpage.xemthongtin.ViewBikeList;
import view.userpage.xemthongtin.ViewStation;

public class ViewBikeListController {

	private ApiStation apis = new ApiStation();
	private ViewBikeList view;
	private ArrayList<Station> lists = new ArrayList<Station>();
	private ArrayList<Bike> listb = new ArrayList<Bike>();
	private ArrayList<EBike> liste = new ArrayList<EBike>();
	private ApiBike apiBike = new ApiBike();
	private ApiEBike apiEBike = new ApiEBike();

	public ViewBikeListController(ViewBikeList viewBikeList) {
		super();
		this.view = viewBikeList;
	}

	public void getViewStation(String name) {
		view.setVisible(false);
		new ViewStation(name);
		
	}

	public Station getSationByID(int id) {
		Station station = new Station();
		lists = apis.getData();
		for (Station station1:lists) {
			if (station1.getIdStaion() == id) {
				station = station1;
			}
		}
		return station;
	}

	public void getViewBike(String namebike, String type, int idsation, String name) {
		view.setVisible(false);
		new ViewBike(namebike,type,idsation,name);
	}

	public ArrayList<Bike> searchBike(String bikename, String biketype, int id) {
		ArrayList<Bike> listname = new ArrayList<Bike>();
		Station station = lists.get(id-1);
		if (biketype.equals("Bike")) {
			if (bikename.equals("")) {
				for (Bike b : station.getListbike()){
					listname.add(b);
				}
			}else {
				for (Bike b : station.getListbike()) {
					if (bikename.equals(b.getBikename())) {
						listname.add(b);
					}
				}
			}
		}else if (biketype.equals("EBike")) {
			if (bikename.equals("")) {
				for (EBike e : station.getListebike()) {
					listname.add(e);
				}
			}else {
				for (EBike e : station.getListebike()) {
					if (bikename.equals(e.getBikename())) {
						listname.add(e);
					}
				}
			}
		}else {
			for (EBike e : station.getListebike()) {
				if (bikename.equals(e.getBikename())) {
					listname.add(e);
				}
			}
			for (Bike b : station.getListbike()) {
				if (bikename.equals(b.getBikename())) {
					listname.add(b);
				}
			}
		}
		return listname;
	}
	

}
