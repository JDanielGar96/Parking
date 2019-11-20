package com.unbosque.dao;

public interface DaoUser extends DaoGeneral {
	
	public Object getByLogin(String login);
	
	public Object getByEmail(String email);
	
	public boolean login(String login, String password);

}
