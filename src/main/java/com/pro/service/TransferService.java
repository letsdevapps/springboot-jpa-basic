package com.pro.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.model.Account;
import com.pro.repository.AccountRepository;

import jakarta.transaction.Transactional;

@Service
public class TransferService {

	@Autowired
	private AccountRepository accountRepository;

	@Transactional
	public void transferir(Long origemId, Long destinoId, BigDecimal valor) {
		Account origem = accountRepository.findById(origemId)
				.orElseThrow(() -> new RuntimeException("Conta origem não encontrada"));

		Account destino = accountRepository.findById(destinoId)
				.orElseThrow(() -> new RuntimeException("Conta destino não encontrada"));

		if (origem.getSaldo().compareTo(valor) < 0) {
			throw new RuntimeException("Saldo insuficiente");
		}

		origem.setSaldo(origem.getSaldo().subtract(valor));
		destino.setSaldo(destino.getSaldo().add(valor));

		accountRepository.save(origem);

		// Simula erro no meio da transação - A execução será interrompida aqui
		// Simulates an error mid-transaction - Execution will be interrupted here
		if (true) {
			throw new RuntimeException("Erro inesperado");
		}

		accountRepository.save(destino);
	}
}