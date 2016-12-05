package main.java.com.shkliarenko.chat.servlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.hash.Hashing;

import main.java.com.shkliarenko.chat.bean.User;
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
				request.getSession().setAttribute("user", u);
				request.getSession().setAttribute("nickname", NameRandomizer.generateName());
				response.sendRedirect("chat.jsp");
				return;
			}else{
				request.setAttribute("msg", "Wrong Password, Try Again!");
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
		}else{
			request.setAttribute("msg", "Username Not Found, please, register");
			getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
	}

}
