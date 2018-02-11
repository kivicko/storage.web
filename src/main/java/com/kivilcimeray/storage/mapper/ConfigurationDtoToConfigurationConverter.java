package com.kivilcimeray.storage.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.kivilcimeray.storage.dto.ConfigurationDto;
import com.kivilcimeray.storage.model.Configuration;

@Component
public class ConfigurationDtoToConfigurationConverter implements Converter<ConfigurationDto, Configuration> {

	//Konfigürasyon kayıtları integer, string, double, boolean tiplerinde olabilir
	@Override
	public Configuration convert(ConfigurationDto dto) {
		Configuration model = new Configuration();
		model.setApplicationName(dto.getApplicationName());
		model.setId(dto.getId());
		model.setIsActive(dto.getIsActive());
		model.setName(dto.getName());
		model.setType(dto.getType());
		model.setValue(dto.getValue());
		
		return model;
	}

}
