package io.github.wiriswernek.agendix.domain.security;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdentificacaoUsuario {
	private String nome;
	private String login;
	private List<String> permissoes;

	public List<String> getPermissoes(){
		if(this.permissoes == null){
			this.permissoes = new ArrayList<String>();
		}
		return this.permissoes;
	}
}
