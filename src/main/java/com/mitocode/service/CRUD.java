package com.mitocode.service;

import java.util.List;

public interface CRUD<T, V> {
	
	T register(T obj);
	
	T modify(T obj);
	
	List<T> listAll();
	
	T listById(V id);
	
	boolean remove(V id);

}
