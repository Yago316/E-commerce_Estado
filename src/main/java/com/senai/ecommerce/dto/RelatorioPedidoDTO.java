package com.senai.ecommerce.dto;

import com.senai.ecommerce.entities.Pedido;

public class RelatorioPedidoDTO {
	private long pedido;
	private String cliente;
	private String status;
	private String momento;

	public RelatorioPedidoDTO(Pedido entity) {
		this.pedido = entity.getId();
		this.cliente = entity.getCliente().getNome();//pegando o nome do cliente
		this.status = entity.getStatus().toString();//Convertendo o status para string
		this.momento = entity.getMomento().atZone(java.time.ZoneId.systemDefault())
				.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));//para formatar a data em dia mes hora e minuto
	}

	public long getPedido() {
		return pedido;
	}

	public String getCliente() {
		return cliente;
	}

	public String getStatus() {
		return status;
	}

	public String getMomento() {
		return momento;
	}
 
}
