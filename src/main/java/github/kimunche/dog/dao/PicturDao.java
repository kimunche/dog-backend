package github.kimunche.dog.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import github.kimunche.dog.Param;
import github.kimunche.dog.dto.PictureDto;

@Repository
public class PicturDao {

	@Autowired
	SqlSession session;
	
	public List<PictureDto> listPictures(Integer userSeq){
		return session.selectList("PictureMapper.ListDogs", userSeq);
	}

	public int addPicture(PictureDto pic) {
		int cnt = session.insert("PictureMapper.insertPicture", pic);
//		if (cnt == 1) {
//			
//		}
		return cnt;
	}

	public int delPicture(Integer picSeq) {
		return session.delete("PictureMapper.deletePicture", picSeq);
	}

	public PictureDto findPicture(Integer picSeq) {
		return session.selectOne("PictureMapper.findPicture", picSeq);
	}

	public int addBookmark(Integer userSeq, Integer picSeq) {	
		// TODO 쿼리는 전용 코둑에서 만들어 오는게 좋음!
		Map<String, Object> param =Param.make(
			"userSeq", userSeq,
			"picSeq", picSeq
		);
		return session.insert("PictureMapper.insertBookmark", param);
	}

	public int removeBookmark(Integer userSeq, Integer picSeq) {
		Map<String, Object> param =Param.make(
				"userSeq", userSeq,
				"picSeq", picSeq
			);
		return session.delete("PictureMapper.removeBookmark", param);
	}
}
