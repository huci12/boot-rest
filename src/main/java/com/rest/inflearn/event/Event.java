package com.rest.inflearn.event;

import java.time.LocalDateTime;

import javax.persistence.*;
import lombok.*;


@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode(of = "id")
@Entity
public class Event {

	@Id @GeneratedValue
	private Integer id;
	
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
	private boolean offline;
	private boolean free;
	@Enumerated(EnumType.STRING)
	private EventStatus eventStatus = EventStatus.DRAFT;
}
