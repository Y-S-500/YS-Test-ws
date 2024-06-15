package com.AMONIC.Airlines.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AMONIC.Airlines.Entity.Routes;
import com.AMONIC.Airlines.IService.IRoutesService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/Routes")
public class RoutesController extends ABaseController<Routes, IRoutesService>{

	protected RoutesController(IRoutesService service) {
		super(service, "Routes");
		// TODO Auto-generated constructor stub
	}

}
