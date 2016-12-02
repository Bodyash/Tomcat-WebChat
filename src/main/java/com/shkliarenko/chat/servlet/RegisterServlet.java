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
		getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		String passrep = request.getParameter("passrepeat");
		String email = request.getParameter("email");
		if (login.equals("") || login.length()<4){
			request.setAttribute("msg", "Login too short");
			getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		if (email.equals("")){
			email = null;
		}

		if (new UserDaoLocal().checkUser(login.toLowerCase())){
			request.setAttribute("msg", "Username is already registered");
		}else{
			if(pass.equals(passrep)){
				if (pass.equals("") || pass.length()<4){
					request.setAttribute("msg", "Password too short");
					getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
					return;
				}
				String passHash = Hashing.sha256()
				        .hashString(pass, StandardCharsets.UTF_8)
				        .toString();
				User u = new User(0, login.toLowerCase(), passHash, email);
				new UserDaoLocal().newUser(u);
				response.sendRedirect("index.jsp");
				return;
			}else{
				request.setAttribute("msg", "Passwords do not match");
			}
		}
		getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
		return;
		
		
	}

}
