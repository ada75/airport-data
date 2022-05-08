# airport-data

### Prerequisites

PostgreSQL
```
CREATE USER "airport-data" PASSWORD 'airport-data';
CREATE DATABASE "airport-data";
REVOKE connect ON DATABASE "airport-data" FROM PUBLIC;
GRANT ALL PRIVILEGES ON DATABASE "airport-data" TO "airport-data";
```

### Run

Launch the Spring Boot application

Copy the file los-angeles-international-airport-passenger-traffic-by-terminal.csv in a folder 
/tmp/airport-data/in

(folder can be overriden with environment variable CSV_IN_FOLDER)

Data are available at endpoint http://localhost:8080/api/airport-data
