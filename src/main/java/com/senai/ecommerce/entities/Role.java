package com.senai.ecommerce.entities;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@SuppressWarnings("serial") // Para evitar warnings de serialização, só isso mesmo kkkkk
@Entity
@Table(name = "tb_role")
public class Role implements GrantedAuthority {


	//Implementar a interface GrantedAuthority
	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY) 
	private Long id;
	
	private String authority;
      
	public Role() {
	}

	public Role(Long id, String authority) {
		this.id = id;
		this.authority = authority;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Override //Override é usado para sobrescrever o método da interface
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}


}
