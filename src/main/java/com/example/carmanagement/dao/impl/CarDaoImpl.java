package com.example.carmanagement.dao.impl;

import com.example.carmanagement.dao.CarDao;
import com.example.carmanagement.model.CarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.function.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

/**
 * author by davitpetrosyan on 2019-05-05.
 */
@Component
public class CarDaoImpl implements CarDao {


	private DatabaseClient databaseClient;

	@Autowired
	public CarDaoImpl(DatabaseClient databaseClient) {
		this.databaseClient = databaseClient;
	}

	public Flux<CarDto> getAllCars() {
		return databaseClient.execute()
				.sql("SELECT id, name, model, details FROM car")
				.as(CarDto.class)
				.fetch().all();
	}
}
