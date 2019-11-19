package com.unbosque.dao;

import java.util.List;

public interface DaoGeneral {
	public boolean save(Object object);
	
	public Object get(long id);

	public List<Object> list();

	public boolean remove(Object object);

	public boolean update(Object object);
}
