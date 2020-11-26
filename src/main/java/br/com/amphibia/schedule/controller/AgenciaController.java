package br.com.amphibia.schedule.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.amphibia.schedule.dao.AgenciaDAO;
import br.com.amphibia.schedule.model.Agencia;

@CrossOrigin("*")
@RestController
public class AgenciaController {
	@Autowired
	private AgenciaDAO dao;
     
	@GetMapping("/Agencias")
	public ArrayList<Agencia> recuperarTodas(){
		ArrayList<Agencia> lista;
		lista = (ArrayList<Agencia>)dao.findAllByOrderByNome();
		return lista;
		
		
		
	}
}
