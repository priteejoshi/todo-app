package com.ticket.DataModel;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Counter")
public class Counter  {
	
	private String name;
	
	private long sequence;

	public Counter(String name, long sequence) {
	    super();
	    this.name = name;
	    this.sequence = sequence;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSequence() {
		return sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

	@Override
    public String toString() {
	    return "Counter [name=" + name + ", sequence=" + sequence + "]";
    }
	
	
	
}
