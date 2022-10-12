package github.kimunche.dog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import github.kimunche.dog.dto.PictureDto;

@Repository
public class PicturDao {

	@Autowired
	SqlSession session;
	
	public List<PictureDto> listPictures(){
		return session.selectList("UserMapper.ListDogs");
	}

	public int addPicture(PictureDto pic) {
		int cnt = session.insert("UserMapper.insertPicture", pic);
//		if (cnt == 1) {
//			
//		}
		return cnt;
	}
}
