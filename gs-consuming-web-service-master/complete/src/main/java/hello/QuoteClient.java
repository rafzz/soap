
package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


import io.spring.guides.gs_producing_web_service.GetUsersRequest;
import io.spring.guides.gs_producing_web_service.GetUsersResponse;
import io.spring.guides.gs_producing_web_service.LoginUserRequest;
import io.spring.guides.gs_producing_web_service.LoginUserResponse;
import io.spring.guides.gs_producing_web_service.LogoutUserRequest;
import io.spring.guides.gs_producing_web_service.LogoutUserResponse;
import io.spring.guides.gs_producing_web_service.RegisterUserRequest;
import io.spring.guides.gs_producing_web_service.RegisterUserResponse;


public class QuoteClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(QuoteClient.class);
	
	private final String LOGIN = "user";
	private final String PASSWORD = "user";
	private String UUID;
	

	public GetUsersResponse getUsers() {

		GetUsersRequest request = new GetUsersRequest();

		GetUsersResponse response = (GetUsersResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/countries.wsdl",
						request,
						new SoapActionCallback("http://www.webserviceX.NET/countries"));

		return response;
	}
	
	public RegisterUserResponse registerUser() {

		RegisterUserRequest request = new RegisterUserRequest();
		
		request.setLogin(LOGIN);
		request.setPassword(PASSWORD);

		RegisterUserResponse response = (RegisterUserResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/countries.wsdl",
						request,
						new SoapActionCallback("http://www.webserviceX.NET/countries"));

		return response;
	}
	
	public LoginUserResponse loginUser() {

		LoginUserRequest request = new LoginUserRequest();
		
		request.setLogin(LOGIN);
		request.setPassword(PASSWORD);
		

		LoginUserResponse response = (LoginUserResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/countries.wsdl",
						request,
						new SoapActionCallback("http://www.webserviceX.NET/countries"));

		this.UUID = response.getUuid();
		return response;
	}
	
	public LogoutUserResponse logoutUser() {

		LogoutUserRequest request = new LogoutUserRequest();
		
		request.setLogin(LOGIN);
		request.setPassword(PASSWORD);
		request.setUuid(UUID);
		

		LogoutUserResponse response = (LogoutUserResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/countries.wsdl",
						request,
						new SoapActionCallback("http://www.webserviceX.NET/countries"));

		
		return response;
	}

}
