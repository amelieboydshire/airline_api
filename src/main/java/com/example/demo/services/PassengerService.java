package com.example.demo.services;

import com.example.demo.models.Flight;
import com.example.demo.models.Passenger;
import com.example.demo.models.PassengerDTO;
import com.example.demo.repositories.FlightRepository;
import com.example.demo.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {


    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    public List<Passenger> findAllPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger findPassenger(Long id) {
        return passengerRepository.findById(id).get();
    }

    public void savePassenger(Passenger passenger){
        passengerRepository.save(passenger);
    }

    public void bookPassengerOnFlight(Long passengerId, Long flightId) {
        Passenger passenger = passengerRepository.findById(passengerId).orElse(null);
        Flight flight = flightRepository.findById(flightId).orElse(null);
        if (passenger != null && flight != null) {
            passenger.getBookedFlights().add(flight);
            passengerRepository.save(passenger);
        } else {
            throw new IllegalArgumentException("Passenger or flight not found.");
        }
    }

    public void cancelFlight(PassengerDTO passengerDTO){
        Passenger passenger = passengerRepository.findById(passengerDTO.getPassengerId()).orElse(null);
        Flight flight = flightRepository.findById(passengerDTO.getFlightId()).orElse(null);
        if (passenger != null && flight != null) {
            passenger.getBookedFlights().remove(flight);
            passengerRepository.save(passenger);
        } else {
            throw new IllegalArgumentException("Passenger or flight not found.");
        }
    }
}





