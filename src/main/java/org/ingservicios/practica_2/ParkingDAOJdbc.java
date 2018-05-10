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


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ParkingDAOJdbc implements ParkingInterfaz {
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//Métodos
	public void insertaMatricula(ParkingDTO matricula){
		String sql = "INSERT INTO parking (parkingId, matricula) VALUES (?,?)";
		Object[ ] parametros = { matricula.getParkingId(), matricula.getMatricula()};
		this.jdbcTemplate.update(sql,parametros);
		
	}
	
	public List<ParkingDTO> leeMatricula(){
		String sql = "select * from parking";
		ParkingMapper mapper = new ParkingMapper();
		List<ParkingDTO> matriculas = this.jdbcTemplate.query(sql, mapper);
		return matriculas;
		}
	
	public ParkingDTO buscaMatricula(String matricula){ //Devuelve el usuario buscado o null si no existe
		String sql = "select * from parking where Matricula = ?";
		Object[ ] parametros = {matricula}; //Array de objetos
		ParkingMapper mapper = new ParkingMapper();
		System.out.println(matricula);
		List<ParkingDTO> matriculas = this.jdbcTemplate.query(sql, parametros, mapper);
		if (matriculas.isEmpty()){
			return null;
		}else 
			return matriculas.get(0);
	}
	
}
