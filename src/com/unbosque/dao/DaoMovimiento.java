package com.unbosque.dao;

import java.util.List;

public interface DaoMovimiento extends DaoGeneral{
	public List<Object> listByClient(String login);
}
