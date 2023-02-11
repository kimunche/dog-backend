package github.kimunche.dog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * 테스트 주도 개발(TDD)
 * 
 * @author USER
 *
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {


	@Override
	public void addCorsMappings(CorsRegistry reg) {
		CorsRegistration cors = reg.addMapping("/**"); // 우리 서버에 들어오는 모든 요청 전부 다
		cors.allowedOrigins("http://localhost", "http://localhost:5173");
		cors.allowedMethods("GET", "POST", "DELETE");
		cors.allowCredentials(true); // fe에서 보내는 쿠키를 허용해줌
	}
}
