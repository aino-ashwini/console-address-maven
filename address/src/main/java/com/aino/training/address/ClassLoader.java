package com.aino.training.address;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassLoader implements Activity {

	public void execute() throws IOException {
		
		@SuppressWarnings("rawtypes")
		ArrayList<Class> classes;
		try {
			classes = new ClassLoader().getClasses("com.aino.training.address");
			
			@SuppressWarnings("rawtypes")
			java.util.Iterator<Class> itr= classes.iterator();  
			
			while(itr.hasNext()){  
				System.out.println(itr.next());
			}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	private ArrayList<Class> getClasses(String packageName)
	        throws ClassNotFoundException, IOException {
	    java.lang.ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	    
	    String path = packageName.replace('.', '/');
	    Enumeration<java.net.URL> resources = classLoader.getResources(path);
	    
	    List<File> dirs = new ArrayList<File>();
	    while (resources.hasMoreElements()) {
	        java.net.URL resource = resources.nextElement();
	        dirs.add(new File(resource.getFile()));
	    }
	    
		ArrayList<Class> classes = new ArrayList<Class>();
	    for (File directory : dirs) {
	        classes.addAll(findClasses(directory, packageName));
	    }
	    return classes;
	}
	
	@SuppressWarnings("rawtypes")
	private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
	    List<Class> classes = new ArrayList<Class>();
	    if (!directory.exists()) {
	        return classes;
	    }
	    File[] files = directory.listFiles();
	    for (File file : files) {
	        if (file.isDirectory()) {
	            if(!file.getName().contains("."));
	            	classes.addAll(findClasses(file, packageName + "." + file.getName()));
	            
	        }
	        else if (file.getName().endsWith(".class")) {
	            classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
	        	
	        }
	    }
	    return classes;
	}
}
