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
	
	public List<PictureDto> findDogPics(){
		return pictureDao.listPictures();
	}
	
	public int addPicture(PictureDto pic){
		return pictureDao.addPicture(pic);
	}

}
