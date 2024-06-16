package com.AMONIC.Airlines.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AMONIC.Airlines.Entity.Offices;
import com.AMONIC.Airlines.IRepository.IBaseRepository;
import com.AMONIC.Airlines.IRepository.IOfficesRepository;
import com.AMONIC.Airlines.IService.IOfficesService;
@Service
public class OfficesService extends ABaseService<Offices> implements IOfficesService {

	@Override
	protected IBaseRepository<Offices, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	@Autowired
	public IOfficesRepository repository;

}
