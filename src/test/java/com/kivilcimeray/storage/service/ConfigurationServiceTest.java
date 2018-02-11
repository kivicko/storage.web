package com.kivilcimeray.storage.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.kivilcimeray.storage.model.Configuration;
import com.kivilcimeray.storage.repository.ConfigurationRepository;
import com.kivilcimeray.storage.service.impl.ConfigurationServiceImpl;

public class ConfigurationServiceTest {

	@Mock
	ConfigurationRepository configurationRepository;

	@InjectMocks
	ConfigurationServiceImpl configurationService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void listAllMethodTest() throws Exception {
		List<Configuration> configList = new ArrayList<Configuration>();
		String name1 = "cfg1Name";
		String name2 = "cfg2Name";
		boolean active1 = true;
		boolean active2 = true;
		
		Configuration cfg1 = new Configuration();
		cfg1.setName(name1);
		cfg1.setIsActive(active1);
		
		Configuration cfg2 = new Configuration();
		cfg2.setName(name2);
		cfg2.setIsActive(active2);
		
		configList.add(cfg1);
		configList.add(cfg2);
		
		when(configurationRepository.findAll()).thenReturn(configList);
		
		assert configurationService.listAll() != null;
		assertEquals(2, configurationService.listAll().size());
		assertEquals(name1, configurationService.listAll().get(0).getName());
		assertEquals(active1, configurationService.listAll().get(0).getIsActive());
		assertEquals(name2, configurationService.listAll().get(1).getName());
		assertEquals(active2, configurationService.listAll().get(1).getIsActive());
	}
	
	@Test
	public void testSaveOrUpdate() throws Exception {
		Configuration cfg = new Configuration();
		
		String value = "value1";
		String type = "type1";
		String id = "abcdefg";
		String applicationName = "appName1";
		String name = "Name1";
		Boolean isActive = true;
		
		cfg.setValue(value);
		cfg.setApplicationName(applicationName);
		cfg.setName(name);
		cfg.setId(id);
		cfg.setIsActive(isActive);
		cfg.setType(type);
		
		when(configurationRepository.save(Matchers.<Configuration>any())).thenReturn(cfg);
		
		assert configurationService.saveOrUpdate(new Configuration()) != null;
		assertEquals(configurationService.saveOrUpdate(new Configuration()).getId(), cfg.getId());
		assertEquals(configurationService.saveOrUpdate(new Configuration()).getValue(), cfg.getValue());
		assertEquals(configurationService.saveOrUpdate(new Configuration()).getName(), cfg.getName());
		assertEquals(configurationService.saveOrUpdate(new Configuration()).getIsActive(), cfg.getIsActive());
		assertEquals(configurationService.saveOrUpdate(new Configuration()).getType(), cfg.getType());
	}
	
}
