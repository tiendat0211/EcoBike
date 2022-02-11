package controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Action;
import javax.swing.JOptionPane;

import api.ApiUser;
import model.User;
import view.*;
import view.adminpage.AdminPage;
import view.userpage.UserPage;


public class EcoBikeController{
	
	private EcoBike view;
	private ArrayList<User> listu = new ArrayList<User>(); 
	private ApiUser apiUser = new ApiUser();
	
	public EcoBikeController(EcoBike view) {
		super();
		this.view = view;
	}

	public void getUserPage(User user2) {
		listu = apiUser.getData();
		String username =null;
		String password = null;
		int check = 0;
		for (User u:listu) {
			username = u.getUsername();
			password = u.getPassword();
			if (username.equals(user2.getUsername()) && password.equals(user2.getPassword())) {
				view.setVisible(false);
				new UserPage(user2.getUsername());
				check =1;
				break;
			}if (user2.getUsername().equals("admin")&&user2.getPassword().equals("admin")) {
				view.setVisible(false);
				new AdminPage(user2.getUsername());
				check =1;
				break;
			}
			else {
				check = 0;
			}
		}
				
		if (check == 0) {
			JOptionPane.showMessageDialog(view, "Sai tài khoản hoặc mật khẩu");
		}
	}
	

}
