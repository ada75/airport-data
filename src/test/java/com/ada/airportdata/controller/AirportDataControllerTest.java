package com.ada.airportdata.controller;

import com.ada.airportdata.model.entity.AirportData;
import com.ada.airportdata.repository.AirportDataRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class AirportDataControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private AirportDataRepository airportDataRepository;

    @Test
    public void find_all_with_empty_table_should_return_empty() throws Exception {
        mockMvc.perform(get("/api/airport-data"))
                .andExpect(status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", empty()));
    }

    @Test
    public void find_all_with_filled_table_should_return_data() throws Exception {
        AirportData airportData = new AirportData(ZonedDateTime.now(), ZonedDateTime.now(), "term", "arrDep", "Domestic", 233);
        airportDataRepository.save(airportData);
        mockMvc.perform(get("/api/airport-data"))
                .andExpect(status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].terminal", Matchers.is("term")))
                .andExpect(jsonPath("$[0].arrivalDeparture", Matchers.is("arrDep")));
    }
}
