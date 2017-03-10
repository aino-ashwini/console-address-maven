package com.aino.training.address;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization implements Activity {

	List<Address> list;
	public Serialization(List<Address> list) {
		this.list = list;
	}

	public void execute() throws IOException {
		
		FileOutputStream fOut;
		try {
			/*Create new File*/
			fOut = new FileOutputStream("/home/iternia/Desktop/address.txt");
			
			/*Create ObjectOutputStream object and pass FileOutputStream object to it*/
			ObjectOutputStream out = new ObjectOutputStream(fOut);
			
			/*Write Object*/
			out.writeObject(list);
			
			/*Close the Streams*/
			out.close();
			fOut.close();
			System.out.println("Serialized data is saved in address.txt file");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
