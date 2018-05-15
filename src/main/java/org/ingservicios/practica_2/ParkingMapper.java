package org.ingservicios.practica_2;

import java.io.Serializable;
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


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ParkingMapper implements RowMapper<ParkingDTO>{
	
	public ParkingDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
		ParkingDTO matricula = new ParkingDTO();
		matricula.setRegistro(rs.getInt("Registro"));
		matricula.setParkingId(rs.getInt("ParkingId"));
		matricula.setMatricula(rs.getString("Matricula"));
		matricula.setTimeStamp(rs.getTimestamp("TimeStamp"));
		return matricula;
	}
}