package main.java.com.shkliarenko.chat.dao;

public interface UserDao {
	public boolean checkUser(String login);
	public void newUser(User u);
	public User getUser(String login);
}
