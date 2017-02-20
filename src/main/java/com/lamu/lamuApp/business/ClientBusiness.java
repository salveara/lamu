package com.lamu.lamuApp.business;

import com.lamu.lamuApp.util.WebException;

public class ClientBusiness {
	
	public void CheckPassword(String password) throws WebException{
		if(password.length() < 7){
			WebException webEx = new WebException();
			webEx.setUserMessage("La contraseña debe ser mayor de 7 caracteres");
			webEx.setTechnicalMessage("password.lenght menor a 7 caracteres");
			throw webEx;
		}
		
	}
	
}
