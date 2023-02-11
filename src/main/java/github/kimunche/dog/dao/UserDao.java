package github.kimunche.dog.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import github.kimunche.dog.dto.LoginDto;
import github.kimunche.dog.dto.UserDto;

@Repository
public class UserDao {

	@Autowired
	SqlSession session;
	
	public List<UserDto> listUsers() {
		return session.selectList("UserMapper.listUsers");
	}

	public UserDto findById(String userId) {
		// TODO Auto-generated method stub
		return session.selectOne("UserMapper.findById", userId);
	}

	public void insertUser(UserDto jane) {
		session.insert("UserMapper.insertUser",jane );
		
	}

	public void deleteUser(UserDto user) {
		session.delete("UserMapper.deleteUser", user);
	}

	public UserDto login(LoginDto param) {
		return session.selectOne("UserMapper.login", param);
//		UserDto user = new UserDto();
//		user.setSeq(223233);
//		user.setUserId(id);
//		return user;
		// TODO Auto-generated method stub
//		Map<K, V> param = new HashMap();
//		param.put("id", id);
//		param.put("pass", pass);
//		return session.selectOne("UserMapper.login", param);
	}
	
	
}
