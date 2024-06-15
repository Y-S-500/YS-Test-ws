package com.AMONIC.Airlines.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AMONIC.Airlines.Entity.CabinTypes;
import com.AMONIC.Airlines.IService.ICabinTypesService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/CabinTypes")
public class CabinTypesController extends ABaseController<CabinTypes, ICabinTypesService> {

	protected CabinTypesController(ICabinTypesService service) {
		super(service, "CabinTypes");
		// TODO Auto-generated constructor stub
	}

}
