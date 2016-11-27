package main.java.com.shkliarenko.chat.servlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.hash.Hashing;

import main.java.com.shkliarenko.chat.dao.User;
import main.java.com.shkliarenko.chat.dao.UserDaoLocal;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("register.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		String passrep = request.getParameter("passrepeat");
		String email = request.getParameter("email");
		if (new UserDaoLocal().checkUser(login.toLowerCase())){
			//Login Exist
			//Must code This Part
		}else{
			if(pass.equals(passrep)){
				String passHash = Hashing.sha256()
				        .hashString(pass, StandardCharsets.UTF_8)
				        .toString();
				User u = new User(0, login.toLowerCase(), passHash, email);
				new UserDaoLocal().newUser(u);
				response.sendRedirect("index.jsp");
				return;
			}else{
				//Wrong Passwords Input
				//Must Code This Part
			}
		}
		response.sendRedirect("register.jsp");
		return;
		
		
	}

}
