package com.ticket.repository;

public interface CounterService extends CounterRepository{
	
	 long getNextSequence(String Sequence_name);
}
