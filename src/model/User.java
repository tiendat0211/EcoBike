package model;

import java.io.Serializable;

public class User implements Serializable{
	
	private String username;
	private String password;
	private ATMCard mycard;
	
	
	public User() {
		super();
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	

	public User(String username, String password, ATMCard mycard) {
		super();
		this.username = username;
		this.password = password;
		this.mycard = mycard;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public ATMCard getMycard() {
		return mycard;
	}

	public void setMycard(ATMCard mycard) {
		this.mycard = mycard;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
	public boolean checkUser(User user) {
		if(user != null) {
			if("user".equals(user.getUsername())
					&& "user".equals(user.getPassword())) {
				return true;
			} else return false;
		}else return false;
	}

	public Integer getCardmumber() {
		return mycard.getNumbercard();
	}
	
	public int getTotalMoney() {
		return mycard.getTotalMoney();
	}
	
	public void setTotalMoney(int totalMoney) {
		 this.mycard.setTotalMoney(totalMoney);
	}

}
