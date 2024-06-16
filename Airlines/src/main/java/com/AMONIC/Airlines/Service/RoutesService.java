package com.AMONIC.Airlines.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AMONIC.Airlines.Entity.Routes;
import com.AMONIC.Airlines.IRepository.IBaseRepository;
import com.AMONIC.Airlines.IRepository.IRoutesRepository;
import com.AMONIC.Airlines.IService.IRoutesService;
@Service
public class RoutesService extends ABaseService< Routes> implements IRoutesService{

	@Override
	protected IBaseRepository<Routes, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	@Autowired 
	public IRoutesRepository repository;

	
}
