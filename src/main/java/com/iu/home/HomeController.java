package com.iu.home;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	@Value("${my.message.hi}")
	private String message;
	
	@GetMapping("/")
	public String home()throws Exception{
		return "index";
	}

}
