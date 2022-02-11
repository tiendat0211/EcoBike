package model;

import java.io.Serializable;

public class EBike extends Bike implements Serializable{
	
	private int pin;
	
	public EBike(){
		
	}

	public EBike(int idbike, String bikename, String brand, String status, String description) {
		super(idbike,bikename,brand,status,description);
	}
	
	
	
	public EBike(int idbike, String bikename, String brand, String status, String description, int pin) {
		super(idbike,bikename,brand,status,description);
		this.pin = pin;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}
	
	public String getType() {
		return "EBike";
	}
	
	
}
