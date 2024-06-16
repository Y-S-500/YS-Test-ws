package com.AMONIC.Airlines.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AMONIC.Airlines.Entity.Roles;
import com.AMONIC.Airlines.IService.IRolesService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/Roles")
public class RolesController extends ABaseController<Roles, IRolesService> {

	protected RolesController(IRolesService service) {
		super(service, "Roles");
		// TODO Auto-generated constructor stub
	}

}
