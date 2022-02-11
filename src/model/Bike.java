package model;

import java.io.Serializable;

public class Bike implements Serializable{
	
	private int idbike;
	private String bikename;
	private String brand;
	private String status;
	private String description;
	
	public Bike() {
		super();
	}
	
	public Bike(int idbike, String bikename, String brand, String status, String description) {
		super();   
		this.idbike = idbike;
		this.bikename = bikename;
		this.brand = brand;
		this.status = status;
		this.description = description;
	}

	public int getIdbike() {
		return idbike;
	}
	public void setIdbike(int idbike) {
		this.idbike = idbike;
	}
	public String getBikename() {
		return bikename;
	}
	public void setBikename(String bikename) {
		this.bikename = bikename;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getType() {
		return "Bike";
	}
	

	@Override
	public String toString() {
		return "Bike [idbike=" + idbike + ", bikename=" + bikename + ", brand=" + brand +  ", status="
				+ status + ", description=" + description + "]";
	}
		
	
}
