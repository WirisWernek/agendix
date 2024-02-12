package io.github.wiriswernek.agendix.model.enums;

import lombok.Getter;

@Getter
public enum SexoEnum {

	MASCULINO("Masculino"), FEMININO("Feminino"), NAO_INFORMADO("Não Informado");

	private String descricao;

	SexoEnum(String descricao) {
		this.descricao = descricao;
	}

}
