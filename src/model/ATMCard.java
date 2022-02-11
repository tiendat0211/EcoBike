package model;

import java.io.Serializable;

public class ATMCard implements Serializable {
	
	private int numbercard;
	private int totalMoney;
	
	public ATMCard(int numbercard, int totalMoney) {
		super();
		this.numbercard = numbercard;
		this.totalMoney = totalMoney;
	}

	public ATMCard() {
		super();
	}

	public int getNumbercard() {
		return numbercard;
	}

	public void setNumbercard(int numbercard) {
		this.numbercard = numbercard;
	}

	public int getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	
	
}
