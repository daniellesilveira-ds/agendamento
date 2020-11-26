package br.com.amphibia.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.amphibia.schedule.dao.UsuarioDAO;
import br.com.amphibia.schedule.model.Usuario;

@RestController
@CrossOrigin("*")
public class UsuarioController {
	@Autowired
	UsuarioDAO dao;

	@PostMapping("/login")
	public ResponseEntity<Usuario> logarUsuario(@RequestBody Usuario userLogin) {
		Usuario resp = dao.findByEmailOrRacf(userLogin.getEmail(), userLogin.getRacf());
		// encontramos o usuário no banco
		if (resp != null) {
			if (resp.getSenha().equals(userLogin.getSenha())) { // senha confere
				return ResponseEntity.ok(resp);
			}
			else {
				return ResponseEntity.status(401).build(); // se a senha não confere, retorno 401 - Unauthorized
			}
		}
		else {
			return ResponseEntity.notFound().build(); // criamos uma mensagem de resposta 404
	}
	}

}
