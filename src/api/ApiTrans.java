package api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.ATMCard;
import model.Bike;
import model.EBike;
import model.Station;
import model.Transaction;
import model.User;

public class ApiTrans implements Apis{

	@Override
	public ArrayList<Transaction> getData() {
		ArrayList<Transaction>  listtrans = new ArrayList<Transaction>();
		
		try {   
            FileInputStream fis = new FileInputStream("src/transaction.dat"); 
           ObjectInputStream ois = new ObjectInputStream(fis);
          while (fis.available() > 0) {
        	  Transaction transaction  = (Transaction) ois.readObject(); 	
        	  listtrans.add(transaction);
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
		return listtrans;
	}

	@Override
	public void updateData(ArrayList<?> list) {
		try {   
            FileOutputStream fis = new FileOutputStream("src/transaction.dat"); 
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
	
	public void updateTransbyName(String name,ArrayList<Transaction> listtrans) {
		for (Transaction tran:listtrans) {
			if (name.equals(tran.getUsername())) {
				if (tran.getStatus()==0) {
					tran.setStatus(1);
				}
			}
		}
	}
	
	public Transaction getTransbyName(String name) {
		Transaction trans = new Transaction();
		ArrayList<Transaction> listtrans = new ArrayList<Transaction>();
		listtrans = getData();
		for (Transaction tran1:listtrans) {
			if (name.equals(tran1.getUsername())) {
				if (tran1.getStatus()==0) {
					trans = tran1;
				}
			}
		}
		return trans;
	}
	
}
