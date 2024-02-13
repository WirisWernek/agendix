package io.github.wiriswernek.agendix.controller.Base;

import java.util.List;

import org.springframework.http.ResponseEntity;

import io.github.wiriswernek.agendix.model.dto.Base.BaseDTO;

public interface BaseController<T extends BaseDTO> {
	public ResponseEntity getAll();

	public ResponseEntity getById(Long id);

	public ResponseEntity insert(T dto);

	public ResponseEntity insertAllObjects(List<T> list);

	public ResponseEntity update(T dto);

	public ResponseEntity updateAllObjects(List<T> list);

	public ResponseEntity deleteById();

	public ResponseEntity active(Long id);

	public ResponseEntity activeAllByIds(List<Long> ids);

	public ResponseEntity desactive(Long id);

	public ResponseEntity desactiveAllByIds(List<Long> ids);
}
