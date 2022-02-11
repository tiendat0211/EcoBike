package api.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import api.ApiTrans;
import model.Transaction;

public class ApiTransTest {
	private ApiTrans api = new ApiTrans();

	@Test
	public void testGetData() {
		ArrayList<Transaction> list = new ArrayList<Transaction>();
		list = api.getData();
		assertTrue("Eror in updateBook API!", list.size() > 0);
	}


	@Test
	public void testUpdateTransbyName() {
		ArrayList<Transaction> list = api.getData();
		assertTrue("No data", list.size() > 0);
		
		Transaction transaction = list.get(0);
		list.get(0).setStatus(0);
		api.updateTransbyName(transaction.getUsername(), list);
		assertTrue("Eror in updateBook API!", list.size() > 0);
		
		Transaction newTransaction = list.get(0);
		assertEquals("Eror in updateTransbyName API!", newTransaction.getStatus(),1);
		
	}

	@Test
	public void testGetTransbyName() {
		ArrayList<Transaction> list = api.getData();
		assertTrue("No data", list.size() > 0);
		
		Transaction transaction = list.get(0);
		System.out.println(transaction.getStatus());
		list.get(0).setStatus(0);
		
		Transaction test1 = api.getTransbyName(transaction.getUsername());
		
		assertEquals("Eror in updateTransbyName API!", test1.getStatus(),0);
		
	}

}
