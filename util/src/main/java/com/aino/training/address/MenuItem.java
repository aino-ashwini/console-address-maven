package com.aino.training.address;

import java.io.IOException;
import java.io.Serializable;

@SuppressWarnings("serial")
public class MenuItem <T extends Activity> implements Serializable{
	
	Menu parent;
	String title;
	int choice;
	T activity;
	
	/*Constructor for Menu*/
	public MenuItem(String title, Menu parent) {
		this.title = title;
		this.parent = parent;
	}
	
	/*Constructor for MenuItem*/
	public MenuItem(String title, Menu parent, T activity){
		this.title = title;
		this.parent = parent;
		this.activity = activity;
	}

	public void selected() throws IOException {
		activity.execute();		
	}

	public void execute() throws IOException {
		// TODO Auto-generated method stub
		
	}
}