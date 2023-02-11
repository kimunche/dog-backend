package github.kimunche.dog.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.context.annotation.Import;

import github.kimunche.dog.config.MybatisConfiguration;
import github.kimunche.dog.dao.UserDao;


@MybatisTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import({MybatisConfiguration.class, UserDao.class, UserService.class})
class UserServiceTest {

	@Autowired
	UserService userService;
	
	@Test
	void test() {
		assertNotNull(userService.listUsers());
	}

}
