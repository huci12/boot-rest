package com.rest.inflearn.event;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@WebMvcTest
public class EventControllerTest {
//JUnit4 에서는 public 으로 클래스가 선언 되어 있어야 합니다.
	//계층별 테스트
		@Autowired
		MockMvc mockMvc;

		@Autowired
		ObjectMapper objectMapper;
		
		//WebMvcTest MockBean은 컨트롤러역할의 빈들은 등록하지만 다른것들은 하지 않는다.
		@MockBean
		EventRepository eventRepository; //해당 의존성이 필요하다.
		
		@Test
		public void createEvent() throws Exception {
			//isCreated 201
			Event event = Event.builder().name("Spring").description("REST API Development with Spring")
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
			event.setId(10);
			Mockito.when(eventRepository.save(event)).thenReturn(event);
			
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
			.andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_VALUE)); //TYPE SAFE 하게
			
			
			
		}
}
