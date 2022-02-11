package api.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import api.ApiBike;
import model.Bike;

public class ApiBikeTest {

	private ApiBike api = new ApiBike();
	
	@Test
	public void testGetData() {
		ArrayList<Bike>  list = new ArrayList<Bike>();
		list = api.getData();
		assertTrue("Eror in getdata API!", list.size() > 0);

	}

	@Test
	public void testUpdateData() {
		ArrayList<Bike> list = api.getData();
		assertTrue("No data", list.size() > 0);
		String nametest = "xe 2012";
		list.get(0).setBikename(nametest);
		
		api.updateData(list);
		ArrayList<Bike> list2 = api.getData();
		assertTrue("No data", list.size() > 0);
		
		assertEquals("Eror in updatedata API!",nametest,list2.get(0).getBikename());
		
	}
	

}
