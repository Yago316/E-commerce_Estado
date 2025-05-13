package com.senai.ecommerce.services;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.ecommerce.dto.ItemDoPedidoDTO;
import com.senai.ecommerce.dto.PedidoDTO;
import com.senai.ecommerce.entities.ItemDoPedido;
import com.senai.ecommerce.entities.Pedido;
import com.senai.ecommerce.entities.Produto;
import com.senai.ecommerce.entities.Usuario;
import com.senai.ecommerce.enuns.StatusDoPedido;
import com.senai.ecommerce.repositories.ItemDoPedidoRepository;
import com.senai.ecommerce.repositories.PedidoRepository;
import com.senai.ecommerce.repositories.ProdutoRepository;
import com.senai.ecommerce.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ItemDoPedidoRepository itemDoPedidoRepository;

	@Transactional
	public PedidoDTO inserir(PedidoDTO pedidoDto) {
		Pedido pedido = new Pedido();
		pedido.setMomento(Instant.now());
		pedido.setStatus(StatusDoPedido.AGUARDANDO_PAGAMENTO);
//	 pedido.setCliente(usuarioRepository.getReferenceById(pedidoDto.getClienteID()));

		Usuario user = usuarioRepository.getReferenceById(pedidoDto.getClienteID());
		pedido.setCliente(user);
		for (ItemDoPedidoDTO itemDTO : pedidoDto.getItems()) {
			Produto produto = produtoRepository.getReferenceById(itemDTO.getIdProduto());
			ItemDoPedido item = new ItemDoPedido(pedido, produto, itemDTO.getQuantidade(), produto.getPreco());
			pedido.getItems().add(item); // Adiciona o item ao pedido

		}
		pedido = pedidoRepository.save(pedido);
//	    PedidoDTO pedidoDTO = new PedidoDTO(pedido);
//	    pedidoDTO.setItems(pedidoDto.getItems());
		itemDoPedidoRepository.saveAll(pedido.getItems());
		return new PedidoDTO(pedidoRepository.findById(pedido.getId()).get());

	}

	@Transactional
	public PedidoDTO findById(Long id) {
		Pedido pedido = pedidoRepository.getById(id);
		return new PedidoDTO(pedido);
	}
	// Buscar todos os pedidos
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();  // Chama o método findAll() do repositório
    }

}
