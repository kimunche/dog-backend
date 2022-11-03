package github.kimunche.dog.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import github.kimunche.dog.dto.PictureDto;
import github.kimunche.dog.service.DogService;

@RestController
public class DogController {
	@Autowired
	DogService dogService;
	 final private static Integer fakeUserSeq = 1;
	
	@GetMapping("/api/dogs")
	public List<PictureDto> ListDogPicture(){
		// FIXME bookmark 속성이 PictureDto 안에 있어야 함!
		return dogService.findDogPics(fakeUserSeq);
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
	
	@DeleteMapping("/api/dog/{picSeq}") // /api/dog/3421
	public Object delDogPicture(@PathVariable Integer picSeq) {
		System.out.println("pic seq" + picSeq); // 3421
		//dogService.
		boolean deleted = dogService.delPicture(picSeq); // 
		return deleted; // 반환타입 수정해야 함.
	}
	
	@PostMapping("/api/dog/{picSeq}/bookmark")
	public Object bookmarkPicture(@PathVariable Integer picSeq) {
		System.out.println("bookmark" + picSeq);
		//dogService.
		//dogService.addPicture(pic);
		boolean success = dogService.addBookmark(fakeUserSeq, picSeq);
		return success; // true or false
	}
	@DeleteMapping("/api/dog/{picSeq}/bookmark")
	public Object unbookmarkPicture(@PathVariable Integer picSeq) {
		System.out.println("bookmark" + picSeq);
		//dogService.
		//dogService.addPicture(pic);
		boolean success = dogService.removeBookmark(fakeUserSeq, picSeq);
		return success; // true or false
	}
	
	@GetMapping("/api/dog/bookmarks")
	public List<PictureDto> loadBookmarks(){
		// FIXME bookmark 속성이 PictureDto 안에 있어야 함!
		return dogService.findBookmarks(fakeUserSeq);
	}
}
