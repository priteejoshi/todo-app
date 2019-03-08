package com.ticket.repository;

import java.util.List;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ticket.DataModel.Ticket;

@Repository
public interface TicketRepository extends CrudRepository<Ticket,String>, QuerydslPredicateExecutor<Ticket>,TicketRepositoryCustom {
public Ticket findByTicketNo(String ticketNo);
public List<Ticket> findByWorkGroup(String workGroup);
//public Ticket findOne(String id);


}