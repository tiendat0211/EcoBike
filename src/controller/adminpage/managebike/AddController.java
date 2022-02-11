package controller.adminpage.managebike;

import view.admin.manage.AddBike;
import view.adminpage.manage.ManageBike;



	public class AddController {
	private AddBike view;
	
	public AddController(AddBike addBike) {
		super();
		this.view = addBike;
	}

	public void getManageBike() {
		// TODO Auto-generated method stub
		view.setVisible(false);
		new ManageBike();
	}
}

