package com.cts.sbrdd.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.sbrdd.entities.Consumer;
import com.cts.sbrdd.exceptions.ConsumerNotFoundException;
import com.cts.sbrdd.exceptions.InvalidConsumerDetailsException;
import com.cts.sbrdd.services.ConsumerService;

@RestController
@RequestMapping("/consumers")
public class ConsumerController {

	@Autowired 
	private ConsumerService consumerService;

	@GetMapping
	public ResponseEntity<List<Consumer>> getAll(){
		return new ResponseEntity<List<Consumer>>(consumerService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{cid}")
	public ResponseEntity<Consumer> getById(@PathVariable("cid") long consumerId) throws ConsumerNotFoundException{
		Consumer consumer = consumerService.getById(consumerId);
		if(consumer==null) {
			throw new ConsumerNotFoundException();
		}
		return new ResponseEntity<Consumer>(consumer, HttpStatus.OK);
	}

	@DeleteMapping("/{cid}")
	public ResponseEntity<Void> deleteById(@PathVariable("cid") long consumerId) {
		consumerService.deleteById(consumerId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping
	public ResponseEntity<Consumer> addConsumer(@RequestBody @Valid Consumer consumer,BindingResult results) throws InvalidConsumerDetailsException{
		if(results.hasErrors()) {
			throw new InvalidConsumerDetailsException(results);
		}
		consumer = consumerService.add(consumer);
		
		return new ResponseEntity<Consumer>(consumer,HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Consumer> updateConsumer(@RequestBody @Valid Consumer consumer,BindingResult results) throws InvalidConsumerDetailsException{
		if(results.hasErrors()) {
			throw new InvalidConsumerDetailsException(results);
		}
		consumer = consumerService.update(consumer);
		
		return new ResponseEntity<Consumer>(consumer,HttpStatus.ACCEPTED);
	}
}
