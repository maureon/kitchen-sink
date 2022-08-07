package com.github.maureon.kitchensink;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	@GetMapping("/person")
	public String getPerson() {
		return "it works!";
	}
	
}
