package com.example.loginauthdemo.web.controller;

import com.example.loginauthdemo.captcha.ICaptchaService;
import com.example.loginauthdemo.model.LoginConfig;
import com.example.loginauthdemo.service.LoginConfigService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController
{
	private LoginConfigService loginConfigService;
	private LoginConfig loginConfig;
	@Autowired
	private ICaptchaService captchaService;

	public LoginController(LoginConfigService loginConfigService)
	{
		this.loginConfigService = loginConfigService;
	}

	@GetMapping("/{customerId}/login")
	public String redirectLogin(@PathVariable("customerId") String customerId, RedirectAttributes redirectAttributes, HttpServletRequest request)
	{
		loginConfig = loginConfigService.getLoginConfig(customerId);

		redirectAttributes.addFlashAttribute("loginConfig", loginConfig);
		return "redirect:/login";
	}

	@PostMapping("/login")
	public String submitLogin(HttpServletRequest request)
	{
		String response = request.getParameter("g-recaptcha-response");
		captchaService.processResponse(response);

		//		 Rest of implementation
		return "redirect:/loginSuccess";
	}

	@GetMapping("/login")
	public String loadLogin()
	{
		return "login";
	}

	@GetMapping("/loginSuccess")
	public String loadLoginSuccess(HttpServletRequest request)
	{
		request.setAttribute("loginConfig", loginConfig);
		return "loginSuccess";
	}

	@GetMapping("/")
	public String loadHome()
	{
		return "index.html";
	}

}
