package com.ada.airportdata.service;

import com.ada.airportdata.mapper.AirportDataMapper;
import com.ada.airportdata.model.dto.AirportDataDto;
import com.ada.airportdata.repository.AirportDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AirportDataService {

    private final AirportDataRepository airportDataRepository;

    private final AirportDataMapper airportDataMapper;

    @Transactional(readOnly = true)
    public List<AirportDataDto> findAll(){
        return airportDataMapper.entitiesToDtos(airportDataRepository.findAll());
    }

}
