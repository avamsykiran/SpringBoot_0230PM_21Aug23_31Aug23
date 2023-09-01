package com.cts.sbrdd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.sbrdd.entities.Consumer;
import com.cts.sbrdd.repos.ConsumerRepo;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	private ConsumerRepo consumerRepo;
	
	@Override
	public List<Consumer> getAll() {
		return consumerRepo.findAll();
	}

	@Override
	public Consumer getById(long consumerId) {
		return consumerRepo.findById(consumerId).orElse(null);
	}

	@Override
	public Consumer add(Consumer consumer) {
		return consumerRepo.save(consumer);
	}

	@Override
	public Consumer update(Consumer consumer) {
		return  consumerRepo.save(consumer);
	}

	@Override
	public void deleteById(long consumerId) {
		consumerRepo.deleteById(consumerId);
	}

}
