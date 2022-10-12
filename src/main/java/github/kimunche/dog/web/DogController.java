package github.kimunche.dog.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import github.kimunche.dog.dto.PictureDto;
import github.kimunche.dog.service.DogService;

@RestController
public class DogController {
	@Autowired
	DogService dogService;
	
	@GetMapping("/api/dogs")
	public List<PictureDto> ListDogPicture(){
		return dogService.findDogPics();
	}
	/**
	 * insert new dog picture
	 * @return
	 */
	@PostMapping("/api/dog")
	public Object addDogPicture(@RequestBody PictureDto pic) {
		System.out.println("pic" + pic.toString());
		//dogService.
		dogService.addPicture(pic);
		return "true";
	}

}
