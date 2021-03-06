package com.rest.inflearn.event;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



public class EventTest {
//Junit4 에서 TEST 클래스는 반드시 Pulbic 이어야 합니다. 
	@Test
	public void builder() {
		Event event = Event.builder().name("Inflearn Spring REST API").description("REST API development with Spring").build();
		assertThat(event).isNotNull();
	}
	
	@Test
	public void javaBean() {
		
		//Given
		String name = "Event";
		String description = "Spring";
		
		//When
		Event event = new Event();
		event.setName("Event");
		event.setDescription("Spring");
		
		//Then
		assertThat(event.getName()).isEqualTo(name);
		assertThat(event.getDescription()).isEqualTo(description);
	}

}
