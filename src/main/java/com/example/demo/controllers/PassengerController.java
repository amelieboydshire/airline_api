package com.example.demo.controllers;

import com.example.demo.models.Passenger;
import com.example.demo.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("passengers")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

//    INDEX
    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        return new ResponseEntity<>(passengerService.findAllPassengers(), HttpStatus.OK);
    }

//    SHOW

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Passenger>> getPassenger(@PathVariable Long id){
        Passenger foundPassenger = passengerService.findPassenger(id);
        return new ResponseEntity(foundPassenger, HttpStatus.OK);
    }

//    CREATE

    @PostMapping
    public ResponseEntity<List<Passenger>> postPassenger(@RequestBody Passenger passenger){
        passengerService.savePassenger(passenger);
        return new ResponseEntity<>(passengerService.findAllPassengers(),HttpStatus.CREATED);
    }




}
