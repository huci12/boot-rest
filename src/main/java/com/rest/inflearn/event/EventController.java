package com.rest.inflearn.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;


@Controller
@RequestMapping(value="/api/events" , produces = MediaTypes.HAL_JSON_VALUE) //해당 핸들러안에 있는건 모두 HAL JSON VALUE응답을 보냅니다.
public class EventController {

	private final EventRepository eventRepository;
	
	public EventController(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	@PostMapping
	public ResponseEntity createEvent(@RequestBody Event event) {
		Event newEvent = this.eventRepository.save(event);
		URI createdUri = linkTo(EventController.class).slash(newEvent.getId()).toUri();
		return ResponseEntity.created(createdUri).body(event);
	}
}
