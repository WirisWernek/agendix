package io.github.wiriswernek.agendix.model.enums;

import lombok.Getter;

@Getter
public enum TipoComunicadoEnum {
	PROMOCAO("Promoção"),
	OFERTA("Oferta"),
	FIDELIDADE("Programa de Fidelidade"),
	PARCERIA("Parceria"),
	SORTEIO("Sorteio"),
	NOTIFICACAO_FERIAS("Notificação de Férias"),
	NOTIFICACAO_INDISPONIBILIDADE("Notificação de Indisponibilidade"),
	NOTA_ESCLARECIMENTO("Nota de Esclarecimento");

	private String descricao;

	TipoComunicadoEnum(String descricao) {
		this.descricao = descricao;
	}
}
