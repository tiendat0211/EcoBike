package api;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Bike;

public class ApiBike implements Apis {

	@Override
	public ArrayList<Bike> getData() {
		ArrayList<Bike>  listbike = new ArrayList<Bike>();
		
		try {   
            FileInputStream fis = new FileInputStream("src/bike.dat"); 
           ObjectInputStream ois = new ObjectInputStream(fis);
          while (fis.available() > 0) {
        	  Bike bike  = (Bike) ois.readObject(); 	
        	  listbike.add(bike);
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
		return listbike;
	}

	@Override
	public void updateData(ArrayList<?> list) {
		try {   
            FileOutputStream fis = new FileOutputStream("src/bike.dat"); 
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
