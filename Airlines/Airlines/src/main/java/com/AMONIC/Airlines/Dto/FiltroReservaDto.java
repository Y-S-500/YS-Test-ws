package com.AMONIC.Airlines.Dto;

import java.sql.Date;

public class FiltroReservaDto {

	public String origen;
	public String destino;
	public Date fecha;
	public String getOrigen() {
		return origen;
	}
	public String getDestino() {
		return destino;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
}
