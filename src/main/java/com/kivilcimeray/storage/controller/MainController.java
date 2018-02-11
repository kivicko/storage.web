package com.kivilcimeray.storage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kivilcimeray.storage.dto.ConfigurationDto;
import com.kivilcimeray.storage.mapper.ConfigurationDtoToConfigurationConverter;
import com.kivilcimeray.storage.mapper.ConfigurationToConfigurationDtoConverter;
import com.kivilcimeray.storage.model.Configuration;
import com.kivilcimeray.storage.service.ConfigurationService;
import com.kivilcimeray.storage.util.CommonUtils;

@Controller
public class MainController {

	@Autowired
	private ConfigurationService configurationService;

	@Autowired
	private ConfigurationToConfigurationDtoConverter config2ConfigDtoConverter;

	@Autowired
	private ConfigurationDtoToConfigurationConverter configDto2ConfigConverter;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mainPage(Model model) {
		List<ConfigurationDto> configDtoList = new ArrayList<ConfigurationDto>();
		configurationService.listAll().forEach(c -> configDtoList.add(config2ConfigDtoConverter.convert(c)));
		model.addAttribute("configs", configDtoList);
		model.addAttribute("configuration", new ConfigurationDto());
		return "index";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String saveUpdateConfiguration(@Valid ConfigurationDto configurationDto, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()
				|| CommonUtils.objToTargetType(configurationDto.getValue(), configurationDto.getType()) == null) {
			return "redirect:/";
		}
		configurationService.saveOrUpdate(configDto2ConfigConverter.convert(configurationDto));

		return "redirect:/";
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	public String deleteMember(@PathVariable String id, Model model) {
		configurationService.delete(id);

		return "redirect:/";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchConfigurationByName(@RequestParam String name, Model model) {
		if (name.isEmpty()) {
			return "redirect:/";
		}
		model.addAttribute("configs", configurationService.getConfigurationListByName(name));
		model.addAttribute("configuration", new Configuration());
		return "index";
	}

}
