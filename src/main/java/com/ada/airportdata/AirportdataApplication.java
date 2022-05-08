package com.ada.airportdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AirportdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirportdataApplication.class, args);
	}

}
