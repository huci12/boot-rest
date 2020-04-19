package com.rest.inflearn.event;

import org.modelmapper.ModelMapper;
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
	private final ModelMapper modelMapper;
	public EventController(EventRepository eventRepository , ModelMapper modelMapper) {
		this.eventRepository = eventRepository;
		this.modelMapper = modelMapper;
	}
	
	
	@PostMapping
	public ResponseEntity createEvent(@RequestBody EventDto eventDto) {
		//Event event = Event.builder().name(eventDto.getName()).build();
		//이런 과정을 거치지 않고 ModelMapper를 사용 하면 정보를 매핑 해줄수 있다.
		Event event = modelMapper.map(eventDto, Event.class);
		Event newEvent = this.eventRepository.save(event);
		System.out.println("eventId가 왜 짜구 Null로 떨어지지");
		System.out.println(newEvent.getId());
		URI createdUri = linkTo(EventController.class).slash(newEvent.getId()).toUri();
		return ResponseEntity.created(createdUri).body(event);
	}
}
