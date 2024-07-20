package io.github.wiriswernek.agendix.model.enums;

import lombok.Getter;

@Getter
public enum TipoAvaliacaoEnum {

	SUGESTAO("Sugestão"), CRITICA("Crítica"), RECLAMACAO("Reclamação"), ELOGIO("Elogio");

	private String descricao;

	TipoAvaliacaoEnum(String descricao) {
		this.descricao = descricao;
	}

}
