package controller.adminpage.managebike;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import api.ApiBike;
import api.ApiEBike;
import model.Bike;
import model.EBike;
import view.adminpage.manage.EditBike;
import view.adminpage.manage.ManageBike;


public class EditController {
	private EditBike view;
	
	private ArrayList<Bike> listb = new ArrayList<Bike>();
	private ArrayList<EBike> liste = new ArrayList<EBike>();
	private ApiBike apib =new ApiBike();
	private ApiEBike apie =new ApiEBike();
	
	public EditController(EditBike editBike) {
		super();
		this.view = editBike;
	}
	public void getManageBike() {
		
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
		
		JOptionPane.showMessageDialog(view,"Cập nhật thành công");
		view.setVisible(false);
		new ManageBike();
	}
}
