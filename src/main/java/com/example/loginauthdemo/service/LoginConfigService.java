package com.example.loginauthdemo.service;

import com.example.loginauthdemo.model.LoginConfig;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginConfigService
{
	public LoginConfig getLoginConfig(String customerId)
	{
		if(Objects.equals(customerId, "google"))
		{
			return LoginConfig.builder()
							.customerDisplayRecaptcha(true)
							.systemDisplayRecaptcha(true)
							.customerLogoUrl("../assets/customer/google/google_logo.svg")
							.customerLogoWidth("170")
							.build();

		} else if ("microsoft".equals(customerId))
		{
			return LoginConfig.builder()
							.customerDisplayRecaptcha(false)
							.systemDisplayRecaptcha(true)
							.customerLogoUrl("../assets/customer/microsoft/microsoft_logo.svg")
							.customerLogoWidth("150")
							.build();
		}

		return LoginConfig.builder().build();

	}
}
