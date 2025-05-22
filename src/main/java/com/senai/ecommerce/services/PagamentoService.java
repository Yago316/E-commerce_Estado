package com.senai.ecommerce.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.ecommerce.Enum.StatusDoPedido;
import com.senai.ecommerce.entities.Pagamento;
import com.senai.ecommerce.entities.Pedido;
import com.senai.ecommerce.repositories.PagamentoRepository;
import com.senai.ecommerce.repositories.PedidoRepository;

@Service
public class PagamentoService {
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	public Pagamento CriarPagamento(Long id) {
		Pagamento pagamento = new Pagamento(); //Instanciar o pagamento
		Pedido pedido = pedidoRepository.findById(id) //Buscando o pedido
				.orElseThrow(()-> new IllegalArgumentException("Pedido não encontrado " + id)); // Aqui você deve implementar a lógica para buscar o pedido pelo ID
		
		if (pedido.getStatus() != StatusDoPedido.AGUARDANDO_PAGAMENTO) {
			throw new IllegalArgumentException("Pedido não está aguardando pagamento " + id); // Lógica para tratar o caso em que o pedido não é encontrado
		}
		
		pedido.setStatus(StatusDoPedido.PAGO); // Aqui você deve implementar a lógica para atualizar o status do pedido
		pagamento.setMomento(Instant.now()); // Aqui você deve implementar a lógica para definir o momento do pedido
		pagamento.setPedido(pedido);
		pedido = pedidoRepository.save(pedido); 
		//pagamentoRepository.save(pagamento);
		/// Aqui você deve implementar a lógica para salvar o pedido atualizado
        return new  Pagamento(pedido.getId(), pedido.getMomento()); // Aqui você deve implementar a lógica para criar o pagamento
		
	}
	
	
}