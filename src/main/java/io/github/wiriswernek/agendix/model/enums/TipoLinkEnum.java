package io.github.wiriswernek.agendix.model.enums;

public enum TipoLinkEnum {
	REDE_SOCIAL("Rede Social"),
	WEBSITE("Website"),
	CARTAO_DIGITAL("Cartão Digital"),
	CATALOGO_DIGITAL("Catálogo Digital"),
	PORTIFOLIO("Portfólio"),
	OUTRO("Outro");

	private String descricao;

	TipoLinkEnum(String descricao) {
		this.descricao = descricao;
	}
}
