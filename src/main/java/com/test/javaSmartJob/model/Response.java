package com.test.javaSmartJob.model;

import java.util.Map;

import org.springframework.http.HttpStatus;

import lombok.*;

@Data
public class Response {
	
	@NonNull public Map<String, String> messageResponse;
	@NonNull public HttpStatus codeResponse;
}
