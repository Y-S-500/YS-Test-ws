package com.AMONIC.Airlines.IService;

import java.sql.Date;
import java.util.List;

import com.AMONIC.Airlines.Dto.IFiltroReservaDto;
import com.AMONIC.Airlines.Entity.Schedules;


public interface ISchedulesService extends IBaseService<Schedules>{

	
	
	
	List<IFiltroReservaDto> getFiltro(int origen, int destino, String fecha,Boolean TresDias,String tipoCabina) throws Exception;
	
	List<IFiltroReservaDto> getSalida();
	


	
  
}
