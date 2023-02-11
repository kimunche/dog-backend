package github.kimunche.dog.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import github.kimunche.dog.DaoTestBase;

@Import(PicturDao.class)
class PicturDaoTest extends DaoTestBase{

	@Autowired
	PicturDao pictureDao;
	
	@Test
	void test() {
		assertNotNull(pictureDao);
	}

}
