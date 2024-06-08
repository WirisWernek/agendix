package io.github.wiriswernek.agendix.model.enums;

import lombok.Getter;

@Getter
public enum TipoUsuarioEnum {

	ADMIN("Administrador"), CLIENTE("Cliente"), PRESTADOR("PRESTADOR"), VISITANTE("Visitante");

	private String descricao;

	TipoUsuarioEnum(String descricao) {
		this.descricao = descricao;
	}

}
