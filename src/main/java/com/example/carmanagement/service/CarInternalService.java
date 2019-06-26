package com.example.carmanagement.service;

import com.example.carmanagement.model.CarDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * author by davitpetrosyan on 2019-05-05.
 */
public interface CarInternalService {

	/*void create(CarDto car);

	Mono<CarDto> findById(Integer id);

	Flux<CarDto> findByName(String name);*/

	Flux<CarDto> findAll();

	/*Mono<CarDto> update(CarDto e);

	Mono<Void> delete(Integer id);*/
}
