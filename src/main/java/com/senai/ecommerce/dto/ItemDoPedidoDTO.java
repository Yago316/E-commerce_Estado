package com.senai.ecommerce.dto;

import com.senai.ecommerce.entities.ItemDoPedido;

public class ItemDoPedidoDTO {
	private Long idProduto;
	private Integer quantidade;
	private Double preco;
	private String nome;
	private String imgUrl;
	public ItemDoPedidoDTO() {

	}
	public ItemDoPedidoDTO(Long idProduto, Integer quantidade, Double preco, String nome, String imgUrl) {
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		this.preco = preco;
		this.nome = nome;
		this.imgUrl = imgUrl;
	}
    public ItemDoPedidoDTO(ItemDoPedido item) {
	    idProduto = item.getProduto().getId(); 
		imgUrl = item.getProduto().getImgUrl();
	    nome = item.getProduto().getNome(); 
        quantidade = item.getQuantidade();
        preco = item.getPreco();
    }
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Double getSubtotal() {
		return quantidade * preco;
	}
	

}
