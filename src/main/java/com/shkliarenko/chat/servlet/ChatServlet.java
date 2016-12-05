package main.java.com.shkliarenko.chat.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.shkliarenko.chat.bean.Message;
import main.java.com.shkliarenko.chat.bean.User;

@WebServlet(asyncSupported = true, urlPatterns = { "/message" })
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usermsg = request.getParameter("usermsg");
		User u = (User) request.getSession().getAttribute("user");
		String nickname = (String) request.getSession().getAttribute("nickname");
		if (getServletContext().getAttribute("messagelist") == null){
			ArrayList<Message> list = new ArrayList<Message>();
			list.add(new Message(usermsg, u, nickname));
			getServletContext().setAttribute("messagelist", list);
		}else{
			ArrayList<Message> list = (ArrayList<Message>) getServletContext().getAttribute("messagelist");
			if (list.size() > 13){
				ArrayList<Message> newList = new ArrayList<>();
				for (int i = 3; i < list.size(); i++) {
					newList.add(list.get(i));
				}
				list.clear();
				list.addAll(newList);
			}
			list.add(new Message(usermsg, u, nickname));
		}
		
		response.sendRedirect("chat.jsp");
	}

}
