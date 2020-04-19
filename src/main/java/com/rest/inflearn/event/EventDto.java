package com.rest.inflearn.event;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class EventDto {
	
	private String name;
	private String description;
	private LocalDateTime beginEnrollmentDateTime;
	private LocalDateTime closeEnrollmentDateTime;
	private LocalDateTime beginEventDateTime;
	private LocalDateTime endEventDateTime;
	private String location; //(Optional)이게 없으면 온라인 모임
	private int basePrice;//(Optional)
	private int maxPrice;//(Optional)
	private int limitOfEnrollment;
	
	//받기로 한 값들만 정의
}
