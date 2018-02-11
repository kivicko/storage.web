package com.kivilcimeray.storage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kivilcimeray.storage.model.Configuration;
import com.kivilcimeray.storage.repository.ConfigurationRepository;
import com.kivilcimeray.storage.service.ConfigurationService;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {

	@Autowired
	private ConfigurationRepository configurationRepository;
	
	@Override
	public List<Configuration> listAll() {

		return configurationRepository.findAll();
	}

	@Override
	public Configuration saveOrUpdate(Configuration config) {

		return configurationRepository.save(config);
	}

	@Override
	public void delete(String id) {
		configurationRepository.delete(id);
	}

	@Override
	public List<Configuration> getConfigurationListByName(String name) {
		return configurationRepository.findByNameLike(name);
	}

	
}
