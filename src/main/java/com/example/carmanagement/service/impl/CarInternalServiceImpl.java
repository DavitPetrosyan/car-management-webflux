package com.example.carmanagement.service.impl;

import com.example.carmanagement.model.CarDto;
import com.example.carmanagement.dao.CarDao;
import com.example.carmanagement.service.CarInternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * author by davitpetrosyan on 2019-05-05.
 *
 * Application business logic layer.
 */
@Service
public class CarInternalServiceImpl implements CarInternalService {

	private CarDao carDao;

	@Autowired
	public CarInternalServiceImpl(CarDao carDao) {
		this.carDao = carDao;
	}

	/*
	public void create(CarDto carDto) {
		carDao.save(carDto).subscribe();
	}

	public Mono<CarDto> findById(Integer id) {
		return carDao.findById(id);
	}

	public Flux<CarDto> findByName(String name) {
		return carDao.findByName(name);
	}*/

	public Flux<CarDto> findAll() {
		return carDao.getAllCars();
	}

	/*public Mono<CarDto> update(CarDto e) {
		return carDao.save(e);
	}

	public Mono<Void> delete(Integer id) {
		return carDao.deleteById(id);
	}*/

}
