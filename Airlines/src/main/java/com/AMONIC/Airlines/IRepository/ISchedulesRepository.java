package com.AMONIC.Airlines.IRepository;

import java.lang.annotation.Native;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.AMONIC.Airlines.Dto.IFiltroReservaDto;
import com.AMONIC.Airlines.Entity.Schedules;

import io.swagger.v3.oas.annotations.Parameter;


@Repository
public interface ISchedulesRepository extends IBaseRepository<Schedules, Long> {
	
	 @Query(value = "SELECT\r\n"
	            + "    sch.id AS id,\r\n"
	            + "    coun1.name AS origen,\r\n"
	            + "    coun2.name AS destino,\r\n"
	            + "    sch.date AS fecha,\r\n"
	            + "    sch.time AS hora,\r\n"
	            + "    airc.name AS aircraft,\r\n"
	            + "    CASE\r\n"
	            + "        WHEN :tipoCabina = 2 THEN sch.economy_price * 1.30\r\n"
	            + "        ELSE sch.economy_price\r\n"
	            + "    END AS precioCabina,\r\n"
	            + "    sch.flight_number AS numeroVuelo,\r\n"
	            + "    airc.economy_seats AS economySeats,\r\n"
	            + "    airc.business_seats AS businessSeats,\r\n"
	            + "    airc.total_seats,\r\n"
	            + "    sch.aircraftid,\r\n"
	            + "    CASE\r\n"
	            + "        WHEN tc.tipoCabina = 'Economy' THEN \r\n"
	            + "            airc.economy_seats - SUM(CASE WHEN t.cabin_typeid = 1 AND t.confirmed = true THEN 1 ELSE 0 END)\r\n"
	            + "        WHEN tc.tipoCabina = 'Business' THEN \r\n"
	            + "            airc.business_seats - SUM(CASE WHEN t.cabin_typeid = 2 AND t.confirmed = true THEN 1 ELSE 0 END)\r\n"
	            + "    END AS asientosDisponibles,\r\n"
	            + "    tc.tipoCabina\r\n"
	            + "FROM\r\n"
	            + "    airlines.schedules AS sch\r\n"
	            + "INNER JOIN\r\n"
	            + "    routes AS rou ON sch.routeid = rou.id\r\n"
	            + "INNER JOIN\r\n"
	            + "    aircrafts AS airc ON sch.aircraftid = airc.id\r\n"
	            + "INNER JOIN\r\n"
	            + "    airports AS air1 ON air1.id = rou.departure_airportid\r\n"
	            + "INNER JOIN\r\n"
	            + "    airports AS air2 ON air2.id = rou.arrival_airportid\r\n"
	            + "INNER JOIN\r\n"
	            + "    countries AS coun1 ON air1.countryid = coun1.id\r\n"
	            + "INNER JOIN\r\n"
	            + "    countries AS coun2 ON air2.countryid = coun2.id\r\n"
	            + "LEFT JOIN\r\n"
	            + "    tickets t ON t.scheduleid = sch.id AND t.confirmed = true\r\n"
	            + "CROSS JOIN\r\n"
	            + "    (SELECT 'Economy' AS tipoCabina UNION SELECT 'Business' AS tipoCabina) AS tc\r\n"
	            + "WHERE\r\n"
	            + "    LOWER(rou.departure_airportid) = LOWER(:origen)\r\n"
	            + "    AND LOWER(rou.arrival_airportid) = LOWER(:destino)\r\n"
	            + "    AND (\r\n"
	            + "        (:fecha IS NULL)\r\n"
	            + "        OR (:tres = FALSE AND sch.date = :fecha)\r\n"
	            + "        OR (:tres = TRUE AND sch.date BETWEEN DATE_SUB(:fecha, INTERVAL 3 DAY) AND DATE_ADD(:fecha, INTERVAL 3 DAY))\r\n"
	            + "    )\r\n"
	            + "    AND (\r\n"
	            + "        :tipoCabina IS NULL\r\n"
	            + "        OR (:tipoCabina = 1 AND tc.tipoCabina = 'Economy')\r\n"
	            + "        OR (:tipoCabina = 2 AND tc.tipoCabina = 'Business')\r\n"
	            + "    )\r\n"
	            + "GROUP BY\r\n"
	            + "    sch.id, origen, destino, fecha, hora, aircraft, precioCabina, numeroVuelo, economySeats, businessSeats, total_seats, aircraftid, tc.tipoCabina\r\n"
	            + "HAVING\r\n"
	            + "    (tc.tipoCabina = 'Economy' AND asientosDisponibles > 0)\r\n"
	            + "    OR (tc.tipoCabina = 'Business' AND asientosDisponibles > 0)\r\n",nativeQuery = true)
	    List<IFiltroReservaDto> getFiltro(@Param("origen") int origen,
	            @Param("destino") int destino,
	            @Param("fecha") String fecha,
	            @Param("tres") Boolean tres,
	            @Param("tipoCabina") String tipoCabina);





	
	
	@Query(value = "SELECT \r\n"
			+"      sch.id AS id,      \r\n   "
			+ "    coun1.name AS destino,\r\n"
			+ "    coun2.name AS origen,\r\n"
			+ "    sch.date AS fecha,\r\n"
			+ "    sch.time AS hora,\r\n"
			+ "    sch.flight_number AS numeroVuelo,\r\n"
			+ "    airc.economy_seats AS precioCabina,\r\n"
			+ "    airc.business_seats,\r\n"
			+ "    airc.total_seats,\r\n"
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



}
