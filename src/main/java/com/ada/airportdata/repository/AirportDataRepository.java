package com.ada.airportdata.repository;

import com.ada.airportdata.model.entity.AirportData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportDataRepository extends JpaRepository<AirportData, Long> {

}
