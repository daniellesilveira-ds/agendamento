package br.com.amphibia.schedule.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.amphibia.schedule.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
	
	public Usuario findByEmailAndSenha(String email, String senha);

	public Usuario findByEmailOrRacf(String email, String racf);
	
}
