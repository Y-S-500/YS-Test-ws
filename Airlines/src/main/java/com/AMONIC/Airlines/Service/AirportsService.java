package com.AMONIC.Airlines.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AMONIC.Airlines.Entity.Airports;
import com.AMONIC.Airlines.IRepository.IAirportsRepository;
import com.AMONIC.Airlines.IRepository.IBaseRepository;
import com.AMONIC.Airlines.IService.IAirportsService;

@Service
public class AirportsService extends ABaseService< Airports> implements IAirportsService {

	@Override
	protected IBaseRepository<Airports, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Autowired
	public IAirportsRepository repository;

}
