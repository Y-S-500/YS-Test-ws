package com.AMONIC.Airlines.Controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@PostMapping("/Filtro-Ida")
	public ResponseEntity<ApiResponseDto<List<IFiltroReservaDto>>> filtroIda(@RequestBody FiltroReservaDto filtro) {
	    try {
	    	 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        java.sql.Date fechaDestino = new java.sql.Date(dateFormat.parse(filtro.getFecha()).getTime());
	        System.out.println(filtro.getOrigen() + fechaDestino);
	        
	        
	        List<IFiltroReservaDto> result = service.getIda(filtro.getOrigen(), filtro.getDestino(), fechaDestino,filtro.getTrediasAD());
	        return ResponseEntity.ok(new ApiResponseDto<List<IFiltroReservaDto>>("Datos obtenidos", result, true));
	    } catch (Exception e) {
	        return ResponseEntity.internalServerError().body(new ApiResponseDto<List<IFiltroReservaDto>>(e.getMessage(), null, false));
	    }
	}

		//filtro solo retorno
	@PostMapping("/Filtro-Retorno")
    public ResponseEntity<ApiResponseDto<List<IFiltroReservaDto>>> filtroRetorno(@RequestBody FiltroReservaDto filtro) {
        try {
        	
	        List<IFiltroReservaDto>   result= service.getRetorno(filtro.getOrigen(), filtro.getDestino(),filtro.getFecha(),filtro.getTrediasAD());
            return ResponseEntity.ok(new ApiResponseDto<List<IFiltroReservaDto>>("Datos obtenidos", result,true));
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
	
	  @GetMapping("/detalles/{id}")
	    public ResponseEntity<ApiResponseDto<Optional<IFiltroReservaDto>>> detalls(@PathVariable Long id) {
	        try {
	            Optional<IFiltroReservaDto> result = service.getDetalleS(id);
	            return ResponseEntity.ok(new ApiResponseDto<Optional<IFiltroReservaDto>>("Registro encontrado", result, true));
	        } catch (Exception e) {
	            return ResponseEntity.internalServerError().body(new ApiResponseDto<Optional<IFiltroReservaDto>>(e.getMessage(), null, false));
	        }
	    }
	    

	


}
