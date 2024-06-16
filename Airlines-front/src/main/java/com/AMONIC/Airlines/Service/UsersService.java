package com.AMONIC.Airlines.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AMONIC.Airlines.Entity.Users;
import com.AMONIC.Airlines.IRepository.IBaseRepository;
import com.AMONIC.Airlines.IRepository.IUsersRepository;
import com.AMONIC.Airlines.IService.IUsersService;
@Service
public class UsersService extends ABaseService<Users> implements IUsersService {

	@Override
	protected IBaseRepository<Users, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Autowired 
	public IUsersRepository repository;

}
