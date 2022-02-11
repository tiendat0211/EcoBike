package controller.userpage;

import view.*;
import view.userpage.UserPage;
import view.userpage.thuexe.RentBike;
import view.userpage.traxe.ReturnBike;
import view.userpage.xemthongtin.ViewStation;

public class UserPageController {
	
	private UserPage view;
	
	public UserPageController(UserPage view) {
		super();
		this.view = view;
	}
	
	public void getReturnBike(String name) {
		view.setVisible(false);
		new ReturnBike(name);
	}

	public void getViewStaion(String name) {
		view.setVisible(false);
		new ViewStation(name);
	}

	public void getEcoBike() {
		view.setVisible(false);
		new EcoBike();
	}

	public void getRentBike(String name) {
		view.setVisible(false);
		new RentBike(name);
		
	}

}
