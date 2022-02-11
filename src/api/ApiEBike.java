package api;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.EBike;


public class ApiEBike implements Apis{

	@Override
	public ArrayList<EBike> getData() {
		ArrayList<EBike>  listebike = new ArrayList<EBike>();
		
		try {   
            FileInputStream fis = new FileInputStream("src/ebike.dat"); 
           ObjectInputStream ois = new ObjectInputStream(fis);
          while (fis.available() > 0) {
        	  EBike ebike  = (EBike) ois.readObject(); 	
        	  listebike.add(ebike);
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
		return listebike;
	}

	public void updateData(ArrayList<?> list) {
		
		try {   
            FileOutputStream fis = new FileOutputStream("src/ebike.dat"); 
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
