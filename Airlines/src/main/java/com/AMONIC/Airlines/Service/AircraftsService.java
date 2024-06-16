package com.AMONIC.Airlines.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AMONIC.Airlines.Entity.Aircrafts;
import com.AMONIC.Airlines.IRepository.IAircraftsRepository;
import com.AMONIC.Airlines.IRepository.IBaseRepository;
import com.AMONIC.Airlines.IService.IAircraftsService;


@Service
public class AircraftsService extends ABaseService<Aircrafts> implements IAircraftsService{

	@Override
	protected IBaseRepository<Aircrafts, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Autowired
	public IAircraftsRepository repository;

	
}
