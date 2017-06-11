
package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import io.spring.guides.gs_producing_web_service.DeleteCountryRequest;
import io.spring.guides.gs_producing_web_service.DeleteCountryResponse;
import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import io.spring.guides.gs_producing_web_service.GetUsersRequest;
import io.spring.guides.gs_producing_web_service.GetUsersResponse;
import io.spring.guides.gs_producing_web_service.LoginUserRequest;
import io.spring.guides.gs_producing_web_service.LoginUserResponse;
import io.spring.guides.gs_producing_web_service.LogoutUserRequest;
import io.spring.guides.gs_producing_web_service.LogoutUserResponse;
import io.spring.guides.gs_producing_web_service.PostCountryRequest;
import io.spring.guides.gs_producing_web_service.PostCountryResponse;
import io.spring.guides.gs_producing_web_service.RegisterUserRequest;
import io.spring.guides.gs_producing_web_service.RegisterUserResponse;


public class QuoteClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(QuoteClient.class);
	
	private final String LOGIN = "user";
	private final String PASSWORD = "user";
	private String UUID;
	private String COUNTRY_NAME="Greece";
	

	public GetUsersResponse getUsers() {

		GetUsersRequest request = new GetUsersRequest();

		GetUsersResponse response = (GetUsersResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/countries.wsdl",
						request,
						new SoapActionCallback("http://ws/getUsers"));

		return response;
	}
	
	public RegisterUserResponse registerUser() {

		RegisterUserRequest request = new RegisterUserRequest();
		
		request.setLogin(LOGIN);
		request.setPassword(PASSWORD);

		RegisterUserResponse response = (RegisterUserResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/countries.wsdl",
						request,
						new SoapActionCallback("http://ws/registerUser"));

		return response;
	}
	
	public LoginUserResponse loginUser() {

		LoginUserRequest request = new LoginUserRequest();
		
		request.setLogin(LOGIN);
		request.setPassword(PASSWORD);
		

		LoginUserResponse response = (LoginUserResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/countries.wsdl",
						request,
						new SoapActionCallback("http://ws/loginUser"));

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
						new SoapActionCallback("http://ws/logoutUser"));

		
		return response;
	}
	
	public GetCountryResponse getCountry(String name) {

		GetCountryRequest request = new GetCountryRequest();
		
		request.setLogin(LOGIN);
		request.setPassword(PASSWORD);
		request.setUuid(UUID);
		request.setName(name);
		
		
		

		GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/countries.wsdl",
						request,
						new SoapActionCallback("http://ws/getCountry"));

		
		
		return response;
	}
	
	private final String POSTED_MESSAGE = "Posted country: ";
	
	public PostCountryResponse postCountry(String name, String capital, int population, String currency) {

		PostCountryRequest request = new PostCountryRequest();
		
		request.setLogin(LOGIN);
		request.setPassword(PASSWORD);
		request.setUuid(UUID);
		
		request.setName(name);
		request.setCapital(capital);
		request.setPopulation(population);
		request.setCurrency(currency);
		
		
		

		PostCountryResponse response = (PostCountryResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/countries.wsdl",
						request,
						new SoapActionCallback("http://ws/getCountry"));

		response.setMessage(POSTED_MESSAGE);
		
		return response;
	}
	
	private final String DELETE_MESSAGE = "Deleted country: ";
	
	public DeleteCountryResponse deleteCountry(String name) {

		DeleteCountryRequest request = new DeleteCountryRequest();
		
		request.setLogin(LOGIN);
		request.setPassword(PASSWORD);
		request.setUuid(UUID);
		request.setName(name);
		

		DeleteCountryResponse response = (DeleteCountryResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/countries.wsdl",
						request,
						new SoapActionCallback("http://ws/getCountry"));

		response.setMessage(DELETE_MESSAGE);
		
		
		return response;
	}

}
