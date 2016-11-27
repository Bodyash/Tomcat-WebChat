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
import main.java.com.shkliarenko.chat.utils.NameRandomizer;

@WebServlet("/login")
public class LoginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write("Your Input: " + request.getParameter("login") + " " + request.getParameter("pass"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new UserDaoLocal().getUser(request.getParameter("login").toLowerCase());
		if (u != null){
			String passHash = Hashing.sha256()
			        .hashString(request.getParameter("pass"), StandardCharsets.UTF_8)
			        .toString();
			if (passHash.equals(u.getPassHash())){
				//If passwords equals:
				request.getSession().setAttribute("user", u);
				request.getSession().setAttribute("nickname", NameRandomizer.generateName());
				response.sendRedirect("chat.jsp");
				return;
			}else{
				response.sendRedirect("index.jsp");
				return;
				//Need to ADD SESSION MESSAGES!
			}
		}else{
			//If There is no User in DB (redirect to registration page?)
			response.sendRedirect("registation.jsp");
			return;
			//Need to ADD SESSION MESSAGES!
		}
	}

}
