package io.github.wiriswernek.agendix.model.entity;

import java.util.List;

import io.github.wiriswernek.agendix.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "IMAGEM")
public class ImagemEntity extends BaseEntity{

	@Column(name = "NOME")
	@NotNull(message = "O Nome não pode ser nulo!")
	@NotBlank(message = "O Nome não pode ser vazio!")
	private String nome;

	@Column(name = "URL")
	@NotNull(message = "A URL não pode ser nula!")
	@NotBlank(message = "A URL não pode ser vazia!")
	private String url;

	@OneToMany(mappedBy = "imagem", fetch = FetchType.EAGER)
	private List<ImagemServicoEnitity> servicos;
}
