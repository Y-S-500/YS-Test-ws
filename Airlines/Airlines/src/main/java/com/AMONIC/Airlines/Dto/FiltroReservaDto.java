package com.AMONIC.Airlines.Dto;



public class FiltroReservaDto {

	public String origen;
	public String destino;
	public String fecha;
	public Boolean trediasAD;
	
	
	public Boolean getTrediasAD() {
		return trediasAD;
	}
	public void setTrediasAD(Boolean trediasAD) {
		this.trediasAD = trediasAD;
	}
	public String getOrigen() {
		return origen;
	}
	public String getDestino() {
		return destino;
	}
	public String getFecha() {
		return fecha;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
}
