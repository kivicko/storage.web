package com.kivilcimeray.storage.controller;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.mockito.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.kivilcimeray.storage.dto.ConfigurationDto;
import com.kivilcimeray.storage.mapper.ConfigurationToConfigurationDtoConverter;
import com.kivilcimeray.storage.model.Configuration;
import com.kivilcimeray.storage.service.ConfigurationService;

public class MainControllerTest {

	@Mock
	private ConfigurationService configurationService;
	
	@Mock
	private ConfigurationToConfigurationDtoConverter config2ConfigDtoConverter;
	
	@InjectMocks
	private MainController mainController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
	}
	
	@Test
	public void testListingPage() throws Exception {
		List<Configuration> configurationList = new ArrayList<Configuration>();
		configurationList.addAll(Arrays.asList(new Configuration(), new Configuration(), new Configuration()));
		
		when(configurationService.listAll()).thenReturn(configurationList);
		when(config2ConfigDtoConverter.convert(Matchers.<Configuration>any())).thenReturn(new ConfigurationDto());
		
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("index"))
			.andExpect(model().attribute("configs", hasSize(3)))
			.andExpect(model().attribute("configuration", instanceOf(ConfigurationDto.class)));
	}
	
	@Test
    public void testSaveOrUpdateFailedWithNullValue() throws Exception {
		ConfigurationDto cfgDto = new ConfigurationDto();
		String applicationName = "applicationName";
		cfgDto.setApplicationName(applicationName);
		cfgDto.setValue(null);
		
		mockMvc.perform(post("/")
				.param("applicationName", applicationName)
				.param("value", ""))
		.andExpect(status().is3xxRedirection());
	}
	
	@Test
	public void testSaveOrUpdateFailedWithNullType() throws Exception {
		
	}
	
	@Test
    public void testSaveOrUpdate() throws Exception {
        ConfigurationDto configurationDto = new ConfigurationDto();
        Configuration configurationModel = new Configuration();
        String id = "abcdefgh";
        String applicationName = "JohnApp";
        String configName = "XYZ";
        Boolean isActive = true;
        String phoneNumber = "123456789";
        String typeName = String.class.getName();

        configurationDto.setId(id);
        configurationDto.setName(configName);
        configurationDto.setApplicationName(applicationName);
        configurationDto.setIsActive(isActive);
        configurationDto.setType(typeName);
        
        configurationModel.setId(id);
        configurationModel.setName(configName);
        configurationModel.setApplicationName(applicationName);
        configurationModel.setIsActive(isActive);
        configurationModel.setType(typeName);
        
		List<Configuration> configurationList = new ArrayList<Configuration>();
		configurationList.add(configurationModel);
		
		when(configurationService.listAll()).thenReturn(configurationList);
		
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("index"))
			.andExpect(model().attribute("configs", hasSize(1)))
			.andExpect(model().attribute("configuration", instanceOf(ConfigurationDto.class)));

    }

	
}











