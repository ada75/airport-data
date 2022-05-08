package com.ada.airportdata.mapper;

import com.ada.airportdata.model.dto.AirportDataDto;
import com.ada.airportdata.model.entity.AirportData;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AirportDataMapper {
    public List<AirportDataDto> entitiesToDtos(final List<AirportData> entities) {
        return entities.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    public AirportDataDto entityToDto(final AirportData airportData) {
        return AirportDataDto.builder()
                .extractDate(airportData.getExtractDate())
                .reportPeriod(airportData.getReportPeriod())
                .terminal(airportData.getTerminal())
                .arrivalDeparture(airportData.getArrivalDeparture())
                .domesticInternational(airportData.getDomesticInternational())
                .passengerCount(airportData.getPassengerCount())
                .build();
    }
}
