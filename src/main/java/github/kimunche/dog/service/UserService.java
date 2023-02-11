package github.kimunche.dog.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import github.kimunche.dog.dao.UserDao;
import github.kimunche.dog.dto.LoginDto;
import github.kimunche.dog.dto.UserDto;

@Service
@Transactional // 트랜잭션
public class UserService {

	@Autowired
	UserDao userDao;
	

	public List<UserDto> listUsers() {
		// xxxVO vs xxxxDto: data transfer object 
		return userDao.listUsers();
	}
	
	
	public UserDto join(UserDto member) {
		return null;
//		if (userDao.existUser(member.getUserId())) {
//			
//		}
	}


	public UserDto login(LoginDto param) {
		UserDto user = userDao.login(param); // SELECT * FROM users where user_id = 'aaaa' AND user_pass = '338383';
		return user;
	}
}
