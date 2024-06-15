package com.AMONIC.Airlines.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AMONIC.Airlines.Entity.Countries;
import com.AMONIC.Airlines.IService.ICountriesService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/Countries")
public class CountriesController extends ABaseController<Countries, ICountriesService> {

	protected CountriesController(ICountriesService service) {
		super(service, "Countries");
		// TODO Auto-generated constructor stub
	}

}
