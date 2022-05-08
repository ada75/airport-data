package com.ada.airportdata.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Entity
@Table(name = "airport_data")
public class AirportData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "extract_date", nullable = false)
    private ZonedDateTime extractDate;

    @Column(name = "report_period", nullable = false)
    private ZonedDateTime reportPeriod;

    @Column(name = "terminal", nullable = false)
    private String terminal;

    @Column(name = "arrival_departure", nullable = false)
    private String arrivalDeparture;

    @Column(name = "domestic_international", nullable = false)
    private String domesticInternational;

    @Column(name = "passenger_count", nullable = false)
    private Integer passengerCount;

    public ZonedDateTime getExtractDate() {
        return extractDate;
    }

    public ZonedDateTime getReportPeriod() {
        return reportPeriod;
    }

    public String getTerminal() {
        return terminal;
    }

    public String getArrivalDeparture() {
        return arrivalDeparture;
    }

    public String getDomesticInternational() {
        return domesticInternational;
    }

    public Integer getPassengerCount() {
        return passengerCount;
    }

    public AirportData() {
    }

    public AirportData(ZonedDateTime extractDate, ZonedDateTime reportPeriod, String terminal, String arrivalDeparture, String domesticInternational, Integer passengerCount) {
        this.extractDate = extractDate;
        this.reportPeriod = reportPeriod;
        this.terminal = terminal;
        this.arrivalDeparture = arrivalDeparture;
        this.domesticInternational = domesticInternational;
        this.passengerCount = passengerCount;
    }
}
