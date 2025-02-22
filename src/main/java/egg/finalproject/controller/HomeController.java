package egg.finalproject.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/toLogin.do")
	public String toLogin() {
		return "user/login";
	}
	
	@RequestMapping(value="/toSignup.do")
	public String toSignup() {
		return "user/signup";
	}
	
	
	
	
}
