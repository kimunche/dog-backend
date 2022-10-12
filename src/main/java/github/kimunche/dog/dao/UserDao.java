package github.kimunche.dog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import github.kimunche.dog.dto.UserDto;

@Repository
public class UserDao {

	@Autowired
	SqlSession session;
	
	public List<UserDto> listUsers() {
		return session.selectList("UserMapper.listUsers");
	}
	
}
