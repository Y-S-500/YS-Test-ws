package com.AMONIC.Airlines.IRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.AMONIC.Airlines.Dto.IFiltroReservaDto;
import com.AMONIC.Airlines.Entity.Schedules;




public interface ISchedulesRepository extends IBaseRepository<Schedules, Long> {


	 @Query(value = "SELECT " +
             "sch.id AS id, " +
             "coun1.name AS origen, " +
             "coun2.name AS destino, " +
             "sch.date AS fecha, " +
             "sch.time AS hora, " +
             "sch.economy_price AS precioCabina, " +
             "sch.flight_number AS numeroVuelo, " +
             "airc.economy_seats AS precioEconomico, " +
             "airc.business_seats AS precioEjecutivo, " +
             "airc.total_seats As totalSeats, " +
             "sch.aircraftid " +
             "FROM airlines.schedules AS sch " +
             "INNER JOIN routes AS rou ON sch.routeid = rou.id " +
             "INNER JOIN aircraftse AS airc ON sch.aircraftid = airc.id " +
             "INNER JOIN airports AS air1 ON air1.id = rou.departure_airportid " +
             "INNER JOIN airports AS air2 ON air2.id = rou.arrival_airportid " +
             "INNER JOIN countries AS coun1 ON air1.countryid = coun1.id " +
             "INNER JOIN countries AS coun2 ON air2.countryid = coun2.id " +
             "WHERE LOWER(coun1.name) = LOWER(:origen) " +
             "AND LOWER(coun2.name) = LOWER(:destino) " +
             "AND (CASE WHEN :includeRange = true THEN sch.date BETWEEN DATE_SUB(:fecha, INTERVAL 3 DAY) AND DATE_ADD(:fecha, INTERVAL 3 DAY) ELSE sch.date = :fecha END)", nativeQuery = true)
List<IFiltroReservaDto> getFiltroIda(@Param("origen") String origen,
                                   @Param("destino") String destino,
                                   @Param("fecha") Date fecha,
                                   @Param("includeRange") boolean includeRange);
	 
	 
	 @Query(value = "SELECT sch.id AS id, " +
             "coun1.name AS origen, " +
             "coun2.name AS destino, " +
             "sch.date AS fecha, " +
             "sch.time AS hora, " +
             "sch.economy_price AS precioCabina, " +
             "sch.flight_number AS numeroVuelo, " +
             "airc.economy_seats AS precioEconomico, " +
             "airc.business_seats AS precioEjecutivo, " +
             "airc.total_seats As totalSeats, " +
             "sch.aircraftid " +
             "FROM airlines.schedules AS sch " +
             "INNER JOIN routes AS rou ON sch.routeid = rou.id " +
             "INNER JOIN aircrafts AS airc ON sch.aircraftid = airc.id " +
             "INNER JOIN airports AS air1 ON air1.id = rou.departure_airportid " +
             "INNER JOIN airports AS air2 ON air2.id = rou.arrival_airportid " +
             "INNER JOIN countries AS coun1 ON air1.countryid = coun1.id " +
             "INNER JOIN countries AS coun2 ON air2.countryid = coun2.id " +
             "WHERE (:origen IS NULL OR LOWER(coun1.name) = LOWER(:origen)) " +
             "AND (:destino IS NULL OR LOWER(coun2.name) = LOWER(:destino)) " +
             "AND (CASE " +
             "     WHEN :fecha IS NULL THEN TRUE " +
             "     WHEN :includeRange = TRUE THEN sch.date BETWEEN DATE_SUB(:fecha, INTERVAL 3 DAY) AND DATE_ADD(:fecha, INTERVAL 3 DAY) " +
             "     ELSE sch.date = :fecha " +
             "     END)", nativeQuery = true)
List<IFiltroReservaDto> getFiltroRetorno(@Param("origen") String origen,
                                       @Param("destino") String destino,
                                       @Param("fecha") Date fecha,
                                       @Param("includeRange") Boolean includeRange);

	
	@Query(value = "SELECT \r\n"
			+"      sch.id AS id,      \r\n   "
			+ "    coun1.name AS origen,\r\n"
			+ "    coun2.name AS destino,\r\n"
			+ "    sch.date AS fecha,\r\n"
			+ "    sch.time AS hora,\r\n"
			+ "    sch.economy_price AS precioCabina,\r\n"
	        
			+ "    sch.flight_number AS numeroVuelo,\r\n"
			+ "    airc.economy_seats AS precioEconomico, \r\n"
		    + "    airc.business_seats AS precioEjecutivo,\r\n"
			+ "    airc.total_seats As totalSeats,\r\n"
			+ "    sch.aircraftid\r\n"
			+ "FROM \r\n"
			+ "    airlines.schedules AS sch\r\n"
			+ "INNER JOIN \r\n"
			+ "    routes AS rou ON sch.routeid = rou.id\r\n"
			+ "INNER JOIN \r\n"
			+ "    aircrafts AS airc ON sch.aircraftid = airc.id\r\n"
			+ "INNER JOIN \r\n"
			+ "    airports AS air1 ON air1.id = rou.departure_airportid\r\n"
			+ "INNER JOIN \r\n"
			+ "    airports AS air2 ON air2.id = rou.arrival_airportid\r\n"
			+ "INNER JOIN \r\n"
			+ "    countries AS coun1 ON air1.countryid = coun1.id\r\n"
			+ "INNER JOIN \r\n"
			+ "    countries AS coun2 ON air2.countryid = coun2.id\r\n"
			+ "WHERE \r\n"
			+ "    LOWER(coun1.name) = 'neiva'\r\n"
			+ "    AND LOWER(coun2.name) = 'bogota';\r\n"
			+ "", nativeQuery = true)
	List<IFiltroReservaDto> getSalida();
	
	
	
	@Query(value = "SELECT \r\n"
			+ "    sch.id AS id,\r\n"
			+ "    coun1.name AS origen,\r\n"
			+ "    coun2.name AS destino,\r\n"
			+ "    sch.date AS fecha,\r\n"
			+ "    sch.time AS hora,\r\n"
			+ "    sch.economy_price AS precioCabina,\r\n"
			+ "    sch.flight_number AS numeroVuelo,\r\n"
			+ "    airc.economy_seats AS precioEconomico,\r\n"
			+ "    airc.business_seats AS precioEjecutivo,\r\n"
			+ "    airc.total_seats AS totalSeats,\r\n"
			+ "    sch.aircraftid\r\n"
			+ "FROM \r\n"
			+ "    airlines.schedules AS sch\r\n"
			+ "INNER JOIN \r\n"
			+ "    routes AS rou ON sch.routeid = rou.id\r\n"
			+ "INNER JOIN \r\n"
			+ "    aircrafts AS airc ON sch.aircraftid = airc.id\r\n"
			+ "INNER JOIN \r\n"
			+ "    airports AS air1 ON air1.id = rou.departure_airportid\r\n"
			+ "INNER JOIN \r\n"
			+ "    airports AS air2 ON air2.id = rou.arrival_airportid\r\n"
			+ "INNER JOIN \r\n"
			+ "    countries AS coun1 ON air1.countryid = coun1.id\r\n"
			+ "INNER JOIN \r\n"
			+ "    countries AS coun2 ON air2.countryid = coun2.id\r\n"
			+ "WHERE \r\n"
			+ "   sch.id = :id",nativeQuery = true)
	Optional<IFiltroReservaDto> getDetalleS(@Param("id") Long id);







}
