package io.github.wiriswernek.agendix.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.wiriswernek.agendix.controller.Base.BaseController;
import io.github.wiriswernek.agendix.model.dto.GrupoUsuarioDTO;

@RestController
@RequestMapping( "/grupo-usuario" )
public class GrupoUsuarioController implements BaseController<GrupoUsuarioDTO> {

	@Override
	public ResponseEntity getAll() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getAll'");
	}

	@Override
	public ResponseEntity getById(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getById'");
	}

	@Override
	public ResponseEntity insert(GrupoUsuarioDTO dto) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'insert'");
	}

	@Override
	public ResponseEntity insertAllObjects(List<GrupoUsuarioDTO> list) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'insertAllObjects'");
	}

	@Override
	public ResponseEntity update(GrupoUsuarioDTO dto) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'update'");
	}

	@Override
	public ResponseEntity updateAllObjects(List<GrupoUsuarioDTO> list) {
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
