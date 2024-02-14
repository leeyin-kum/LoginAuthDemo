package com.example.loginauthdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan({ "com.example.loginauthdemo" })

/**
 * Java configuration file that is used for Spring MVC and Thymeleaf
 * configurations
 */
public class WebMVCConfig implements WebMvcConfigurer
{
	//
	//	private ISpringTemplateEngine templateEngine(ITemplateResolver templateResolver)
	//	{
	//		SpringTemplateEngine engine = new SpringTemplateEngine();
	//		//			engine.addDialect(new LayoutDialect(new GroupingStrategy()));
	//		engine.addDialect(new LayoutDialect());
	//		return engine;
	//	}
	//
	//	@Override
	//	public void addResourceHandlers(ResourceHandlerRegistry registry)
	//	{
	//		if (!registry.hasMappingForPattern("/assets/**"))
	//		{
	//			registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
	//		}
	//	}

	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
					"classpath:/META-INF/resources/", "classpath:/resources/",
					"classpath:/static/", "classpath:/public/" };

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/**")
						.addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
	}
}
