package com.aino.training.address;

import java.io.IOException;

public class AddressBookMainAppMenu {

	List<Address> list =new List<Address>();
	public static void main(String[] args) throws IOException {
		new AddressBookMainAppMenu().run();

	}

	private void run() throws IOException {
		/*create a Menu*/
		Menu topMost = new Menu("select your choice",null);
		
		/*create menu items*/
		MenuItem<AddAddressActivity> add = new MenuItem<AddAddressActivity>("Add Address",topMost,new AddAddressActivity(list));
		topMost.addMenuItem(add);
		
		MenuItem<DeleteAddressActivity> delete = new MenuItem<DeleteAddressActivity>("Delete Address",topMost,new DeleteAddressActivity(list));
		topMost.addMenuItem(delete);
		
		Menu inner1 = new Menu("Search Address",topMost);
		topMost.addMenuItem(inner1);
		MenuItem<SearchByID> searchID = new MenuItem<SearchByID>("Search Address by ID",inner1,new SearchByID(null,list));
		inner1.addMenuItem(searchID);
		
		MenuItem<SearchByZip> searchZip = new MenuItem<SearchByZip>("Search Address by Zip",inner1,new SearchByZip(null,list));
		inner1.addMenuItem(searchZip);
		
		MenuItem<DisplayAddressActivity> display = new MenuItem<DisplayAddressActivity>("Display Address",topMost,new DisplayAddressActivity(list));
		topMost.addMenuItem(display);
		
		Menu inner2 = new Menu("Class Loader functionality",topMost);
		topMost.addMenuItem(inner2);
		MenuItem<ClassLoader> loadClass = new MenuItem<ClassLoader>("Load Class Names", inner2, new ClassLoader());
		inner2.addMenuItem(loadClass);
		
		MenuItem<SearchClass> searchClass = new MenuItem<SearchClass>("Search for Class Name", inner2, new SearchClass());
		inner2.addMenuItem(searchClass);
		
		MenuItem<DisplayMethodName> findMethod = new MenuItem<DisplayMethodName>("Display Method Names", inner2, new DisplayMethodName());
		inner2.addMenuItem(findMethod);
		
		MenuItem<Serialization> serialization = new MenuItem<Serialization>("Perform Serialization on current List",topMost,new Serialization(list));
		topMost.addMenuItem(serialization);
		
		MenuItem<Deserialization> deserialization = new MenuItem<Deserialization>("De-Serialization of serialised List",topMost,new Deserialization(list));
		topMost.addMenuItem(deserialization);
		
		topMost.selected();
		//System.out.println();
		//inner.selected();
	}

}
