package com.AMONIC.Airlines.Service;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AMONIC.Airlines.Entity.Tickets;
import com.AMONIC.Airlines.IRepository.IBaseRepository;
import com.AMONIC.Airlines.IRepository.ITicketsRepository;
import com.AMONIC.Airlines.IService.ITicketsService;
import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;
@Service
public class TicketsService extends ABaseService<Tickets>implements ITicketsService {

	@Override
	protected IBaseRepository<Tickets, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Autowired
	public ITicketsRepository repository;
	

    @Override
    public Tickets save(Tickets entity) throws Exception {
        try {
            Random random = new Random();
            char letter1 = (char) ('A' + random.nextInt(26));
            char letter2 = (char) ('A' + random.nextInt(26));

            
            int digits = 10000 + random.nextInt(90000); 

            String bookingReference = "" + letter1 + letter2 + digits;

            entity.setBookingReference(bookingReference);
        	
            return getRepository().save(entity);
        } catch (Exception e) {
            // Captura la excepción
            throw new Exception("Error al guardar la entidad: " + e.getMessage());
        }
    }

}
