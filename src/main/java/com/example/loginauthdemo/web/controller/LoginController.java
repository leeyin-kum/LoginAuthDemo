package com.example.loginauthdemo.web.controller;

import com.example.loginauthdemo.captcha.ICaptchaService;
import com.example.loginauthdemo.model.LoginConfig;
import com.example.loginauthdemo.service.LoginConfigService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController
{
	private LoginConfigService loginConfigService;
	@Autowired
	private ICaptchaService captchaService;

	public LoginController(LoginConfigService loginConfigService)
	{
		this.loginConfigService = loginConfigService;
	}

	@GetMapping("/{customerId}/login")
	public String redirectLogin(@PathVariable("customerId") String customerId, RedirectAttributes redirectAttributes, HttpServletRequest request)
	{
		LoginConfig loginConfig = loginConfigService.getLoginConfig(customerId);

		redirectAttributes.addFlashAttribute("loginConfig", loginConfig);
		return "redirect:/login";
	}

	//	@PostMapping("/login")
	//	public GenericResponse submitLogin(HttpServletRequest request)
	//	{
	//		String response = request.getParameter("g-recaptcha-response");
	//		captchaService.processResponse(response);
	//
	//		//		 Rest of implementation
	//
	//		return new GenericResponse("success");
	//	}

	@PostMapping("/login")
	public ModelAndView submitLogin(HttpServletRequest request)
	{
		String response = request.getParameter("g-recaptcha-response");
		captchaService.processResponse(response);
		request.setAttribute(
						View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
		return new ModelAndView("loginSuccess");
	}
	//
	//	@PostMapping("/login")
	//	public ModelAndView redirectedPostToPost()
	//	{
	//		return new ModelAndView("redirection");
	//	}

	@GetMapping("/login")
	public String loadLogin()
	{
		return "login";
	}

	@GetMapping("/loginSuccess")
	public String loadLoginSuccess()
	{
		return "loginSuccess";
	}

	@GetMapping("/")
	public String loadHome()
	{
		return "index.html";
	}

}
