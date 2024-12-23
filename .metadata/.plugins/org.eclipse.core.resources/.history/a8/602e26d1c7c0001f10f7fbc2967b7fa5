package edu.pnu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain securityfilterChain(HttpSecurity http) throws Exception {

		// CSRF 보호 비활성화(사이트간 요청 위조)
		http.csrf(cf -> cf.disable());

		// 기본 로그인 기능을 사용(내가 만든 로그인화면 사용)
		http.formLogin(form -> 
				form.loginPage("/login")
					.defaultSuccessUrl("/loginSuccess", true));
		
		//로그인정보가 일치하지 않을시 로그
		http.exceptionHandling(ex -> ex.accessDeniedPage("/accessDenied"));

		http.logout(logout -> 
			logout.invalidateHttpSession(true) // 현재 브라우저와 연결된 세션 강제 종료
					.deleteCookies("JSESSIONID") // 세션 아이디가 저장된 쿠키 삭제
					.logoutSuccessUrl("/login")); // 로그아웃 후 이동할 URL 지정

		http.headers(hr -> hr.frameOptions(fo -> fo.disable()));

		return http.build();

	}
}
