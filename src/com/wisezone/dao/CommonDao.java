package com.wisezone.dao;

public interface CommonDao<T> {

	public int add(T t);
	public int update(T t);
	public int deleteById(int tId);
	public T findById(int tId);
}
