package controller.adminpage.managebike;

import java.util.ArrayList;

import api.ApiBike;
import api.ApiEBike;
import model.Bike;
import model.EBike;
import view.adminpage.manage.ManageBike;
import view.adminpage.manage.ShowBike;

public class ShowController {
private ShowBike view;

private ArrayList<Bike> listb = new ArrayList<Bike>();
private ArrayList<EBike> liste = new ArrayList<EBike>();
private ApiBike apib =new ApiBike();
private ApiEBike apie =new ApiEBike();
	
	public ShowController(ShowBike showBike) {
		super();
		this.view = showBike;
	}

	public void getManageBike() {
		// TODO Auto-generated method stub
		view.setVisible(false);
		new ManageBike();
	}
	public void updateBike(Bike bike, String type) {
		listb = apib.getData();
		liste = apie.getData();
		
		if (type.equals("Bike")) {
			for (Bike bike1 : listb) {
				if (bike1.getIdbike()==bike.getIdbike()) {
					bike1.setBikename(bike.getBikename());
					bike1.setBrand(bike.getBrand());
					bike1.setDescription(bike.getDescription());
					bike1.setStatus(bike.getStatus());
				}
				
			}
			apib.updateData(listb);
		}else {
			for (EBike ebike1 : liste) {
				if (ebike1.getIdbike()==bike.getIdbike()) {
					ebike1.setBikename(bike.getBikename());
					ebike1.setBrand(bike.getBrand());
					ebike1.setDescription(bike.getDescription());
					ebike1.setStatus(bike.getStatus());
				}
				
			}
			apie.updateData(liste);
		}
	}
}