package com.example.carmanagement.model;

import java.util.Map;

/**
 * author by davitpetrosyan on 2019-05-05.
 */
public class CarDto {

	private final Integer id;
	private final String name;
	private final String model;
	private final String  details;

	public CarDto(Integer id, String name, String model, String details) {
		this.id = id;
		this.name = name;
		this.details = details;
		this.model = model;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getModel() {
		return model;
	}

	public String getDetails() {
		return details;
	}

}
