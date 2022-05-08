package com.ada.airportdata.controller;

import com.ada.airportdata.model.dto.AirportDataDto;
import com.ada.airportdata.service.AirportDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/airport-data")
public class AirportDataController {

    private final AirportDataService airportDataService;

    @GetMapping
    public List<AirportDataDto> findAll() {
        return airportDataService.findAll();
    }
}
