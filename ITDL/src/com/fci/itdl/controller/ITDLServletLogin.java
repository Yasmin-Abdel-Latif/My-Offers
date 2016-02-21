package com.fci.itdl.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.fci.itdl.model.Store;


@SuppressWarnings("serial")

@WebServlet(name = "ITDLServletLogin", urlPatterns = {"/ITDLServletLogin"})
public class ITDLServletLogin extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            String storeEmail = request.getParameter("email");
            String storePassword = request.getParameter("password");

            Store store = Store.getStore(storeEmail, storePassword);
    		if (store == null) 
    		{
    			out.println("You have entered a wrong email or password");
    			out.close();
    		}
    		else
    		{
    			response.sendRedirect("ITDLServletHome?StoreID=" + store.getEmail());
//    			HttpSession session = request.getSession(true);
//                System.out.println("123456789");
//                session.setAttribute("StoreID", store.getEmail());
//                session.setMaxInactiveInterval(30*60);
//                Cookie userName = new Cookie("StoreID", store.getEmail());
//                userName.setMaxAge(30*60);
//                response.addCookie(userName);
    		}
        }
        catch(Exception e){
        	
        }
    }
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		processRequest(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		processRequest(req, resp);
	}
}
