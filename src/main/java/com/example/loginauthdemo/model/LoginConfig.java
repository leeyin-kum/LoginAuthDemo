package com.example.loginauthdemo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;

@Getter
@Setter
@Builder
@Scope("session")
public class LoginConfig
{
	public boolean systemDisplayRecaptcha;
	public boolean customerDisplayRecaptcha;
	public String customerLogoUrl;
	public String customerLogoWidth;
}
