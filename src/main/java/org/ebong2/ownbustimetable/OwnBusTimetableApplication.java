package org.ebong2.ownbustimetable;

import org.ebong2.ownbustimetable.bus.BusInquirer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class OwnBusTimetableApplication {

	@Autowired
	BusInquirer busInquirer;

	public static void main(String[] args) {
		SpringApplication.run(OwnBusTimetableApplication.class, args);
	}
}
