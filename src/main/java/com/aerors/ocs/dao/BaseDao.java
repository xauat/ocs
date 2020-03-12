package com.aerors.ocs.dao;

import java.io.Serializable;
import java.util.List;


public interface BaseDao<T> {
	@SuppressWarnings("rawtypes")
	public abstract Class getEntityClass();
	public abstract boolean entity_save(Object obj);
	public abstract boolean entity_update(Object obj);
	public abstract boolean entity_delete(Object obj);
	public abstract T entity_findById(Serializable id);
	public abstract List<T> entity_findByHQL(String hql);
	public abstract List<T> entity_queryPage(String hql, int page, int rows);
	public abstract long table_count(String hql);
}
