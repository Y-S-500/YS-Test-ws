package com.AMONIC.Airlines.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AMONIC.Airlines.Dto.FiltroReservaDto;
import com.AMONIC.Airlines.Dto.IFiltroReservaDto;
import com.AMONIC.Airlines.Entity.Schedules;
import com.AMONIC.Airlines.IService.ISchedulesService;



@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/Schedules")
public class SchedulesController extends ABaseController<Schedules, ISchedulesService> {

	protected SchedulesController(ISchedulesService service) {
		super(service, "Schedules");
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/Filtro")
    public ResponseEntity<ApiResponseDto<List<IFiltroReservaDto>>> filtess(@RequestBody FiltroReservaDto filtro) {
        try {
            return ResponseEntity.ok(new ApiResponseDto<List<IFiltroReservaDto>>("Datos obtenidos", service.getNombre(filtro.getNombre(), filtro.getCiudad()) , true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<IFiltroReservaDto>>(e.getMessage(), null, false));
        }
    }

}
