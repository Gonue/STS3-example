package com.example.hello;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloApplicationTests {

	@Test
	void contextLoads() throws JsonProcessingException {
		System.out.println("-------------");
		//Text JSON -> Object
		//Object -> Text JSON

		var objectMapper = new ObjectMapper();
		//object -> text
		//object mapper get method
		var user = new User("steve", 10,"010-1111-2222");

		var text = objectMapper.writeValueAsString(user);
		System.out.println(text);
		//text -> object

		var objectUser = objectMapper.readValue(text, User.class);
		System.out.println(objectUser);
	}

}
