package github.kimunche.dog.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.CALLS_REAL_METHODS;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;

import github.kimunche.dog.DaoTestBase;
import github.kimunche.dog.config.MybatisConfiguration;
import github.kimunche.dog.dto.UserDto;
/**
 * code 양을 줄어야 함!!!
 * @author USER
 *
 */
// @MybatisTest
// @AutoConfigureTestDatabase(replace = Replace.NONE)
// @Import({MybatisConfiguration.class, UserDao.class})
@Import({UserDao.class})
class UserDaoTest extends DaoTestBase{
	
	@Autowired
	UserDao userDao;

	@DisplayName("2명 있는지 확인")
	@Test
	void test() {
		List<UserDto> allUsers = userDao.listUsers();
		// assertEquals(2, allUsers.size());
		assertNotNull(allUsers);
		assertTrue(allUsers.size() > 0);
	}
	
	@DisplayName("id로 사용자 찾기!")
	@Test
	void test_find_user_by_id() {
		UserDto blue = userDao.findById("blue");
		assertNotNull(blue);
		assertEquals(1, blue.getSeq());
		assertNotNull(blue.getUserId());
		assertNotNull(blue.getUserEmail());
		assertEquals("yes@gmail.com", blue.getUserEmail());
	}
	
	@Test
//	@Rollback(false) // rollback 안함!
	void test_new_member() {
		// 1. 사전 조건
		List<UserDto> curMembers = userDao.listUsers();
		
		// 2. test 실행
		UserDto jane = new UserDto();
		jane.setUserEmail("jane@gmail.com");
		jane.setUserId("jane");
		
		userDao.insertUser(jane);
		assertNotNull(jane.getSeq());
		
		// 3. 사후 조건
		List<UserDto> nextMembers = userDao.listUsers();
		assertEquals(curMembers.size()+1, nextMembers.size());
	}
	
	@DisplayName("아이디 중복인 경우 오류 발생해야함")
	@Test
	void test_dup_userId() {
		
		UserDto blue = new UserDto();
		blue.setUserEmail("yesss@gmail.com");
		blue.setUserId("blue");
		
		assertThrows(RuntimeException.class, () -> {			
			userDao.insertUser(blue);
		});
	}
	
	@DisplayName("회원 삭제 로직")
	@Test
	void test_user_delete() {
		UserDto blue = userDao.findById("blue");
		userDao.deleteUser(blue);
		assertNull(userDao.findById("blue")); 
	}
	
}
