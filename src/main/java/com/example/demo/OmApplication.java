package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class OmApplication {

	@Autowired
	private TranBean bean;

	private static OmApplication omApplication;

	@PostConstruct
	public void init() {
		omApplication = this;
		omApplication.bean = this.bean;
	}

	public static void main(String[] args) {
		SpringApplication.run(OmApplication.class, args);

		String json = omApplication.bean.objectToJson(new Person("1", 2));
		System.out.println(json);
		Person p = (Person) omApplication.bean.jsontoObject(json, Person.class);
		System.out.println(p);
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();

	}
}
