package com.AMONIC.Airlines.IRepository;

import java.lang.annotation.Native;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.AMONIC.Airlines.Dto.IFiltroReservaDto;
import com.AMONIC.Airlines.Entity.Schedules;



public interface ISchedulesRepository extends IBaseRepository<Schedules, Long> {

	
	
	@Query(value = "SELECT "
			+ "    rou.departure_airportid AS origen,"
			+ "    rou.arrival_airportid AS destino,"
			+ "    sch.date AS fecha,"
			+ "    sch.time AS hora,"
			+ "    sch.flight_number AS numeroVuelo,"
			+ "    airc.economy_seats, "
			+ "    airc.business_seats,"
			+ "    airc.total_seats,"
			+ "    sch.aircraftid"
			+ "FROM "
			+ "    airlines.schedules AS sch"
			+ "INNER JOIN "
			+ "    routes AS rou ON sch.routeid = rou.id"
			+ "INNER JOIN "
			+ "    aircrafts AS airc ON sch.aircraftid = airc.id"
			+ "WHERE "
			
			+ "    -- Filtro de aeropuerto de salida y llegada\r\n"
			+ "    rou.departure_airportid = :origen AND rou.arrival_airportid = :destino "
			+ "    -- Filtro de fechas\r\n"
			+ "    AND sch.date = :fecha;\r\n"
			+ "", nativeQuery = true )
	
    List<IFiltroReservaDto> getFiltroIda(@Param("origen") String origen,
                                      @Param("destino") String destino,
                                      @Param("fecha") Date fecha);
	
	
	@Query(value = "SELECT "
			+ "    rou.departure_airportid AS origen,"
			+ "    rou.arrival_airportid AS destino,"
			+ "    sch.date AS fecha,"
			+ "    sch.time AS hora,"
			+ "    sch.flight_number AS numeroVuelo,"
			+ "    airc.economy_seats, "
			+ "    airc.business_seats,"
			+ "    airc.total_seats,"
			+ "    sch.aircraftid"
			+ "FROM "
			+ "    airlines.schedules AS sch"
			+ "INNER JOIN "
			+ "    routes AS rou ON sch.routeid = rou.id"
			+ "INNER JOIN "
			+ "    aircrafts AS airc ON sch.aircraftid = airc.id"
			+ "WHERE "
			
			+ "    -- Filtro de aeropuerto de salida y llegada\r\n"
			+ "    rou.departure_airportid = :destino AND rou.arrival_airportid = :origen "
			+ "    -- Filtro de fechas\r\n"
			+ "    AND sch.date = :fecha;\r\n"
			+ "", nativeQuery = true )
	
    List<IFiltroReservaDto> getFiltroRetorno(@Param("origen") String origen,
                                      @Param("destino") String destino,
                                      @Param("fecha") Date fecha);
}
