package com.AMONIC.Airlines.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AMONIC.Airlines.Entity.CabinTypes;
import com.AMONIC.Airlines.IRepository.IBaseRepository;
import com.AMONIC.Airlines.IRepository.ICabinTypesRepository;
import com.AMONIC.Airlines.IService.ICabinTypesService;
@Service
public class CabinTypesService extends ABaseService<CabinTypes> implements ICabinTypesService{

	@Override
	protected IBaseRepository<CabinTypes, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Autowired
	public ICabinTypesRepository repository;

}
