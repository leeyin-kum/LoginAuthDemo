package com.example.loginauthdemo.web.controller;

import com.example.loginauthdemo.model.LoginConfig;
import com.example.loginauthdemo.service.LoginConfigService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LayoutLoginController
{
	private LoginConfigService loginConfigService;

	public LayoutLoginController(LoginConfigService loginConfigService)
	{
		this.loginConfigService = loginConfigService;
	}

	@GetMapping("/layout/{customerId}/login")
	public String layout_redirectLogin(@PathVariable("customerId") String customerId, RedirectAttributes redirectAttributes)
	{
		LoginConfig loginConfig = loginConfigService.getLoginConfig(customerId);

		redirectAttributes.addFlashAttribute("loginConfig", loginConfig);
		return "redirect:/layout_login";
	}

	@GetMapping("/layout_login")
	public String loadLayoutLogin()
	{
		return "layout_login";
	}
}
