package api.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import api.BankApi;
import model.ATMCard;

public class BankApiRentTest {
private BankApi api = new BankApi();
	
	@Test
	public void testDatCoc() {
		ATMCard mycard = new ATMCard(123456,1000000);
		api.DatCoc(mycard, 500000);
		assertEquals("Errol Bank Api in DatCoc" , mycard.getTotalMoney() , 500000);
	}
}
