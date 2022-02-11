package controller.userpage.xemthongtin;

import java.util.ArrayList;

import api.ApiBike;
import api.ApiEBike;
import model.Bike;
import model.EBike;
import view.userpage.xemthongtin.ViewBike;
import view.userpage.xemthongtin.ViewBikeList;

public class ViewBikeController {
	
	private ApiBike apibike = new ApiBike();
	private ApiEBike apiebike = new ApiEBike();
	ArrayList<Bike> listbike = new ArrayList<Bike>();
	ArrayList<EBike> listebike = new ArrayList<EBike>();
	private ViewBike view;
	

	public ViewBikeController() {
		// TODO Auto-generated constructor stub
	}

	public Bike getBikebyName(String name) {
		Bike bike = new Bike();
		listbike = apibike.getData();
			for (Bike bike1:listbike) {
				if(name.equals(bike1.getBikename())) bike = bike1;
			}
			
		return bike;
	}

	public EBike getEBikebyName(String name) {
		EBike ebike = new EBike();
		listebike = apiebike.getData();
			for (EBike ebike1:listebike) {
				if(name.equals(ebike1.getBikename())) ebike = ebike1;
			}
		return ebike;
	}

	public ViewBikeController(ViewBike view) {
		super();
		this.view = view;
	}

	public void getViewBikeList(String name, int idsation) {
		view.setVisible(false);
		new ViewBikeList(name, idsation);
	}
}
