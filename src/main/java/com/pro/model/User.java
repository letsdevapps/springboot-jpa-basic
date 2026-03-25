package com.pro.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Getter
	@Setter
	@NotBlank(message = "Nome é obrigatório")
	private String name;

	@Getter
	@Setter
	@Email(message = "Email inválido")
    @NotBlank(message = "Email é obrigatório")
	private String email;

	@Getter
	@Setter
	@PastOrPresent(message = "Data inválida")
	@NotNull(message = "Data de nascimento é obrigatória")
	private LocalDate birthDate;

	public User() {
	}

	public User(String name, String email, LocalDate birthDate) {
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}
}