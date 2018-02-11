package com.kivilcimeray.storage.service;

import java.util.List;

import com.kivilcimeray.storage.model.Configuration;

public interface ConfigurationService extends CrudBaseService<Configuration> {

	List<Configuration> getConfigurationListByName(String name);

}
