package api.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import api.BankApi;

public class BankApiTest {
	private BankApi api = new BankApi();
	
	@Test
	public void testTien() {
		//String hours1 = "29 phút";
		String hours2 = "30 phút";
		String hours3 = "31 phút";
		//int tien1 = api.Tien(hours1);
		int tien2 = api.Tien(hours2);
		int tien3 = api.Tien(hours3);
		int result1 = 10000;
		int result2 = 10000;
		int result3 = 13000;
		//assertEquals("Eror in Tien API",tien1, result1);
		assertEquals("Eror in Tien API",tien2, result2);
		assertEquals("Eror in Tien API",tien3, result3);
	}

	@Test
	public void testValidateTime() {
		String hour = "1 giờ 30 phút";
		int totalMinute = api.validateTime(hour);
		int result = 90;
		assertEquals("Eror in ValidateTime API",totalMinute, result);
	}

	@Test
	public void testTinhtien() {
		int tinhtien1 = api.Tinhtien("Bike","31 phút");
		int tinhtien2 = api.Tinhtien("Ebike","31 phút");
		int tinhtien3 = api.Tinhtien("","31 phút");
		//int tinhtien4 = api.Tinhtien("","");
		//int tinhtien5 = api.Tinhtien("Bike","");
		//int tinhtien6 = api.Tinhtien("Ebike","");
		
		
		int result1 = 13000;
		int result2 = 19500;
		int result3 = 0;
		
		assertEquals("Eror in Tinhtien API",tinhtien1, result1);
		assertEquals("Eror in Tinhtien API",tinhtien2, result2);
		assertEquals("Eror in Tinhtien API",tinhtien3, result3);
		//assertEquals("Eror in Tinhtien API",tinhtien4, result3);
		//assertEquals("Eror in Tinhtien API",tinhtien5, result3);
		//assertEquals("Eror in Tinhtien API",tinhtien6, result3);
	}

}
