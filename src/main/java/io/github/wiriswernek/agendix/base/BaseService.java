package io.github.wiriswernek.agendix.base;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

public abstract class BaseService<T, S> {
	protected ModelMapper modelMapper = new ModelMapper();
	protected Type listTypeDTO = new TypeToken<List<T>>() {}.getType();
	// protected Type typeDTO = new TypeToken<T>() {}.getType();
	protected Type listTypeEntity = new TypeToken<List<S>>() {}.getType();
	// protected Type typeEntity = new TypeToken<S>() {}.getType();
}
