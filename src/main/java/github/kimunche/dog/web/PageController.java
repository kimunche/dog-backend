package github.kimunche.dog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping("/")
	public String pageMain() {
		// jsp : template engine html 그려주는 애
		return "index"; // src/main/resources: templates/index.html
	}
}
