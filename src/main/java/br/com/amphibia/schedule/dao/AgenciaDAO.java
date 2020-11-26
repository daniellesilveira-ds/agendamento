package br.com.amphibia.schedule.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.amphibia.schedule.model.Agencia;

public interface AgenciaDAO extends CrudRepository<Agencia, Integer>{

	public ArrayList<Agencia> findAllByOrderByNome();
}
