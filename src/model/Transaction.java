package model;

import java.io.Serializable;

public class Transaction implements Serializable{
	
	private User user;
	private Bike bike;
	private EBike ebike;
	private int createdTime;
	private int status;
		
	public Transaction() {
		super();
	}

	
	public Transaction(User user, Bike bike, EBike ebike, int status) {
		super();
		this.user = user;
		this.bike = bike;
		this.ebike = ebike;
		this.status = status;
	}


	public Transaction(User user, Bike bike, int createdTime, int status) {
		super();
		this.user = user;
		this.bike = bike;
		this.createdTime = createdTime;
		this.status = status;
	}
	
	public Transaction(User user, Bike bike, EBike ebike, int createdTime, int status) {
		super();
		this.user = user;
		this.bike = bike;
		this.ebike = ebike;
		this.createdTime = createdTime;
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Bike getBike() {
		return bike;
	}

	public void setBike(Bike bike) {
		this.bike = bike;
	}

	public int getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(int createdTime) {
		this.createdTime = createdTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUsername() {
		return user.getUsername();
	}

	public EBike getEbike() {
		return ebike;
	}

	public void setEbike(EBike ebike) {
		this.ebike = ebike;
	}
	
	public String getType() {
		if(bike != null) return "Bike";
		else if(ebike != null) return "Ebike";
		else return null;
	}
	
	public String getBikeName() {
		if(bike != null) return bike.getBikename();
		else {
			return ebike.getBikename();
		} 

	}

	public Integer getCard() {
		return user.getCardmumber();
	}


	public int getTotalMoney() {
		return user.getTotalMoney();
	}

}
