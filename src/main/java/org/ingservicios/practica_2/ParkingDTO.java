package org.ingservicios.practica_2;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */

public class ParkingDTO implements Serializable{
	
	private int registro;
	private int parkingId;
	private String matricula;
	private Timestamp timeStamp;
	
	public ParkingDTO(int registro,int parkingId, String matricula, Timestamp timeStamp) {
		this.registro=registro;
		this.parkingId=parkingId;
		this.matricula=matricula;
		this.timeStamp=timeStamp;
	}
	
	public ParkingDTO() {
		
	}

	public int getRegistro() {
		return registro;
	}

	public void setRegistro(int registro) {
		this.registro = registro;
	}

	public int getParkingId() {
		return parkingId;
	}

	public void setParkingId(int parkingId) {
		this.parkingId = parkingId;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
