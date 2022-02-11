package controller.adminpage.managebike;

import java.util.ArrayList;

import api.ApiBike;
import api.ApiEBike;
import model.Bike;
import model.EBike;
import view.admin.manage.AddBike;

import view.adminpage.AdminPage;
import view.adminpage.manage.DeleteBike;
import view.adminpage.manage.EditBike;
import view.adminpage.manage.ManageBike;
import view.adminpage.manage.ShowBike;


public class ManageController {
	
	private ManageBike view;
	private ArrayList<Bike> listb = new ArrayList<Bike>();
	private ArrayList<EBike> liste = new ArrayList<EBike>();
	private ApiBike apib =new ApiBike();
	private ApiEBike apie =new ApiEBike();
	


	public ManageController(ManageBike manageBike) {
		super();
		this.view = manageBike;
	}

	
	public void getAdminPage() {
		// TODO Auto-generated method stub
		view.setVisible(false);
		new AdminPage(null);
		
	}
	public void getAddBike() {
		view.setVisible(false);
		new AddBike(null);
	}
	public void getDeleteBike() {
		view.setVisible(false);
		new DeleteBike();
	}
	public void getEditBike(String bikename) {
		view.setVisible(false);
		Bike b = new Bike();
		for (Bike bike : listb) {
			if (bikename.equals(bike.getBikename())) {
				b = bike;
			}
		}
		for (EBike ebike : liste) {
			if (bikename.equals(ebike.getBikename())) {
				b = ebike;
			}
		}
		new EditBike(b);
	}
	public void getShowBike(String bikename) {
		view.setVisible(false);
		Bike b = new Bike();
		for (Bike bike : listb) {
			if (bikename.equals(bike.getBikename())) {
				b = bike;
			}
		}
		for (EBike ebike : liste) {
			if (bikename.equals(ebike.getBikename())) {
				b = ebike;
			}
		}
		new ShowBike(b);
	}
	
	public ArrayList<Bike> getlistbike() {
		listb = apib.getData();
		return listb;
	}

	public ArrayList<EBike> getlistebike() {
		liste = apie.getData();
		return liste;
	}

	public ArrayList<Bike> searchBike(String bikename, String biketype) {
	
			ArrayList<Bike> listname = new ArrayList<Bike>();
			if (biketype.equals("Bike")) {
				if (bikename.equals("")) {
					for (Bike b : listb){
						listname.add(b);
					}
				}else {
					for (Bike b : listb) {
						if (bikename.equals(b.getBikename())) {
							listname.add(b);
						}
					}
				}
			}else if (biketype.equals("EBike")) {
				if (bikename.equals("")) {
					for (EBike e : liste) {
						listname.add(e);
					}
				}else {
					for (EBike e : liste) {
						if (bikename.equals(e.getBikename())) {
							listname.add(e);
						}
					}
				}
			}else {
				for (EBike e : liste) {
					if (bikename.equals(e.getBikename())) {
						listname.add(e);
					}
				}
				for (Bike b : listb) {
					if (bikename.equals(b.getBikename())) {
						listname.add(b);
					}
				}
			}
			return listname;
		}
}
