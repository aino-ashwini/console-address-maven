package com.aino.training.address;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchClass implements Activity{

	public void execute() throws IOException {
		System.out.println("Enter class to be searched: eg: 'com.aino.training.address.AddAddressActivity'");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String searchClass = br.readLine();
		
		try {
			Class<?> c = Class.forName(searchClass);
			System.out.println("Class Found:" + c);
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
	}

}
