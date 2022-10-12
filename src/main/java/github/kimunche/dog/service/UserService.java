package github.kimunche.dog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import github.kimunche.dog.dao.UserDao;
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
}
