package github.kimunche.dog;

import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.context.annotation.Import;

import github.kimunche.dog.config.MybatisConfiguration;
import github.kimunche.dog.dao.UserDao;

@MybatisTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import({MybatisConfiguration.class})
public class DaoTestBase {
}
