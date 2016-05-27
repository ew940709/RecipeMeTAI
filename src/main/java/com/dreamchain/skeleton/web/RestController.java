package com.dreamchain.skeleton.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreamchain.skeleton.model.Test;
import com.dreamchain.skeleton.service.TestService;

@Controller
@RequestMapping("/test")
public class RestController {
	@Autowired
	TestService dataServices;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public @ResponseBody
	String addTest() {
			Test test = new Test();
			test.setName("Test1");
			test.setId(new Long(1));
			dataServices.save(test);
			
			return "OK";

	}
}
