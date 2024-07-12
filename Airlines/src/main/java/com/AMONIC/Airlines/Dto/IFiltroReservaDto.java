package com.AMONIC.Airlines.Dto;

import java.sql.Time;
public interface IFiltroReservaDto {
	Integer getId();
    String getOrigen();
    String getDestino();
    String getFecha();
    String getHora(); 
    int getEconomySeats();
    int getBusinessSeats();
    int getNumeroVuelo();
    int getPrecioCabina();
    String getAircraft();
    
    String geTipoCabina();
    int getTotal_seats();
    String getTipoCabina();
    int getAsientosDisponibles();
    
    
    
}
