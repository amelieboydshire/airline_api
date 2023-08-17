package com.example.demo.components;

import com.example.demo.models.Flight;
import com.example.demo.models.Passenger;
import com.example.demo.repositories.FlightRepository;
import com.example.demo.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public DataLoader(){
    }


    @Override
     public void run(ApplicationArguments args) throws Exception {


        Flight flight1 = new Flight("France", 50, "28-08-23", "3:30");
        flightRepository.save(flight1);

        Passenger passenger1 = new Passenger("Helen Edwards", "helen@gmail.com");
        passengerRepository.save(passenger1);

        Passenger passenger2 = new Passenger("Farai Sekai", "farai@yahoomail.com");
        passenger2.addFlight(flight1);
        passengerRepository.save(passenger2);

        Flight flight2 = new Flight("Spain", 75, "29-08-23", "4:15");
        flightRepository.save(flight2);

        Passenger passenger3 = new Passenger("John Smith", "john@example.com");
        passengerRepository.save(passenger3);

        Passenger passenger4 = new Passenger("Emily Johnson", "emily@example.com");
        passenger4.addFlight(flight2);
        passengerRepository.save(passenger4);

    }












}
