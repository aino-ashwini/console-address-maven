package com.aino.training.address;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchByID implements Activity{

	private List<Address> list;
	String id;
	Address a;
	
	public SearchByID(String id, List<Address> list) {
		this.id = id;
		this.list = list;
	}

	//@Override
	public void execute() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/*Take address id to be searched*/
		System.out.println("Enter id to be searched");
		id = br.readLine();
		
		/*search the address of particular id in the list*/
		Address a = list.searchNode(id);
		System.out.println(a.toString());
	}

}

