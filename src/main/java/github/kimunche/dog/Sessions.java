package github.kimunche.dog;

import javax.servlet.http.HttpSession;

import github.kimunche.dog.dto.UserDto;

public class Sessions {

	public static UserDto getUser(HttpSession session) {
		return (UserDto) session.getAttribute("LOGIN_USER");
	}
}
