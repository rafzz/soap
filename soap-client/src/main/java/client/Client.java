package client;

import io.spring.guides.gs_producing_web_service.CountriesPortService;
import io.spring.guides.gs_producing_web_service.GetUsersRequest;

public class Client {
	
	//private CountriesPortService service;
	
	public static  GetUsersRequest showUsers(){
		return new GetUsersRequest();
		
		
	}
	

	public static void main(String[] args) {

		System.err.println(showUsers());

	}

}
