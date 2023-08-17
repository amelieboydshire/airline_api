package com.example.demo.models;

public class PassengerDTO {


    private Long passengerId;
    private String name;
    private Long flightId;


    public PassengerDTO(Long passengerIdid, String name, Long flightId) {
        this.passengerId = passengerId;
        this.name = name;
        this.flightId = flightId;
    }

    public PassengerDTO(){

    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long id) {
        this.passengerId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }
}
