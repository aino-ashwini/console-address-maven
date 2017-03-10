package com.aino.training.address;

import java.io.BufferedReader;
import com.aino.training.address.Activity;

import java.io.IOException;
import java.io.InputStreamReader;

public class DeleteAddressActivity implements Activity{

	private List<Address> list;
	
	public DeleteAddressActivity(List<Address> list) {
		this.list = list;
	}

	//@Override
	public void execute() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*Take address id to be deleted*/
		System.out.println("Enter id to be deleted");
		String id = br.readLine();
		
		/*search address to be deleted*/
		Address a = list.searchNode(id);
		
		/*remove address from the list*/
		list.removeNode(a);
	}

}
