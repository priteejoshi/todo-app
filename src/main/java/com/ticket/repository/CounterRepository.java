package com.ticket.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ticket.DataModel.Counter;
import com.ticket.DataModel.Ticket;

@Repository
	public interface CounterRepository extends MongoRepository<Counter, String>{
	public Counter findByName(String name);
	}
