package com.dev.delta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dev.delta.accountt.Accountt;

@SpringBootApplication
public class SpringbootAccounttApplication implements CommandLineRunner {

	@Autowired
	Accountt accounttService;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAccounttApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		accounttService.populate();
	}

}
