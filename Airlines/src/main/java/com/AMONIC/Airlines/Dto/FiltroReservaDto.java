package com.AMONIC.Airlines.Dto;

import java.sql.Date;

public class FiltroReservaDto {

	public int origen;
	public int destino;
	public String fechaS;
	public String fechaR;
	
	public Boolean TresDias;
	public Boolean TresDiaR;
	public String tipoCabina;
	
	
	public String getTipoCabina() {
		return tipoCabina;
	}
	public void setTipoCabina(String tipoCabina) {
		this.tipoCabina = tipoCabina;
	}
	public String getFechaS() {
		return fechaS;
	}
	public void setFechaS(String fechaS) {
		this.fechaS = fechaS;
	}
	public String getFechaR() {
		return fechaR;
	}
	public void setFechaR(String fechaR) {
		this.fechaR = fechaR;
	}
	public int getOrigen() {
		return origen;
	}
	public void setOrigen(int origen) {
		this.origen = origen;
	}
	public int getDestino() {
		return destino;
	}
	public void setDestino(int destino) {
		this.destino = destino;
	}

	public Boolean getTresDias() {
		return TresDias;
	}
	public void setTresDias(Boolean tresDias) {
		TresDias = tresDias;
	}
	public Boolean getTresDiaR() {
		return TresDiaR;
	}
	public void setTresDiaR(Boolean tresDiaR) {
		TresDiaR = tresDiaR;
	}
	
	
	
	
	
}
