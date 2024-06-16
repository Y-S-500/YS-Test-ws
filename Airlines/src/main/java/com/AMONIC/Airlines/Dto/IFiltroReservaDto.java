package com.AMONIC.Airlines.Dto;

import java.sql.Time;
public interface IFiltroReservaDto {
	Integer getId();
    String getOrigen();
    String getDestino();
    String getFecha();
    String getHora(); 
    String getNumeroVuelo();
    String getPrecioCabina();
}
