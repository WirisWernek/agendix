package io.github.wiriswernek.agendix.model.enums;

import lombok.Getter;

@Getter
public enum DiaSemanaEnum {
	DOMINGO("Domingo"),
	SEGUNDA("Segunda-feira"),
	TERCA("Terça-feira"),
	QUARTA("Quarta-feira"),
	QUINTA("Quinta-feira"),
	SEXTA("Sexta-feira"),
	SABADO("Sábado");

	private String descricao;

	DiaSemanaEnum(String descricao) {
		this.descricao = descricao;
	}
}
