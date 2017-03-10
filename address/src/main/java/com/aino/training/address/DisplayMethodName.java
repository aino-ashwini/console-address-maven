package com.aino.training.address;

import java.io.IOException;
import java.lang.reflect.Method;

public class DisplayMethodName implements Activity{

	public void execute() throws IOException {
		@SuppressWarnings("rawtypes")
		Class c;
		try {
			c = Class.forName("com.aino.training.address.Address");
			Method[] methods = c.getMethods();
			for(Method m : methods)
				System.out.println(m);
				
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		
	}

}
