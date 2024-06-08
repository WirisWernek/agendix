package io.github.wiriswernek.agendix.domain.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.github.wiriswernek.agendix.model.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

	private final IUsuarioRepository usuarioRepository;
	// private final IPessoaRepository pessoaRepository;
	private final UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return usuarioRepository.findByLogin(username);
	}

	// public void resetSenha(ResetSenhaDTO dto) throws Exception {
	// 	var pessoa = pessoaRepository.findByMatricula(dto.getMatricula());

	// 	var usuarioOptional = pessoa.getUsuarios().stream().filter(user -> user.getLogin().equals(dto.getLogin()))
	// 			.findFirst();

	// 	if (!usuarioOptional.isPresent()) {
	// 		throw new Exception("Não foi encontrado usuário com essas informações!");
	// 	}
	// 	;

	// 	var usuario = usuarioOptional.get();

	// 	if (pessoa == null || !usuario.getLogin().equals(dto.getLogin())
	// 			|| !usuario.getEmail().equals(dto.getEmail())) {
	// 		throw new Exception("Não foi encontrado usuário com essas informações!");
	// 	}

	// 	if (usuarioService.validateSenha(dto.getNovaSenha())) {
	// 		throw new Exception(
	// 				"\nSenha inválida!\nA nova senha deve conter pelo menos: 8 caracteres, uma letra maiscula, uma letra miniscula e um número");
	// 	}

	// 	String senhaCriptografada = new BCryptPasswordEncoder().encode(dto.getNovaSenha());
	// 	usuario.setSenha(senhaCriptografada);

	// 	usuarioRepository.save(usuario);

	// }

}
