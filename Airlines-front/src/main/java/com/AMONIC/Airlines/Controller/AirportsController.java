package com.AMONIC.Airlines.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AMONIC.Airlines.Entity.Airports;
import com.AMONIC.Airlines.IService.IAirportsService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/Airports")
public class AirportsController extends ABaseController<Airports, IAirportsService> {

	protected AirportsController(IAirportsService service) {
		super(service, "Airports");
		// TODO Auto-generated constructor stub
	}

}
