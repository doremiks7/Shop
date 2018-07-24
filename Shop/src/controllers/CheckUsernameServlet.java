package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.UserDB;

/**
 * Servlet implementation class CheckUsername
 */
@WebServlet("/CheckUsername")
public class CheckUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDB userDB = new UserDB();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUsernameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!userDB.checkPass(request.getParameter("password"))) {
			response.getWriter().write("Password must than 6 characters");
		}
		else {
			response.getWriter().write("<img src=\"img/available.png\" />");
		}
		
		
	}

}
