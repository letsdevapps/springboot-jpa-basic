package com.pro.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "accounts")
public class Account {

	@Id
	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Getter
	@Setter
	@NotBlank(message = "Titular é obrigatório")
	private String titular;

	@Getter
	@Setter
	@NotBlank(message = "Saldo é obrigatório")
	private BigDecimal saldo;

	public Account() {

	}

	public Account(String titular, BigDecimal saldo) {
		this.titular = titular;
		this.saldo = saldo;
	}
}