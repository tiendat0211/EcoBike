package api;

import java.util.Iterator;

import model.ATMCard;

public class BankApi {
	
	public BankApi() {
	}
	
	public void DatCoc(ATMCard cardnumber,int money) {
		int totalMoney = cardnumber.getTotalMoney();
		cardnumber.setTotalMoney(totalMoney - money);
	}
	
	public int Tien(String gio) {
		int totalMinute = validateTime(gio);
		int rentMoney = 0;
		if (totalMinute <= 30 && totalMinute > 0) {
			rentMoney = 10000;
		}else if (totalMinute ==0){
			rentMoney = 0;
		}else{
			rentMoney = 10000 + ((totalMinute-30)/15+1)*3000;
		}
		return rentMoney;
	}
	
	public int validateTime(String gio) {
		int totalMinute = 0;
		int hour = 0;
		int minute = 0;
		int idx = gio.indexOf("giờ");
		if (idx == 3) {
			hour = (Integer.valueOf(gio.charAt(0)) - 48)*10 + Integer.valueOf(gio.charAt(1)) - 48 ;
		}else if (idx == 2) {
			hour = Integer.valueOf(gio.charAt(0)) - 48 ;
		}else {
			hour = 0;
		}
		
		int idx2 = gio.indexOf("phút");
		if (idx2 == 3) {
			minute = (Integer.valueOf(gio.charAt(0)) - 48)*10 + Integer.valueOf(gio.charAt(1)) - 48 ;
		}else if(idx2 == 2) {
			minute = Integer.valueOf(gio.charAt(0)) - 48 ;
		}else if (idx2 == 9) {
			minute = (Integer.valueOf(gio.charAt(6)) - 48)*10 + Integer.valueOf(gio.charAt(7)) - 48 ;
		}else if (idx2 == 10) {
			minute = (Integer.valueOf(gio.charAt(7)) - 48)*10 + Integer.valueOf(gio.charAt(8)) - 48 ;
		}else if (idx2 == 8) {
			minute = Integer.valueOf(gio.charAt(6)) - 48;
		}else {
			minute = 0;
		}
		
		totalMinute = hour*60+minute;
		return totalMinute;
	}
	
	public int Tinhtien(String type, String hours ) {
		int rentMoney = Tien(hours);
		int totalMoney = 0;
		if (type.equals("Bike")&& hours != null) {
			totalMoney = rentMoney;
		}else if (type.equals("Ebike")&& hours != null) {
			totalMoney = rentMoney + rentMoney/2;
		}
		return totalMoney;
	}
}
