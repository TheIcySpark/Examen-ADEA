package com.adea.evaluation;

import com.adea.evaluation.model.UserModel;
import com.adea.evaluation.repository.UserRepository;
import com.adea.evaluation.utilities.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class EvaluationApplication {


	public static void main(String[] args) {
		SpringApplication.run(EvaluationApplication.class, args);
	}
}

@Component
class MyApplicationRunner implements ApplicationRunner {
	@Autowired
	UserRepository userRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// Create default users
		for(int i = 1 ; i <= 3; i++){
			String login = "default" + i;
			String name = "cliente" + i;
			String  password = "password" + i;
			UserModel user = userRepository.findByLogin(login);
			if(user == null){
				CustomPasswordEncoder customPasswordEncoder = new CustomPasswordEncoder();
				String encodedPassword = customPasswordEncoder.encode(password);
				userRepository.save(new UserModel(login, encodedPassword, name, 1));
			}
		}
	}
}