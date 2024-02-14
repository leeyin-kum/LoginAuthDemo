package com.example.loginauthdemo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginConfig
{
	public boolean systemDisplayRecaptcha;
	public boolean customerDisplayRecaptcha;
	public String customerLogoUrl;
	public String customerLogoWidth;
}
