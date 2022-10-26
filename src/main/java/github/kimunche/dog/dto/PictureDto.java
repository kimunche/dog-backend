package github.kimunche.dog.dto;

public class PictureDto {

	Integer seq;
	Boolean bookmark;
	String url;
	String origin;
	
	
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String path) {
		this.url = path;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public Boolean getBookmark() {
		return bookmark;
	}
	public void setBookmark(Boolean bookmark) {
		this.bookmark = bookmark;
	}
	@Override
	public String toString() {
		return "PictureDto [seq=" + seq + ", url=" + url + ", origin=" + origin + "]";
	}
	
	
}
