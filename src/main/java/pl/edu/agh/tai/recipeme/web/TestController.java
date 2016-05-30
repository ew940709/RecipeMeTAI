package pl.edu.agh.tai.recipeme.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.edu.agh.tai.recipeme.nowe.service.UserService;

@Controller
@RequestMapping(UserController.URL)
public class TestController {

	static final String URL = "/testNasz";

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET, value = "/testuj")
	public void get(Model model, @ModelAttribute UserCommand userCommand) {
	}

}
