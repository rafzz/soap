
package hello;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.spring.guides.gs_producing_web_service.DeleteCountryResponse;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import io.spring.guides.gs_producing_web_service.GetUsersResponse;
import io.spring.guides.gs_producing_web_service.LoginUserResponse;
import io.spring.guides.gs_producing_web_service.LogoutUserResponse;
import io.spring.guides.gs_producing_web_service.PostCountryRequest;
import io.spring.guides.gs_producing_web_service.PostCountryResponse;
import io.spring.guides.gs_producing_web_service.RegisterUserResponse;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	CommandLineRunner lookup(QuoteClient quoteClient) {
		return args -> {
			
			GetUsersResponse getUsersResponse = quoteClient.getUsers();
			System.err.println(getUsersResponse.getLogins());
			
			RegisterUserResponse registerUserResponse = quoteClient.registerUser();
			System.err.println(registerUserResponse.getMessage());
			getUsersResponse = quoteClient.getUsers();
			System.err.println(getUsersResponse.getLogins());
			
			LoginUserResponse loginUserResponse = quoteClient.loginUser();
			System.err.println(loginUserResponse.getMessage());
			getUsersResponse = quoteClient.getUsers();
			System.err.println(getUsersResponse.getLogins());
			
			PostCountryResponse postCountryResponse = quoteClient
					.postCountry("Greece", "Athen", 99999999, "EUR");
			System.err.println(postCountryResponse.getMessage());
			
			GetCountryResponse getCountryResponse = quoteClient.getCountry("Greece");
			System.err.println(getCountryResponse.getCountry().getName()+"\n"
					+getCountryResponse.getCountry().getCapital()+"\n"
					+getCountryResponse.getCountry().getPopulation()+"\n"
					+getCountryResponse.getCountry().getCurrency()+"\n");
			
			DeleteCountryResponse deleteCountryResponse = quoteClient.deleteCountry("Greece");
			System.err.println(deleteCountryResponse.getMessage());
			System.err.println(deleteCountryResponse.getName());
			
			GetCountryResponse getCountryResponse2 = quoteClient.getCountry("Greece");
			
			System.err.println(getCountryResponse2.getMessage());
			
			LogoutUserResponse logoutUsersResponse = quoteClient.logoutUser();
			System.err.println(logoutUsersResponse.getMessage());
			getUsersResponse = quoteClient.getUsers();
			System.err.println(getUsersResponse.getLogins());
			
		};
	}

}
