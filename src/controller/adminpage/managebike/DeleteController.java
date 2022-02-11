package controller.adminpage.managebike;

import view.adminpage.manage.DeleteBike;
import view.adminpage.manage.ManageBike;

public class DeleteController {
	private DeleteBike view;
	
	public DeleteController(DeleteBike deleteBike) {
		super();
		this.view = deleteBike;
	}
	public void getManageBike() {
		// TODO Auto-generated method stub
		view.setVisible(false);
		new ManageBike();
		
	}
}
