package com.AMONIC.Airlines.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AMONIC.Airlines.Entity.Users;
import com.AMONIC.Airlines.IService.IUsersService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/Users")
public class UsersController extends ABaseController<Users, IUsersService> {

	protected UsersController(IUsersService service) {
		super(service, "Users");
		// TODO Auto-generated constructor stub
	}

}
