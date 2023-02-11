package github.kimunche.dog.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import github.kimunche.dog.dto.LoginDto;
import github.kimunche.dog.dto.UserDto;
import github.kimunche.dog.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/api/users")
	public Object listUsers() {
		// /api/users
		return userService.listUsers();
	}
	
	
	@PostMapping("/api/user/login")
	public Object doLogin(
			HttpSession session,
			@RequestBody LoginDto param) {
		System.out.println("id : " + param.getUserId() + ", password:  " + param.getPass());
		UserDto loginUser = userService.login(param);
		if (loginUser != null) {
			session.setAttribute("LOGIN_USER", loginUser);
			return loginUser;
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//			throw new RuntimeException("LOGIN_FAILED");
		}
		
//		User loginUser = userService.login(id, pass);
//		// JSESSIONID
//		if (loginUser != null) {
//			// SESSION 에 담는다!!
//			session.setAttribute("LOGIN_USER", loginUser);
//		}
	}
	
//	@GetMapping("api/user/myInfo")
//	public Object myInfo(HttpSession session) {
//		return session.getAttribute("LOGIN_USER");
//	}
	
	@PostMapping("/logout")
	public Object logout(HttpSession session) {
		session.invalidate();// 세션을 무효화시킵니다.
		return "{}";
	}
	@GetMapping("/api/user/myInfo")
	public Object myInfo(HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("LOGIN_USER");
		System.out.println("[LOGIN USER] " + user.getUserId() + ", seq: " + user.getSeq());
		return user;
	}
	
}
