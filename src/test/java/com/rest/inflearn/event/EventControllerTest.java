package com.rest.inflearn.event;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;


/*@RunWith(SpringRunner.class)*/
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EventControllerTest {
//JUnit4 에서는 public 으로 클래스가 선언 되어 있어야 합니다.
	//계층별 테스트
		@Autowired
		MockMvc mockMvc;

		@Autowired
		ObjectMapper objectMapper;
		
		//WebMvcTest MockBean은 컨트롤러역할의 빈들은 등록하지만 다른것들은 하지 않는다.
		//@MockBean //Mocking을 사용하지 않고 실제 레파지토리를 사용할때는 제거해야 한다.
		//EventRepository eventRepository; //해당 의존성이 필요하다.
		
		@Test
		public void createEvent_Bad_Request() throws Exception {
			//isCreated 201
			Event event = Event.builder()
					.id(100)
					.name("Spring").description("REST API Development with Spring")
					.beginEnrollmentDateTime(LocalDateTime.of(2018,11,23,14,21))
					.closeEnrollmentDateTime(LocalDateTime.of(2018,11,24,14,21))
					.beginEventDateTime(LocalDateTime.of(2018,11,25,14,21))
					.endEventDateTime(LocalDateTime.of(2018,11,26,14,21))
					.basePrice(100)
					.maxPrice(200)
					.limitOfEnrollment(100)
					.location("강남역 D2 스타텁 팩토리")
					.free(true)
					.offline(false)
					.build();
			
			//save 이벤트가 발생 하면  event를 리턴 하라
			//event.setId(10);
			//Mockito.when(eventRepository.save(event)).thenReturn(event);
			
			mockMvc.perform(post("/api/events/")
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.accept(MediaTypes.HAL_JSON)
					.content(objectMapper.writeValueAsString(event))
					)
			.andDo(print())
			.andExpect(status().isBadRequest())
			//.andExpect(jsonPath("id").exists())
			//.andExpect(header().exists("Location"))
			//.andExpect(header().exists(HttpHeaders.LOCATION)) //TYPE SAFE 하게 정의 할수 있다.
			//.andExpect(header().string("Content-Type", "application/hal+json"))
			//.andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_VALUE)) //TYPE SAFE 하게
			//.andExpect(jsonPath("id").value(Matchers.not(100)))
			//.andExpect(jsonPath("free").value(Matchers.not(true)))
			;
			
		}
		
		@Test
		public void createEvent() throws Exception {
			//isCreated 201
			EventDto event = EventDto.builder()
					.name("Spring").description("REST API Development with Spring")
					.beginEnrollmentDateTime(LocalDateTime.of(2018,11,23,14,21))
					.closeEnrollmentDateTime(LocalDateTime.of(2018,11,24,14,21))
					.beginEventDateTime(LocalDateTime.of(2018,11,25,14,21))
					.endEventDateTime(LocalDateTime.of(2018,11,26,14,21))
					.basePrice(100)
					.maxPrice(200)
					.limitOfEnrollment(100)
					.location("강남역 D2 스타텁 팩토리")
					.build();
			
			//save 이벤트가 발생 하면  event를 리턴 하라
			//event.setId(10);
			//Mockito.when(eventRepository.save(event)).thenReturn(event);
			
			mockMvc.perform(post("/api/events/")
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.accept(MediaTypes.HAL_JSON)
					.content(objectMapper.writeValueAsString(event))
					)
			.andDo(print())
			.andExpect(status().isCreated())
			.andExpect(jsonPath("id").exists())
			//.andExpect(header().exists("Location"))
			.andExpect(header().exists(HttpHeaders.LOCATION)) //TYPE SAFE 하게 정의 할수 있다.
			//.andExpect(header().string("Content-Type", "application/hal+json"))
			.andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_VALUE)) //TYPE SAFE 하게
			.andExpect(jsonPath("id").value(Matchers.not(100)))
			.andExpect(jsonPath("free").value(Matchers.not(true)))
			;
			
			
			
		}
		
}
