package com.unbosque.dao;

import java.util.List;

public interface DAO {
	public boolean save(Object object);
	
	public Object get(long id);

	public List<Object> list();

	public void remove(Object object);

	public void update(Object object);
}
