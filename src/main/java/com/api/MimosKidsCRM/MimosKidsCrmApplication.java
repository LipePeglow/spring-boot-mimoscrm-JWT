package com.api.MimosKidsCRM;

import com.api.MimosKidsCRM.auth.AuthenticationService;
import com.api.MimosKidsCRM.auth.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.api.MimosKidsCRM.user.Role.ADMIN;

@SpringBootApplication
public class MimosKidsCrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(MimosKidsCrmApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			var admin = RegisterRequest.builder()
					.name("Admin")
					.email("admin@mail.com")
					.password("password")
					.role(ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());

		};
	}
}
