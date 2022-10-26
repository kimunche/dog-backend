package github.kimunche.dog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {


	@Override
	public void addCorsMappings(CorsRegistry reg) {
		CorsRegistration cors = reg.addMapping("/**"); // 우리 서버에 들어오는 모든 요청 전부 다
		cors.allowedOrigins("http://localhost");
		cors.allowedMethods("GET", "POST", "DELETE");
	}
}
