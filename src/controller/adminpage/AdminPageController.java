package controller.adminpage;

import view.EcoBike;
import view.adminpage.AdminPage;
import view.adminpage.manage.ManageBike;

public class AdminPageController {
	private AdminPage view;
	
	public AdminPageController(AdminPage view) {
		super();
		this.view = view;
	}
	
	public void manageBike() {
		view.setVisible(false);
		new ManageBike();
	}
	
	public void getEcoBike() {
		// TODO Auto-generated method stub
		new EcoBike();
		
	}
	
}