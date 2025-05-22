package com.senai.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.ecommerce.entities.Pagamento;
import com.senai.ecommerce.services.PagamentoService;

@RestController
@RequestMapping(value = "/pagamento")
public class PagamentoController {
	@Autowired
	PagamentoService pagamentoService;
	@PostMapping("/criar/{id}")
	public ResponseEntity<Pagamento> inserir(@PathVariable Long id){ //Aqui você recebe o id do pedido
		
		return ResponseEntity.ok(pagamentoService.CriarPagamento(id)); //Aqui você retorna o pagamento criado
	}
}
