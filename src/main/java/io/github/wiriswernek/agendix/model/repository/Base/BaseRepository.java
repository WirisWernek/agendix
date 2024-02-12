package io.github.wiriswernek.agendix.model.repository.Base;

import java.util.List;

import io.github.wiriswernek.agendix.model.entity.Base.BaseEntity;

public interface BaseRepository {
	public List<BaseEntity> getAll();
	public BaseEntity getById(Long id);
	public BaseEntity insert(BaseEntity dto);
	public List<BaseEntity> insertAllObjects(List<BaseEntity> list);
	public BaseEntity update(BaseEntity dto);
	public List<BaseEntity> updateAllObjects(List<BaseEntity> list);
	public void deleteById();
	public void active(Long id);
	public void activeAllByIds(List<Long> ids);
	public void desactive(Long id);
	public void desactiveAllByIds(List<Long> ids);
}
