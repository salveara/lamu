package com.lamu.lamuApp.dto;

public class ClientDto{
	
	private String name;
	private String email;
	private String password;
	private String phone;
	
	public ClientDto(){
	}
	
	public ClientDto(String name, String password, String email, String phone) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public String getEmail(){
		return email;
	}
	public void setName(String email){
		this.email = email;
	}
	
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPhone(){
		return phone;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
}

