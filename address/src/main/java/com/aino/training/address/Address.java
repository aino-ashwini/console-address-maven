package com.aino.training.address;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Address implements Serializable{
	String id;
	String zip;
	String city;
	String state;
	
	Address(){
		
	}
	
	public Address(String id, String zip, String city, String state) {
		super();
		this.id = id;
		this.zip = zip;
		this.city = city;
		this.state = state;
	}
	
	@Override
	public String toString() {
		return this.id + " " + this.zip + " " + this.city + " " + this.state;
	}
	
	public Address getData(String id){
		if(this.id == id)
			return this;
		else
			return null;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof String && this.id != null && this.zip != null){
			if(this.id.equals((String)obj))
				return true;
			else if(this.zip.equals((String)obj))
				return true;
		}
		return super.equals(obj);
	}
}
