package com.aino.training.address;

import java.io.IOException;

public class DisplayAddressActivity implements Activity{

	private List<Address> list;
	
	public DisplayAddressActivity(List<Address> list) {
		this.list = list;
	}

	//@Override
	public void execute() throws IOException {
		list.display();
	}

}
