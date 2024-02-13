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
import io.github.wiriswernek.agendix.domain.service.GrupoService;
import io.github.wiriswernek.agendix.model.dto.GrupoDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/grupos")
@RequiredArgsConstructor
public class GrupoController implements BaseController<GrupoDTO> {

	private final GrupoService service;

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
	public ResponseEntity insert(@RequestBody GrupoDTO dto) {
		return ResponseEntity.ok(service.insert(dto));
	}

	@Override
	public ResponseEntity insertAllObjects(List<GrupoDTO> list) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'insertAllObjects'");
	}

	@Override
	public ResponseEntity update(GrupoDTO dto) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'update'");
	}

	@Override
	public ResponseEntity updateAllObjects(List<GrupoDTO> list) {
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
