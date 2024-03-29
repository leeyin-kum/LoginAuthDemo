package com.example.loginauthdemo.captcha;

import com.example.loginauthdemo.web.error.ReCaptchaInvalidException;

public interface ICaptchaService
{

	default void processResponse(final String response) throws ReCaptchaInvalidException
	{
	}

	default void processResponse(final String response, String action) throws ReCaptchaInvalidException
	{
	}

	String getReCaptchaSite();

	String getReCaptchaSecret();
}
