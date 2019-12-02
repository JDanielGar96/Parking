package com.unbosque.dao;

public interface DaoParqueadero extends DaoGeneral  {
	
	public Object listAvaliables();
	
	public boolean updateAvaliability(int id, int disponibilidad);
	
}
