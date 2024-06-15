package com.AMONIC.Airlines.IService;

import com.AMONIC.Airlines.Entity.Schedules;

import jakarta.validation.constraints.AssertFalse.List;

public interface ISchedulesService extends IBaseService<Schedules>{

	
   List<IIFiltroReservaDto> getFiltroReserva();
}
