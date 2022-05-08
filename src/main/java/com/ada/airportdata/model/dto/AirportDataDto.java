package com.ada.airportdata.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Builder
@Getter
@Setter
public class AirportDataDto {
    @NotNull
    private ZonedDateTime extractDate;
    @NotNull
    private ZonedDateTime reportPeriod;
    @NotNull
    private String terminal;
    @NotNull
    private String arrivalDeparture;
    @NotNull
    private String domesticInternational;
    @NotNull
    private Integer passengerCount;
}
