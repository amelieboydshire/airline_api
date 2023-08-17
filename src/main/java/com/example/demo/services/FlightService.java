package com.example.demo.services;

import com.example.demo.models.Flight;
import com.example.demo.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {


    @Autowired
    FlightRepository flightRepository;

    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    public Flight findFlight(Long id){
        return flightRepository.findById(id).get();
    }

    public void saveFlight(Flight flight) {
        flightRepository.save(flight);
    }




}
