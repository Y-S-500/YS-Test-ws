package com.AMONIC.Airlines.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AMONIC.Airlines.Entity.Tickets;
import com.AMONIC.Airlines.IRepository.IBaseRepository;
import com.AMONIC.Airlines.IRepository.ITicketsRepository;
import com.AMONIC.Airlines.IService.ITicketsService;
@Service
public class TicketsService extends ABaseService<Tickets>implements ITicketsService {

	@Override
	protected IBaseRepository<Tickets, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Autowired
	public ITicketsRepository repository;
	

}
