package com.AMONIC.Airlines.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AMONIC.Airlines.Entity.Offices;
import com.AMONIC.Airlines.IService.IOfficesService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/Offices")
public class OfficesController extends ABaseController< Offices, IOfficesService> {

	protected OfficesController(IOfficesService service) {
		super(service, "Offices");
		// TODO Auto-generated constructor stub
	}

}
