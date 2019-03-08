package com.ticket.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ticket.DataModel.PriorityMetrics;
import java.lang.String;
import java.util.List;

@Repository
public interface PriorityMetricsRepository extends MongoRepository<PriorityMetrics, String>{
	// List<PriorityMetrics> findByType(String type);
	 //public PriorityMetrics findBySeverity(String severity);
    @Query(value = "{ 'priority' : ?0, 'type' : ?1, 'subType' : ?2 }")
	 PriorityMetrics findByPriorityAndTypeAndSubType(String priority,String Type,String subType);

	
		}

