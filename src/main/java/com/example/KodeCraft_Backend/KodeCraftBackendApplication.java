package com.example.KodeCraft_Backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class KodeCraftBackendApplication {


	public static void main(String[] args) {
	SpringApplication.run(KodeCraftBackendApplication.class, args);
	}

}
