package com.senai.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.senai.ecommerce.dto.UsuarioDTO;
import com.senai.ecommerce.entities.Usuario;
import com.senai.ecommerce.repositories.UsuarioRepository;

public class UsuarioService {
  @Autowired
  private UsuarioRepository usuarioRepository;
  public UsuarioDTO buscarUsuario(Long id) {
	  Usuario usuario = usuarioRepository.findById(id)
			  .orElseThrow(()-> new RuntimeException("Usuário não encontrado."));
	  return new UsuarioDTO (usuario);
  }
}
