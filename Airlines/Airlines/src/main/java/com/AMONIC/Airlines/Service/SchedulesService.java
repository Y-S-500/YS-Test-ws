package com.AMONIC.Airlines.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
