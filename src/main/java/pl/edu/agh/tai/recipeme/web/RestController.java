package pl.edu.agh.tai.recipeme.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.edu.agh.tai.recipeme.model.Test;
import skeleton.service.TestService;

@Controller
@RequestMapping("/test")
public class RestController {
	@Autowired
	TestService testService;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public @ResponseBody
	String addTest() {
			Test test = new Test();
			test.setName("Test1");
			test.setId(new Long(1));
			testService.save(test);
			
			return "OK";

	}
}
