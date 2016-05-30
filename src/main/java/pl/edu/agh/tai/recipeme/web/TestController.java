package pl.edu.agh.tai.recipeme.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.edu.agh.tai.recipeme.nowe.service.UserService;

@Controller
@RequestMapping("/testUsera")
public class TestController {

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET, value = "/testuj")
	public @ResponseBody String get() {
		userService.createUser("Ewa", "passwd", false);
		return "OK";
	}

}
