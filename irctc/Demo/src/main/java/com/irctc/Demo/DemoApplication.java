package com.irctc.Demo;

import java.sql.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.irctc.Demo.controller.SearchController;
import com.irctc.Demo.dtos.SearchTrainsRequest;
import com.irctc.Demo.dtos.SearchTrainsResponse;
import com.irctc.Demo.models.Stop;
import com.irctc.Demo.models.Train;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		SearchController searchController = new SearchController();
		SearchTrainsRequest request = new SearchTrainsRequest();
		
		Stop s1 = new Stop();
        s1.setName("Thrissur");
        s1.setId(1);
        Stop s2 = new Stop();
        s2.setName("Cochin");
        s2.setId(2);

		request.setStartStop(s1);
		request.setEndStop(s2);
		request.setDateOfJourney(new Date(1000000));

		SearchTrainsResponse response = searchController.searchTrains(request);
		response.printResponse();
	}

}
