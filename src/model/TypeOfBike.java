package model;

import java.io.Serializable;

public class TypeOfBike implements Serializable{
	
	private int idtype;
	private String typename;
	private String discription;
	
	public TypeOfBike() {
		super();
	}



	public TypeOfBike(int idtype, String typename, String discription) {
		super();
		this.idtype = idtype;
		this.typename = typename;
		this.discription = discription;
	}



	public int getIdtype() {
		return idtype;
	}



	public void setIdtype(int idtype) {
		this.idtype = idtype;
	}



	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}



	public String getDiscription() {
		return discription;
	}



	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
	

}
