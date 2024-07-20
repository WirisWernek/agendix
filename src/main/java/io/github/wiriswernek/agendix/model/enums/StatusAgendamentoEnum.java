package io.github.wiriswernek.agendix.model.enums;

import lombok.Getter;

@Getter
public enum StatusAgendamentoEnum {
	ATENDIDO(""),
	AGENDADO(""),
	CANCELADO(""),
	REMARCADO(""),
	RECUSADO("");

	private String descricao;

	StatusAgendamentoEnum(String descricao) {
		this.descricao = descricao;
	}
}
