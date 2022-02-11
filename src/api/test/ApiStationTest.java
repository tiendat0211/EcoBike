package api.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import api.ApiStation;
import model.Station;

public class ApiStationTest {

	private ApiStation api = new ApiStation();

	@Test
	public void testGetData() {
		ArrayList<Station>  list = new ArrayList<Station>();
		list = api.getData();
		assertTrue("Eror in getdata API!", list.size() > 0);

	}

	@Test
	public void testUpdateData() {
		ArrayList<Station> list = api.getData();
		assertTrue("No data", list.size() > 0);
		String nametest = "Bãi xe 100";
		list.get(0).setNameStaion(nametest);
		
		api.updateData(list);
		ArrayList<Station> list2 = api.getData();
		assertTrue("No data", list.size() > 0);
		
		assertEquals("Eror in updatedata API!",nametest,list2.get(0).getNameStaion());
		
	}

}
