package api;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import model.ATMCard;
import model.Bike;
import model.EBike;
import model.Station;
import model.Transaction;
import model.User;

public class ApiUser implements Apis{

	@Override
	public ArrayList<User> getData() {
	ArrayList<User>  listUser = new ArrayList<User>();
		
		try {   
            FileInputStream fis = new FileInputStream("src/users.dat"); 
           ObjectInputStream ois = new ObjectInputStream(fis);
          while (fis.available() > 0) {
        	  User user2  = (User) ois.readObject(); 	
        	  listUser.add(user2);
          }
           ois.close();
           fis.close();
        }catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	 	catch (IOException e) {
            System.out.println("Error Write file");
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return listUser;
	}

	@Override
	public void updateData (ArrayList<?> list) {
		try {   
            FileOutputStream fis = new FileOutputStream("src/users.dat"); 
           ObjectOutputStream ois = new ObjectOutputStream(fis);
          for (int i=0;i<list.size();i++) {
        	  ois.writeObject(list.get(i));
          } 
           ois.close();
           fis.close();
        }catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	 	catch (IOException e) {
            System.out.println("Error Write file");
        } 
		
	}

}
