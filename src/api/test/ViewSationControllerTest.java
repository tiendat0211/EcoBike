package api.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Station;
import api.ApiStation;
import controller.userpage.xemthongtin.ViewSationController;

public class ViewSationControllerTest {

	@Test
	public void testSearchSationWhiteBox() {
		ArrayList<Station>  list0,list1,list2,list3,list4,list5,list6,list7,list8  = new ArrayList<Station>();
		ViewSationController controller = new ViewSationController(null);
		ArrayList<Station> list = controller.getListSation();

		
		String nametest0 = "";
		String nametest1 = "Bãi xe 2";
		String nametest2 = " bai xe 2";
		
		String addtest0 = "";
		String addtest1 = "Khu B";
		String addtest2 = " khu b";
		
		
		list0 = controller.searchSation(nametest0,addtest0);
		list1 = controller.searchSation(nametest0,addtest1);
		list2 = controller.searchSation(nametest0,addtest2);
		list3 = controller.searchSation(nametest1,addtest0);
		list4 = controller.searchSation(nametest1,addtest1);
		list5 = controller.searchSation(nametest1,addtest2);
		list6 = controller.searchSation(nametest2,addtest0);
		list7 = controller.searchSation(nametest2,addtest1);
		list8 = controller.searchSation(nametest2,addtest2);


		assertTrue("Eror in Search method!", list0.size() == 0);
		assertTrue("Eror in Search method!", list1.size() > 0);
		assertTrue("Eror in Search method!", list2.size() == 0);
		assertTrue("Eror in Search method!", list3.size() > 0);
		assertTrue("Eror in Search method!", list4.size() > 0);
		assertTrue("Eror in Search method!", list5.size() == 0);
		assertTrue("Eror in Search method!", list6.size() == 0);
		assertTrue("Eror in Search method!", list7.size() == 0);
		assertTrue("Eror in Search method!", list8.size() == 0);

		
	}
	
	@Test
	public void testSearchSationBlackBox() {
		ArrayList<Station>  list0,list1,list2,list3,list4  = new ArrayList<Station>();
		ViewSationController controller = new ViewSationController(null);
		ArrayList<Station> list = controller.getListSation();

		
		String nametest0 = "";
		String nametest1 = "Bãi xe 2";
		
		String addtest0 = "";
		String addtest1 = "Khu B";
		String addtest2 = " khu b";
		
		
		list0 = controller.searchSation(nametest0,addtest0);
		list1 = controller.searchSation(nametest0,addtest1);
		list2 = controller.searchSation(nametest0,addtest2);
		list3 = controller.searchSation(nametest1,addtest0);
		list4 = controller.searchSation(nametest1,addtest1);



		assertTrue("Eror in Search method!", list0.size() == 0);
		assertTrue("Eror in Search method!", list1.size() > 0);
		assertTrue("Eror in Search method!", list2.size() == 0);
		assertTrue("Eror in Search method!", list3.size() > 0);
		assertTrue("Eror in Search method!", list4.size() > 0);

		
	}

}
