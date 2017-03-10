package com.aino.training.address;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialization implements Activity{

	List<Address> list ;
	public Deserialization(List<Address> list) {
		this.list = list;
	}

	@SuppressWarnings("unchecked")
	public void execute() throws IOException {
		/*
		 * Create List Object
		 * */
		List<Address> l = null;
		
		try {
			/*Create FileInputStream object for reading file*/
			FileInputStream fIn = new FileInputStream("/home/iternia/Desktop/address.txt");
			
			/*Create ObjectInputStream object*/
			ObjectInputStream in = new ObjectInputStream(fIn);
			
			/*Read the data in the list*/
			l = (List<Address>) in.readObject();
			
			/*Close the streams*/
			in.close();
			fIn.close();
			
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Address class not found");
			c.printStackTrace();
			return;
		}
		System.out.println("Deserializing Address...");
		
		l.display();
	}
}
