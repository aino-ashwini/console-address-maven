package com.aino.training.address;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddAddressActivity implements Activity{

	private List<Address> list;
	Address a;
	
	public AddAddressActivity(List<Address> list) {
		this.list = list;
	}

	
	public void execute() throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String id, zip, city, state;
			
			System.out.println("In address activity");	
			System.out.println("***Enter Addres details*** ");
			System.out.println("Enter id:");
			id = br.readLine();
			
			System.out.println("Enter zip:");
			zip = br.readLine();
			
			System.out.println("Enter city:");
			city = br.readLine();
			
			System.out.println("Enter state:");
			state = br.readLine();
			
			a = new Address(id, zip, city, state);
			list.addNode(a);
	}
}