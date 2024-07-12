package com.AMONIC.Airlines.Service;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

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
	public List<IFiltroReservaDto> getRetorno(String origen, String destino, String fecha, Boolean includeRange) throws Exception {
	    Date fechas = null;
	    if (fecha != null && !fecha.trim().isEmpty()) {
	        try {
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            java.util.Date utilDate = sdf.parse(fecha);
	            fechas = new Date(utilDate.getTime()); 
	        } catch (ParseException e) {
	            
	            throw new RuntimeException("Formato de fecha no válido: " + fecha, e);
	        }
	    }

	    origen = (origen != null && origen.trim().isEmpty()) ? null : origen;
	    destino = (destino != null && destino.trim().isEmpty()) ? null : destino;
	    includeRange = (includeRange != null) ? includeRange : false;
	    System.out.println(origen +" origen ");

	    return repository.getFiltroRetorno(origen, destino, fechas, includeRange);
	}

	@Override
	public List<IFiltroReservaDto> getSalida() {
		// TODO Auto-generated method stub
		return repository.getSalida();
	}


	


	@Override
	public Optional<IFiltroReservaDto> getDetalleS(Long id) {
		// TODO Auto-generated method stub
		return repository.getDetalleS(id);
	}


	@Override
	public List<IFiltroReservaDto> getIda(String origen, String destino, Date fecha, Boolean trediasAD) throws Exception {
	    return repository.getFiltroIda(origen, destino, fecha,trediasAD);
	}
	
}
