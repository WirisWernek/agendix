package io.github.wiriswernek.agendix.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.wiriswernek.agendix.controller.Base.BaseController;
import io.github.wiriswernek.agendix.domain.service.UsuarioService;
import io.github.wiriswernek.agendix.model.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController implements BaseController<UsuarioDTO> {

	private final UsuarioService service;

	@Override
	@GetMapping("/")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@Override
	public ResponseEntity getById(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getById'");
	}

	@Override
	@PostMapping("/")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity insert(@RequestBody UsuarioDTO dto) {
		return ResponseEntity.ok(service.insert(dto));
	}

	@Override
	public ResponseEntity insertAllObjects(List<UsuarioDTO> list) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'insertAllObjects'");
	}

	@Override
	public ResponseEntity update(UsuarioDTO dto) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'update'");
	}

	@Override
	public ResponseEntity updateAllObjects(List<UsuarioDTO> list) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updateAllObjects'");
	}

	@Override
	public ResponseEntity deleteById() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
	}

	@Override
	public ResponseEntity active(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'active'");
	}

	@Override
	public ResponseEntity activeAllByIds(List<Long> ids) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'activeAllByIds'");
	}

	@Override
	public ResponseEntity desactive(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'desactive'");
	}

	@Override
	public ResponseEntity desactiveAllByIds(List<Long> ids) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'desactiveAllByIds'");
	}

}
