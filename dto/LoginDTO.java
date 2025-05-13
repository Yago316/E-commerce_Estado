package com.senai.ecommerce.dto;

public class LoginDTO {
	private Long id;
	private String email;
	private String senha;
	public LoginDTO() {
	}
	public LoginDTO(Long id, String email, String senha) {
		this.id = id;
		this.email = email;
		this.senha = senha;
	}
	public LoginDTO(UsuarioDTO entity) {
		id = entity.getId();
		email = entity.getEmail();
		senha = entity.getSenha();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
