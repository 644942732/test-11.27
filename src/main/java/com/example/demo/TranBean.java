package com.example.demo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TranBean {

	@Autowired
	private ObjectMapper mapper;

	public ObjectMapper getMapper() {
		return mapper;
	}

	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}

	public String objectToJson(Object obj) {
		String json = null;
		try {
			json = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;

	}

	@SuppressWarnings("unchecked")
	public Object jsontoObject(String json, @SuppressWarnings("rawtypes") Class clazz) {
		Object object = null;
		try {
			object = mapper.readValue(json, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return object;
	}
}
