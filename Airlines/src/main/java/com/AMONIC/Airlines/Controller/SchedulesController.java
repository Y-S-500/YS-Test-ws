package com.AMONIC.Airlines.Controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.AMONIC.Airlines.Dto.ApiResponseDto;
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
	//filtro solo ida
	@PostMapping("/Filtro")
	public ResponseEntity<ApiResponseDto<List<IFiltroReservaDto>>> filtroIda(@RequestBody FiltroReservaDto filtro) {
	    try {
	 
	        List<IFiltroReservaDto> result = service.getFiltro(filtro.getOrigen(), filtro.getDestino(), filtro.getFechaS(), filtro.getTresDias(),filtro.getTipoCabina());
	        return ResponseEntity.ok(new ApiResponseDto<List<IFiltroReservaDto>>("Datos obtenidos", result, true));
	    } catch (Exception e) {
	        return ResponseEntity.internalServerError().body(new ApiResponseDto<List<IFiltroReservaDto>>(e.getMessage(), null, false));
	    }
	}

	
	@GetMapping("/Salida")
    public ResponseEntity<ApiResponseDto<List<IFiltroReservaDto>>> Salida() {
        try {
        	
	        List<IFiltroReservaDto>   result= service.getSalida();
            return ResponseEntity.ok(new ApiResponseDto<List<IFiltroReservaDto>>("Datos obtenidos", result,true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<IFiltroReservaDto>>(e.getMessage(), null, false));
        }
    }
	

	


}
