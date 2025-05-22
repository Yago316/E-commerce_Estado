package com.senai.ecommerce.dto;

import java.time.Instant;

import com.senai.ecommerce.entities.Pagamento;
import com.senai.ecommerce.entities.Pedido;


public class PagamentoDTO {
	private Long id;
	private Instant momento;
	private Pedido pedido;
	public PagamentoDTO() {
	}
	public PagamentoDTO(Long id, Instant momento, Pedido pedido) {
		this.id = id;
		this.momento = momento;
		this.pedido = pedido;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Instant getMomento() {
		return momento;
	}
	public void setMomento(Instant momento) {
		this.momento = momento;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
}
