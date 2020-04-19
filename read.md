# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/maven-plugin/)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring HATEOAS](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#boot-features-spring-hateoas)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a Hypermedia-Driven RESTful Web Service](https://spring.io/guides/gs/rest-hateoas/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

백기선님 강의 
2.이벤트 생성 API개발 
이벤트 Repository 듣는중


hateoas 가 많이 변경 되어서 참조할것

Resource = > EntityModel
Resources = > CollectionModel
PagedResrouces -> PagedModel
ResourceSupport - > RepresentationModel
assembler.toResource - > assembler.toModel
org.springframework.hateoas.mvc.ControllerLinkBuilder=> org.springframework.hateoas.server.mvc.WebMvcLinkBuilder

MediaTypes (UTF8)인코딩이 들ㄹ어간 상수 제거

Junit 5
org.junit - > org.junit.jupiter
@Ignore - > @Disabled
@Before , @After -> @BeforeEach , @AfterEach
@TestDescription(우리가 만든거) -> @DisplayName

스프링 MVC 변경
MediaType 중에(UTF8) 인코딩이 들어간 상수 deprecation.




