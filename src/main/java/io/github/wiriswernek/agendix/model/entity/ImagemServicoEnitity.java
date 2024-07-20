package io.github.wiriswernek.agendix.model.entity;

import io.github.wiriswernek.agendix.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "IMAGEM_SERVICO")
public class ImagemServicoEnitity extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SERVICO", referencedColumnName = "ID")
	private ServicoEntity servico;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_IMAGEM", referencedColumnName = "ID")
	private ImagemEntity imagem;

}
