package com.example.oneMoreTry.OneMoreTry;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {

	
	@GetMapping("/test")
	public String test()
	{
		return "Test is working fine";
	}
	
	@GetMapping("/hello/{name}")
	public String name(@PathVariable String name)
	{
		return "Hello  "+name;
	}
}
