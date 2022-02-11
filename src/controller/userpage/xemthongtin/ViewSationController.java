package controller.userpage.xemthongtin;


import java.util.ArrayList;
import java.util.Iterator;

import api.ApiStation;
import model.Station;
import view.userpage.UserPage;
import view.userpage.xemthongtin.ViewBikeList;
import view.userpage.xemthongtin.ViewStation;

public class ViewSationController  {
	
	private ApiStation apista = new ApiStation() ;
	private ArrayList<Station> list =  new ArrayList<Station>();
	private ViewStation view;
	
	public ViewSationController(ViewStation view) {
		super();
		this.view = view;
	}

	public ArrayList<Station> getListSation() {
		list = apista.getData();
		return list;
	}

	public void getUserPage(String name) {
		view.setVisible(false);
		new UserPage(name);
		
	}

	public void getViewBikeList(String name, int id) {
		view.setVisible(false);
		new ViewBikeList(name,id);
		
	}


	public ArrayList<Station> searchSation(String namestation, String addsation) {
		ArrayList<Station> listsearch = new ArrayList<Station>();
		if (namestation.equals("")) {
			for (Station s : list) {
				if (addsation.equals(s.getAddres())) {
					listsearch.add(s);
				}
			}
		}else if (addsation.equals("")) {
			for (Station s : list) {
				if (namestation.equals(s.getNameStaion())) {
					listsearch.add(s);
				}
			}
		}else {
			Station station = new Station(namestation,addsation);
			for (Station s : list) {
				if (s.equals(station)) {
					listsearch.add(s);
				}
			}
		}
		return listsearch;
	}


}
