package com.senai.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.senai.ecommerce.dto.LoginDTO;
import com.senai.ecommerce.dto.UsuarioDTO;
import com.senai.ecommerce.entities.Usuario;
import com.senai.ecommerce.repositories.UsuarioRepository;

@Service
public class LoginService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UsuarioDTO salvarUsuario(UsuarioDTO dto) {
		Usuario user = new Usuario();
		user.setNome(dto.getNome());
		user.setEmail(dto.getEmail());
		user.setSenha(passwordEncoder.encode(dto.getSenha()));//Aqui ele criptografa a senha e salva no Banco 
		user = usuarioRepository.save(user);
		return new UsuarioDTO(user);
	}
	//Tipo de dado para verificar se é verdadeiro ou falso
	//Método para verificar o usuario
	public boolean autenticarUsuario(LoginDTO dto) {
		//Usa o método buscar por Email
		Usuario usuario = usuarioRepository.findByEmail(dto.getEmail());
		if(usuario == null){
			return false;//se o usuário for nulo, ou seja, não existir, ele retorna um "falso"
		}
		return passwordEncoder.matches(dto.getSenha(), usuario.getSenha()); //ele compara se a senha que foi passada na hora do login combina com a do banco de Dados
		}
	}


