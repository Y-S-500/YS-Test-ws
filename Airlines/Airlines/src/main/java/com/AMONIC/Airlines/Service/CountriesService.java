package com.AMONIC.Airlines.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AMONIC.Airlines.Entity.Countries;
import com.AMONIC.Airlines.IRepository.IBaseRepository;
import com.AMONIC.Airlines.IRepository.ICountriesRepository;
import com.AMONIC.Airlines.IService.ICountriesService;
@Service
public class CountriesService extends ABaseService<Countries> implements ICountriesService{

	@Override
	protected IBaseRepository<Countries, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	@Autowired
	public ICountriesRepository repository;

}
