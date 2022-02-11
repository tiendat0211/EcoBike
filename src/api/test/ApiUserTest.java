package api.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import api.ApiTrans;
import api.ApiUser;
import model.Transaction;
import model.User;

public class ApiUserTest {
	private ApiUser api = new ApiUser();

	@Test
	public void testGetData() {
		ArrayList<User> list = new ArrayList<User>();
		list = api.getData();
		assertTrue("Eror in updateBook API!", list.size() > 0);
	}
	
	@Test
	public void testupdateData() {
		ArrayList<User> list = new ArrayList<User>();
		list = api.getData();
		assertTrue("Eror in updateBook API!", list.size() > 0);
		
		String name = "user";
		list.get(0).setUsername(name);
		api.updateData(list);
		
		ArrayList<User> list2 = new ArrayList<User>();
		list2 = api.getData();
		assertTrue("Eror in updateBook API!", list2.size() > 0);
		assertEquals("Errol in updata getData API", list2.get(0).getUsername(),name);
	}

}

