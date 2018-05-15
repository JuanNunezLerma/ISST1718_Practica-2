package org.ingservicios.practica_2;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.ingservicios.practica_2.ParkingInterfaz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private ParkingInterfaz dao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "testparking";
	}
	
	@RequestMapping(value = "/coste", method = RequestMethod.GET)
	public String coste(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "testcoste";
	}
	
	@RequestMapping(value = "/parking/registroMatricula", method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity<ParkingDTO> creamatricula (@RequestBody ParkingDTO matricula) {
		System.out.println("Entrada al servicio");
		dao.insertaMatricula(matricula);
		HttpHeaders cabeceras = new HttpHeaders();
		try {
			cabeceras.setLocation(new URI("http://localhost:8081/practica_2/parking/registroMatricula/"+matricula.getParkingId()+"/"+matricula.getMatricula()));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		ResponseEntity<ParkingDTO> respuestaHTTP = new ResponseEntity<ParkingDTO>(matricula, cabeceras, HttpStatus.CREATED);
			
		return respuestaHTTP;
	}
	
    @RequestMapping(value = "/parking/coste/{matricula}", method = {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody double coste (@PathVariable(value="matricula") String matricula) {
		System.out.println("Entrada al coste");
		double tarifa=0.0004;
		Timestamp tiemposalida = dao.buscaMatricula(matricula, 1).getTimeStamp();
		Timestamp tiempoentrada = dao.buscaMatricula(matricula, 0).getTimeStamp();
		System.out.println( "Segundos de estancia: "+((tiemposalida.getTime()-tiempoentrada.getTime())/1000) ); 
		double segundos=((tiemposalida.getTime()-tiempoentrada.getTime())/1000);
		
		double coste=segundos*tarifa;
	
		return coste;
	}
}
