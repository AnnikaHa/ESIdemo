package org.test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("greetings")
public class DemoController {
	
	@RequestMapping("en")
	public String sayHello() {
		return "hello";
		
	}
}
