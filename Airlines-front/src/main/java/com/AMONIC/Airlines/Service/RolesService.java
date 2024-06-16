package com.AMONIC.Airlines.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AMONIC.Airlines.Entity.Roles;
import com.AMONIC.Airlines.IRepository.IBaseRepository;
import com.AMONIC.Airlines.IRepository.IRolesRepository;
import com.AMONIC.Airlines.IService.IRolesService;
@Service
public class RolesService extends ABaseService<Roles> implements IRolesService{

	@Override
	protected IBaseRepository<Roles, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	@Autowired
	public IRolesRepository repository;

	
}
