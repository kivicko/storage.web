package com.kivilcimeray.storage.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Configuration {

	@Id
	private String id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String type;
	
	@NotNull
	private String value;
	
	@NotNull
	private boolean isActive;
	
	@NotNull
	private String applicationName;
	
//	public Object getValueWithType() {
//		Object targetValue = null;
//		if(this.getType().equals("String")) {
//			targetValue = this.getValue().toString();
//		} else if (this.getType().equals("Integer")) {
//			targetValue = Integer.getInteger(this.getValue().toString());
//		} else if (this.getType().equals("Boolean")) {
//			targetValue = this.getValue();
//		} else if (this.getType().equals("Double")) {
//			targetValue = this.getValue();
//		}
//		
//		return targetValue;
//	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
}