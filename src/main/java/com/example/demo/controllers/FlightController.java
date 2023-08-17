package com.example.demo.controllers;


import com.example.demo.models.Flight;
import com.example.demo.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("flights")
public class FlightController {


    @Autowired
    FlightService flightService;

//    INDEX
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){
        return new ResponseEntity<>(flightService.findAllFlights(), HttpStatus.OK);
    }

//    SHOW

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Flight>> getFlight(@PathVariable Long id){
        Flight foundFlight = flightService.findFlight(id);
        return new ResponseEntity(foundFlight, HttpStatus.OK);
    }


//    CREATE

    @PostMapping
    public ResponseEntity<List<Flight>> postFlight(@RequestBody Flight flight) {
        flightService.saveFlight(flight);
        return new ResponseEntity(flightService.findAllFlights(), HttpStatus.CREATED);
    }









}
