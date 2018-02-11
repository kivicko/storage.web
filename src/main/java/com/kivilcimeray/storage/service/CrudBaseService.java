package com.kivilcimeray.storage.service;

import java.util.List;

public interface CrudBaseService<T> {

	List<T> listAll();

	T saveOrUpdate(T domainObject);

	void delete(String id);

}
