package com.aino.training.address;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings({ "serial", "rawtypes" })
public class Menu extends MenuItem implements Activity, Serializable{
	ArrayList<MenuItem<?>> list = new ArrayList<MenuItem<?>>();
	
	/*Constructor*/
	Menu(String title, Menu parent){
		super(title,parent);
	}

	@Override
	public void execute() throws IOException {
		int ch = 0;
		
		int userChoice = 0;
		
		while(userChoice != ch+1){
			for(MenuItem<?> item : list){
				System.out.println(item.choice + ". " + item.title);
				
				ch = item.choice;
			}
			
			if(parent == null){
				System.out.println(ch + 1 + ". " + "Exit");
			}
			else{
				System.out.println(ch + 1 + ". " + "Go Back");
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter your choice");
			
			try {
				userChoice = Integer.parseInt(br.readLine());
			}catch (IOException e) {
				System.out.println("Exception :" + e);
			}
			
			for(MenuItem<?> item : list){
				if(item.choice == userChoice){
					if(item instanceof Menu){
						
						/*If it is a submenu print the submenu*/
						((Menu)item).execute();
					}
					else{
						item.selected();
					}
				}
			}
		}		
	}

	public void addMenuItem(MenuItem<?> item) {
		list.add(item);
		item.choice = list.size();		
	}

	public void selected() throws IOException {
		execute();
	}
}
