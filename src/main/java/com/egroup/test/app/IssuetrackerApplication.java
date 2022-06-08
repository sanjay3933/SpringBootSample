package com.egroup.test.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.egroup.test.app")
public class IssuetrackerApplication {

	public static void main(String[] args)  throws Exception{
		 System.out.println("============ Start");
		 SpringApplication.run(IssuetrackerApplication.class, args);
		 System.out.println("============ Done");
	}
}
