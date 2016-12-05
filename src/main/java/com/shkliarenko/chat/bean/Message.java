package main.java.com.shkliarenko.chat.bean;

public class Message {
	
	private String message;
	private User fromUser;
	private String nickname;
	
	public Message(){}
	
	public Message(String message, User fromUser, String nickname){
		this.message = message;
		this.fromUser = fromUser;
		this.nickname = nickname;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getFromUser() {
		return fromUser;
	}
	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}

}
