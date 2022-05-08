package com.ada.airportdata.scheduler;

import com.ada.airportdata.model.entity.AirportData;
import com.ada.airportdata.repository.AirportDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO: Quick & Dirty, better management exception, format control, dto instead of entity, zone, Unit tests, etc
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class AirportDataScheduler {
    private final AirportDataRepository airportDataRepository;

    @Value("${csv.in.folder:/tmp/airport-data/in}")
    private String inFolder;

    @Scheduled(cron = "${scheduler.csv.fetch.cron:0/10 * * * * ?}")
    public void fetchCsv() {
        try {
            File[] files = new File(inFolder).listFiles();

            for (File file : files) {
                CSVFormat csvFormat = CSVFormat.DEFAULT.withDelimiter(',').withFirstRecordAsHeader();

                final CSVParser parsedCsvFile = csvFormat.parse(new InputStreamReader(new ByteArrayInputStream(Files.readAllBytes(file.toPath()))));
                List<AirportData> airportDataList = parsedCsvFile.getRecords()
                        .stream()
                        .map(record -> createAirportData(record))
                        .collect(Collectors.toList());
                airportDataRepository.saveAll(airportDataList);
                file.delete();
            }
        } catch (final Exception ioe) {
            log.error("Exception while parsing csv", ioe);
            System.out.println("Exception while parsing csv " + ioe);
        }
    }

    private AirportData createAirportData(CSVRecord record) {
        return new AirportData(LocalDateTime.parse(record.get(0)).atZone(ZoneId.of("America/Los_Angeles")),
                LocalDateTime.parse(record.get(1)).atZone(ZoneId.of("America/Los_Angeles")),
                record.get(2),
                record.get(3),
                record.get(4),
                Integer.valueOf(record.get(5)));
    }
}
