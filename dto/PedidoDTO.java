package com.senai.ecommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.senai.ecommerce.entities.ItemDoPedido;
import com.senai.ecommerce.entities.Pedido;
import com.senai.ecommerce.enuns.StatusDoPedido;

public class PedidoDTO {
	private Long id;
	private Instant momento;
	private StatusDoPedido status;
	@JsonProperty("clienteId")
	private Long clienteID;
	
	private List<ItemDoPedidoDTO> items = new ArrayList<>();
	
	public PedidoDTO(Pedido pedido) {
		id= pedido.getId();
		momento=pedido.getMomento();
		status= pedido.getStatus();	
		clienteID= pedido.getCliente().getId();
		
		for (ItemDoPedido item : pedido.getItems()) {
			ItemDoPedidoDTO itemDto = new ItemDoPedidoDTO(item);
			items.add(itemDto);

		}
	
}
	public void setItems(List<ItemDoPedidoDTO> items) {
		this.items = items;
	}
	public List<ItemDoPedidoDTO> getItems() {
		return items;
	}
	
	public PedidoDTO() {

	}
	public PedidoDTO(Long id, Instant momento, StatusDoPedido status, Long clienteID) {
		this.id = id;
		this.momento = momento;
		this.status = status;
		this.clienteID = clienteID;
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
	public StatusDoPedido getStatus() {
		return status;
	}
	public void setStatus(StatusDoPedido status) {
		this.status = status;
	}
	public Long getClienteID() {
		return clienteID;
	}
	public void setClienteID(Long clienteID) {
		this.clienteID = clienteID;
	}
}