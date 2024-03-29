package com.codeclan.example.pirateservice_d1_starter;

import com.codeclan.example.pirateservice_d1_starter.models.Pirate;
import com.codeclan.example.pirateservice_d1_starter.models.Raid;
import com.codeclan.example.pirateservice_d1_starter.models.Ship;
import com.codeclan.example.pirateservice_d1_starter.repositories.PirateRepository;
import com.codeclan.example.pirateservice_d1_starter.repositories.RaidRepository;
import com.codeclan.example.pirateservice_d1_starter.repositories.ShipRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PirateserviceD1StarterApplicationTests {

	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

	@Test
	public void contextLoads() {
	}

//	@Test
//	public void createSinglePirateAndSave(){
//		Pirate pirate = new Pirate("Jack", "Sparrow", 32);
//		pirateRepository.save(pirate);
//	}

//	@Test
//	public void createPirateAndShip(){
//		Ship ship = new Ship("The Flying Dutchman");
//		shipRepository.save(ship);
//
//		Pirate pirate1 = new Pirate("Jack", "Sparrow", 32, ship);
//		pirateRepository.save(pirate1);
//	}

	@Test
	public void canAddRaidsAndPirates() {
		Ship ship = new Ship("The Flying Dutchman");
		shipRepository.save(ship);

		Pirate pirate1 = new Pirate("Jack", "Sparrow", 32, ship);
		pirateRepository.save(pirate1);

		Pirate pirate2 = new Pirate("John", "Silver", 55, ship);
		pirateRepository.save(pirate2);

		Raid raid1 = new Raid("Tortuga", 100);
		raid1.addPirate(pirate1);
		raidRepository.save(raid1);

		Raid raid2 = new Raid("Glasgow", 200);
		raid2.addPirate(pirate2);
		raid2.addPirate(pirate1);
		raidRepository.save(raid2);

	}
}
