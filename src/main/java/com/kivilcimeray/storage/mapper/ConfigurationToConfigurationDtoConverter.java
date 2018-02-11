package com.kivilcimeray.storage.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.kivilcimeray.storage.dto.ConfigurationDto;
import com.kivilcimeray.storage.model.Configuration;

@Component
public class ConfigurationToConfigurationDtoConverter  implements Converter<Configuration, ConfigurationDto>{

	@Override
	public ConfigurationDto convert(Configuration model) {
		ConfigurationDto dto = new ConfigurationDto();
		dto.setIsActive(model.getIsActive());
		dto.setId(model.getId());
		dto.setApplicationName(model.getApplicationName());
		dto.setName(model.getName());
		dto.setType(model.getType());
		dto.setValue(model.getValue());
		
		return dto;
	}

}
