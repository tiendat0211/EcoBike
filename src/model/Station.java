package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Station implements Serializable{
	
	private int idStaion;
	private String nameStaion;
	private String addres;
	private int totalDock;
	private ArrayList<Bike> listbike;
	private ArrayList<EBike> listebike;
	
	public Station() {
		super();
	}

	
	public Station(String nameStaion, String addres) {
		super();
		this.nameStaion = nameStaion;
		this.addres = addres;
	}

	public Station(int idStaion, String nameStaion, String addres, int totalDock, ArrayList<Bike> listbike,
			ArrayList<EBike> listebike) {
		super();
		this.idStaion = idStaion;
		this.nameStaion = nameStaion;
		this.addres = addres;
		this.totalDock = totalDock;
		this.listbike = listbike;
		this.listebike = listebike;
	}

	public Station(int idStaion, String nameStaion, String addres, int totalDock) {
		super();
		this.idStaion = idStaion;
		this.nameStaion = nameStaion;
		this.addres = addres;
		this.totalDock = totalDock;
	}


	public int getIdStaion() {
		return idStaion;
	}

	public void setIdStaion(int idStaion) {
		this.idStaion = idStaion;
	}

	public String getNameStaion() {
		return nameStaion;
	}

	public void setNameStaion(String nameStaion) {
		this.nameStaion = nameStaion;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public int getTotalDock() {
		return totalDock;
	}

	public void setTotalDock(int totalDock) {
		this.totalDock = totalDock;
	}

	public ArrayList<Bike> getListbike() {
		return listbike;
	}

	public void setListbike(ArrayList<Bike> listbike) {
		this.listbike = listbike;
	}

	public ArrayList<EBike> getListebike() {
		return listebike;
	}

	public void setListebike(ArrayList<EBike> listebike) {
		this.listebike = listebike;
	}

	public int getTotalBike() {
		return listbike.size()+listebike.size();
	}
	
	public int getidxBike(String bikename) {
		int idx = 0;
		for (int i = 0 ; i<listbike.size() ; i++) {
			if (listbike.get(i).getBikename().equals(bikename)) {
				idx = i; 
			} 
		}
		return idx;
	}
	
	public int getidxEBike(String bikename) {
		int idx = 0;
		for (int i = 0 ; i<listebike.size() ; i++) {
			if (listebike.get(i).getBikename().equals(bikename)) {
				idx = i; 
			} 
		}
		return idx;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Station other = (Station) obj;
		return Objects.equals(addres, other.addres) && Objects.equals(nameStaion, other.nameStaion);
	}
	


}
