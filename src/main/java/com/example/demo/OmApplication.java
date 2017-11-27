package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class OmApplication {


	private static TranBean bean;

	@Autowired
	public void setBean(TranBean bean) {
		this.bean = bean;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OmApplication.class, args);

		String json = bean.objectToJson(new Person("1", 2));
		System.out.println(json);
		Person p = (Person) bean.jsontoObject(json, Person.class);
		System.out.println(p);
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();

	}
}
