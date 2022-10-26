package github.kimunche.dog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import github.kimunche.dog.dao.PicturDao;
import github.kimunche.dog.dto.PictureDto;

@Service
public class DogService {
	
	@Autowired
	PicturDao pictureDao;
	
	public List<PictureDto> findDogPics(Integer userSeq){
		return pictureDao.listPictures(userSeq);
	}
	
	public int addPicture(PictureDto pic){
		return pictureDao.addPicture(pic);
	}
	/**
	 * 즐겨찾기했던 사진을 삭제함
	 * @param picSeq 지울 사진
	 * @return 잘 지줬으면 true, 사진이 없어서 못지웠으면 false
	 */
	public boolean delPicture(Integer picSeq){
		// 1. validation code!
		// .. 사진이 진짜로 있는지 확인해야함
		PictureDto pic = pictureDao.findPicture(picSeq);
		if (pic == null) {
			// 없는 사진!!!
			// return 0;
			return false; // 일단 false로
			// throw new RuntimeException("no such picture");
		}
		int delCnt = pictureDao.delPicture(picSeq);
//		if (delCnt == 1) {
//			return true;
//		} else {
//			return false;
//		}
		return delCnt == 1;
	}

	public boolean addBookmark(Integer userSeq, Integer picSeq) {
		// 1. validation code!
		PictureDto pic = pictureDao.findPicture(picSeq);
		if (pic == null) {
			// 없는 사진!!!
			// return 0;
			return false; // 일단 false로
			// throw new RuntimeException("no such picture");
		}
		// 2. validation - (userSeq, picSeq)가 이미 있는 경우 확인해야함
		// FIXME: 이거 일주일동안 해봄
		
		int cnt = pictureDao.addBookmark(userSeq, picSeq);
		return cnt == 1;
	}

	public boolean removeBookmark(Integer userSeq, Integer picSeq) {
		// 1. validation 
		// 1.1. 그림이 있는지
		// 1.2. 북마크가 있는지
		
		return 1 == pictureDao.removeBookmark(userSeq, picSeq);
	}

}
