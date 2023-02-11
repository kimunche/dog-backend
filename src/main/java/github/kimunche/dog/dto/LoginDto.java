package github.kimunche.dog.dto;

public class LoginDto {
	String userId;
	String pass;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "LoginDto [userId=" + userId + ", pass=" + pass + "]";
	}
}
