package com.AMONIC.Airlines.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AMONIC.Airlines.Entity.Tickets;
import com.AMONIC.Airlines.IService.ITicketsService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/Tickets")
public class TicketsController extends ABaseController< Tickets, ITicketsService> {

	protected TicketsController(ITicketsService service) {
		super(service, "Tickets");
		// TODO Auto-generated constructor stub
	}

}
