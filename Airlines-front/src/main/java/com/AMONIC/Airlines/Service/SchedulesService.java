package com.AMONIC.Airlines.Service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AMONIC.Airlines.Dto.IFiltroReservaDto;
import com.AMONIC.Airlines.Entity.Schedules;
import com.AMONIC.Airlines.IRepository.IBaseRepository;
import com.AMONIC.Airlines.IRepository.ISchedulesRepository;
import com.AMONIC.Airlines.IService.ISchedulesService;
@Service
public class SchedulesService extends ABaseService<Schedules> implements ISchedulesService {

	@Override
	protected IBaseRepository<Schedules, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	@Autowired
	public ISchedulesRepository repository;
	
	@Override
	public List<IFiltroReservaDto> getIda(String origen, String destino, Date fecha) throws Exception {
	    System.out.println("Servicio - Origen: " + origen + ", Destino: " + destino + ", Fecha: " + fecha);
	    return repository.getFiltroIda(origen, destino, fecha);
	}


	@Override
	public List<IFiltroReservaDto> getRetorno(String destino, String origen, Date fecha) throws Exception {
		// TODO Auto-generated method stub
		return repository.getFiltroRetorno(origen, destino, fecha);
	}


	@Override
	public List<IFiltroReservaDto> getSalida() {
		// TODO Auto-generated method stub
		return repository.getSalida();
	}
	
	
	


}
