package com.ada.airportdata.service;

import com.ada.airportdata.mapper.AirportDataMapper;
import com.ada.airportdata.model.dto.AirportDataDto;
import com.ada.airportdata.repository.AirportDataRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

// Useful test when there is business logic in service; here, useless
@ExtendWith(MockitoExtension.class)
public class AirportDataServiceTest {
    @Mock
    private AirportDataRepository airportDataRepository;
    @Mock
    private AirportDataMapper airportDataMapper;

    @InjectMocks
    private AirportDataService airportDataService;

    @Test
    public void given_data_should_manipulate_them() {
        when(airportDataRepository.findAll()).thenReturn(Collections.emptyList());
        List<AirportDataDto> res = airportDataService.findAll();
        assertThat(res).isEmpty();
        verifyNoMoreInteractions(airportDataRepository);
    }

}
