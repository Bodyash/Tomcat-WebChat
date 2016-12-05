package main.java.com.shkliarenko.chat.dao;
import main.java.com.shkliarenko.chat.bean.User;

public interface UserDao {
	public boolean checkUser(String login);
	public void newUser(User u);
	public User getUser(String login);
}
