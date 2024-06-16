package com.AMONIC.Airlines.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AMONIC.Airlines.Entity.Aircrafts;
import com.AMONIC.Airlines.IService.IAircraftsService;




@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/Aircrafts")
public class AircraftsController extends ABaseController<Aircrafts, IAircraftsService> {

	protected AircraftsController(IAircraftsService service) {
		super(service, "Aircrafts");
		// TODO Auto-generated constructor stub
	}

}
