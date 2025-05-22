
package com.senai.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.ecommerce.dto.LoginDTO;
import com.senai.ecommerce.dto.UsuarioDTO;
import com.senai.ecommerce.services.LoginService;

import jakarta.validation.Valid;
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
	@Autowired 
	LoginService loginService;
	@PostMapping(value = "/salvar")
	public ResponseEntity<?> salvar(@Valid @RequestBody UsuarioDTO dto){
		dto = loginService.salvarUsuario(dto);
		
		return ResponseEntity.ok(dto);
	}

	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody LoginDTO dto){
		boolean suamae = loginService.autenticarUsuario(dto);
		if (suamae) {
			return ResponseEntity.ok("Aeeeee!!!!"); //Se verdadeiro ele retorna essa mensagem de Aeee!!!!
		}else {
			return ResponseEntity.status(401).body("Email ou senha incorretos !!!!111 Se vira pra saber qual ");
			//se for falso ele vai mostrar esse erro genéricão ae
		}
	}
}

