package com.java.technica.exercise.generaterandomstring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GenerateRandomStringApplication {



	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(GenerateRandomStringApplication.class, args);
		UpworkJavaExercise upworkJavaExercise = applicationContext.getBean(UpworkJavaExercise.class);
		upworkJavaExercise.execute();

	}


}
