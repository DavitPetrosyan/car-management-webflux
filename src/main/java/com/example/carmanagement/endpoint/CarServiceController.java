package com.example.carmanagement.endpoint;


import com.example.carmanagement.model.CarDto;
import com.example.carmanagement.service.CarInternalService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RequestMapping("cars")
@RestController
public class CarServiceController {

	private static final Logger logger = LogManager.getLogger(CarServiceController.class);

	@Autowired
	private CarInternalService carService;

/*
	@RequestMapping(value = { "/create", "/" }, method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void create(@RequestBody CarDto carDto) {
		carService.create(carDto);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Mono<CarDto>> findById(@PathVariable("id") Integer id) {
		Mono<CarDto> carDtoMono = carService.findById(id);
		HttpStatus status = carDtoMono != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Mono<CarDto>>(carDtoMono, status);
	}

	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
	@ResponseBody
	public Flux<CarDto> findByName(@PathVariable("name") String name) {
		return carService.findByName(name);
	}*/

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	@ResponseBody
	public Flux<CarDto> findAll() {

		carService.findAll().subscribe(data -> {
			System.out.println(data.getName());
		});



		return carService.findAll();
	}

	/*@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public Mono<CarDto> update(@RequestBody CarDto carDto) {
		return carService.update(carDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Integer id) {
		carService.delete(id).subscribe();
	}*/

	/*
	@ExceptionHandler({NoSuchItemException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public String handleObjectNotFoundException(NoSuchItemException e) {
		logger.error(e::getMessage, e);
		return e.getMessage();
	}

	@ExceptionHandler({Exception.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public String handleUmRuntimeException(Exception e) {
		logger.error(e::getMessage, e);
		return e.getMessage();
	}

	@ExceptionHandler({IllegalArgumentException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String handleIllegalArgumentException(IllegalArgumentException e) {
		logger.error(e::getMessage, e);
		return e.getMessage();
	}

	@ExceptionHandler({AccessDeniedException.class})
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ResponseBody
	public String handleAccessDeniedException(AccessDeniedException e) {
		e.printStackTrace();
		logger.error(e::getMessage, e);
		return e.getMessage();
	}*/
}
