package com.AMONIC.Airlines.IService;

import java.sql.Date;
import java.util.List;

import com.AMONIC.Airlines.Dto.IFiltroReservaDto;
import com.AMONIC.Airlines.Entity.Schedules;


public interface ISchedulesService extends IBaseService<Schedules>{

	
	
	
	List<IFiltroReservaDto> getIda(String origen, String destino, Date fecha) throws Exception;
	
	List<IFiltroReservaDto> getRetorno( String destino,String origen, Date fecha) throws Exception;

	List<IFiltroReservaDto> getSalida();
	


	
  
}
