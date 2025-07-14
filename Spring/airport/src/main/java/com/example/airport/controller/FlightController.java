package com.example.airport.controller;

import com.example.airport.enums.FlightStatus;
import com.example.airport.model.Flight;
import com.example.airport.repository.FlightRepository;
import com.example.airport.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightRepository flightRepo;

    private final Random random = new Random();

    @PostMapping
    public String createFlight() {

        for (int i = 0; i < 50; i++) {
            Flight flight = new Flight(
                    null,
                    RandomUtils.randomString(150),
                    RandomUtils.randomString(3),
                    RandomUtils.randomString(3),
                    FlightStatus.ONTIME
            );
            flightRepo.save(flight);
        }
        return "Voli aggiunti";
    }

    @GetMapping
    public List<Flight> findFlights() {
        return flightRepo.findAll();
    }

}
