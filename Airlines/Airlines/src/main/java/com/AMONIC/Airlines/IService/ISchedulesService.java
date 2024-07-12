package com.AMONIC.Airlines.IService;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.AMONIC.Airlines.Dto.IFiltroReservaDto;
import com.AMONIC.Airlines.Entity.Schedules;

public interface ISchedulesService extends IBaseService<Schedules>{

	
	List<IFiltroReservaDto> getIda(String origen, String destino, Date fecha,Boolean trediasAD ) throws Exception;
	
	List<IFiltroReservaDto> getRetorno( String destino,String origen, String fecha, Boolean trediasAD) throws Exception;

	List<IFiltroReservaDto> getSalida();
	
	Optional<IFiltroReservaDto> getDetalleS(Long id);

	

}
