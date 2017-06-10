
package hello;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import io.spring.guides.gs_producing_web_service.GetUsersResponse;
import io.spring.guides.gs_producing_web_service.LoginUserResponse;
import io.spring.guides.gs_producing_web_service.LogoutUserResponse;
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
			
			LogoutUserResponse logoutUsersResponse = quoteClient.logoutUser();
			System.err.println(logoutUsersResponse.getMessage());
			getUsersResponse = quoteClient.getUsers();
			System.err.println(getUsersResponse.getLogins());
			
		};
	}

}
