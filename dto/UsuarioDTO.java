	package com.senai.ecommerce.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.senai.ecommerce.entities.Usuario;

import java.util.List;
import java.util.stream.Collectors;

import com.senai.ecommerce.entities.Usuario;

public class UsuarioDTO {
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String senha;
	private List<PedidoDTO> pedidos;

	
	public UsuarioDTO() {

	}
	
	
	public UsuarioDTO(Long id, String nome, String email, String telefone, String senha, List<PedidoDTO> pedidos) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.pedidos = pedidos;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public List<PedidoDTO> getPedidos() {
		return pedidos;
	}


	public void setPedidos(List<PedidoDTO> pedidos) {
		this.pedidos = pedidos;
	}


	public UsuarioDTO(Usuario usuario) {

	id = usuario.getId();
	nome = usuario.getNome();
	email = usuario.getEmail();
	telefone = usuario.getTelefone();
	senha = usuario.getSenha();



}
}
