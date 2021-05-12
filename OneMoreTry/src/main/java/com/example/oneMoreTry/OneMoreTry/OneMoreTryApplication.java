package com.example.oneMoreTry.OneMoreTry;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneMoreTryApplication {

	

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(OneMoreTryApplication.class, args);
		System.out.println("Up and Running");
	}

}
