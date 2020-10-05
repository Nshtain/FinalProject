package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import kolesnick.SummaryTask.db.entity.User;

public class GetUserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		UserDao udao = new UserDao();
		User user = udao.getUser(login, password);
		
		if (user.getRole_id() == 1) {
			getServletContext().getRequestDispatcher("pages/user.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("/home.jsp").forward(request, response);			
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
