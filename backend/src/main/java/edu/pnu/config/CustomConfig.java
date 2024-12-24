package edu.pnu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.annotation.Nonnull;

//react연동
@Configuration
public class CustomConfig implements WebMvcConfigurer{

//	시큐리티를 위한 Authorization 헤더가 필요한 경우
	@Override
	public void addCorsMappings(@Nonnull CorsRegistry registry) {
		registry.addMapping("/**")
			.allowCredentials(true) // 클라이언트가 자격증명(쿠키/인증헤더)을 포함하도록 허용
			.allowedHeaders(HttpHeaders.AUTHORIZATION) // 클라이언트가 요청 시 사용할 수 있는 헤더 지정
			.exposedHeaders(HttpHeaders.AUTHORIZATION) // 클라이언트가 응답에 접근할 수 있는 헤더 지정
			.allowedMethods(HttpMethod.GET.name(),
							HttpMethod.POST.name(),
							HttpMethod.PUT.name(),
							HttpMethod.DELETE.name())
			.allowedOrigins("http://localhost:3000",
							"http://127.0.0.1:3000");
	}
}
