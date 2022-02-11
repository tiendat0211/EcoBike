package api;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Station;

public class ApiStation implements Apis{

	@Override
	public ArrayList<Station> getData() {
		ArrayList<Station>  list = new ArrayList<Station>();
		
		try {   
            FileInputStream fis = new FileInputStream("src/station.dat"); 
           ObjectInputStream ois = new ObjectInputStream(fis);
          while (fis.available() > 0) {
        	  Station station  = (Station) ois.readObject(); 	
        	  list.add(station);
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
		return list;
	}

	@Override
	public void updateData(ArrayList<?> list) {
		try {   
            FileOutputStream fis = new FileOutputStream("src/station.dat"); 
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
