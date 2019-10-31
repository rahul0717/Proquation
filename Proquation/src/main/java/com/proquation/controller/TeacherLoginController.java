package com.proquation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.proquation.dao.TeacherLoginDAO;


@WebServlet("/teacherlogin")
public class TeacherLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public TeacherLoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("firstname");
		String password = request.getParameter("password");
		String message;
		TeacherLoginDAO login= new TeacherLoginDAO();
		boolean isUserValid = login.ValidateTeacher(username, password);
		if(isUserValid) {			
			RequestDispatcher rd = request.getRequestDispatcher("studentLogin.jsp");
			rd.forward(request, response);
		}
		else
		{
			message = "Login Failed!! Please check your crendentials";
			request.setAttribute("message", message);
			response.sendRedirect("teacher-login.jsp");
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
