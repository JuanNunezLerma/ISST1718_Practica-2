package org.ingservicios.practica_2;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

public interface ParkingInterfaz{
	
	public void insertaMatricula(ParkingDTO matricula);
	public List<ParkingDTO> leeMatricula();
	public ParkingDTO buscaMatricula(String matricula, int parkingId);
	//public void modificaUsuario(UsuarioDTO UsuarioNew, String email);
	
}
