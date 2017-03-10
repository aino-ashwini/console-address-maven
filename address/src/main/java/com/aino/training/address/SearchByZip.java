package com.aino.training.address;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchByZip implements Activity{
	
	private List<Address> list;
	String zip;
	public SearchByZip(String zip,List<Address> list) {
		this.zip = zip;
		this.list = list;
	}
	
	
	public void execute() throws IOException {
		System.out.println("Enter zip to be searched");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		zip = br.readLine();
		
		Address a = list.searchNode(zip);
		System.out.println(a.toString());
	}
}
