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
	public List<IFiltroReservaDto> getFiltro(int origen, int destino, String fecha, Boolean tresDias,String tipoCabina) throws Exception {
	    System.out.println("Servicio - Origen: " + origen + ", Destino: " + destino + ", Fecha: " + fecha);

	    	System.out.println(fecha + " fecha vacia ");

	    // Convertir fecha vacía a null para evitar el error
	    if ("".equals(fecha)) {
	        fecha = null;
	    }
	    if ("".equals(tipoCabina)) {
	        tipoCabina = null;
	    }
	   
	    return repository.getFiltro(origen, destino, fecha, tresDias, tipoCabina);
	}




	@Override
	public List<IFiltroReservaDto> getSalida() {
		// TODO Auto-generated method stub
		return repository.getSalida();
	}
	
	
	


}
