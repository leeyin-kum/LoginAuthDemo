package com.example.loginauthdemo.web.controller;

import com.example.loginauthdemo.model.LoginConfig;
import com.example.loginauthdemo.service.LoginConfigService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LayoutLoginController
{
	private LoginConfigService loginConfigService;
	private LoginConfig loginConfig;

	public LayoutLoginController(LoginConfigService loginConfigService)
	{
		this.loginConfigService = loginConfigService;
	}

	@GetMapping("/layout/{customerId}/login")
	public String layout_redirectLogin(@PathVariable("customerId") String customerId, RedirectAttributes redirectAttributes)
	{
		loginConfig = loginConfigService.getLoginConfig(customerId);

		redirectAttributes.addFlashAttribute("loginConfig", loginConfig);
		return "redirect:/layout_login";
	}

	@GetMapping("/layout_login")
	public String loadLayoutLogin()
	{
		return "layout_login";
	}

	@PostMapping("/layout_login")
	public String submitLogin()
	{
		return "redirect:/layout_loginSuccess";
	}

	@GetMapping("/layout_loginSuccess")
	public String loadLayoutLoginSuccess(HttpServletRequest request)
	{
		request.setAttribute("loginConfig", loginConfig);
		return "layout_loginSuccess";
	}
}
