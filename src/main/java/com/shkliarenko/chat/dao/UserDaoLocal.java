package main.java.com.shkliarenko.chat.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.shkliarenko.chat.bean.User;

public class UserDaoLocal implements UserDao {

	@Override
	public boolean checkUser(String login) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "test1230");
				ResultSet rs = connection
						.prepareStatement("SELECT * FROM users WHERE login='" + login +"'").executeQuery()){
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void newUser(User u) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "test1230");
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO users (login, pass, mail) VALUES (?, ?, ?)")){
			preparedStatement.setString(1, u.getLogin());
			preparedStatement.setString(2, u.getPassHash());
			preparedStatement.setString(3, u.getEmail());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUser(String login) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "test1230");
				ResultSet rs = connection
						.prepareStatement("SELECT * FROM users WHERE login='" + login +"'").executeQuery()){
			if (rs.next()) {
				User u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}
