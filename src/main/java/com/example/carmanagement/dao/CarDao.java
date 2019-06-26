package com.example.carmanagement.dao;

import com.example.carmanagement.model.CarDto;

import reactor.core.publisher.Flux;


/**
 * author by davitpetrosyan on 2019-05-05.
 */
public interface CarDao {

	Flux<CarDto> getAllCars();

}
