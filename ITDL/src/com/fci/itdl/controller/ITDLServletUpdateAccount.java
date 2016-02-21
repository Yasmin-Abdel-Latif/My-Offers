package com.fci.itdl.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fci.itdl.model.Store;

@SuppressWarnings("serial")

@WebServlet(name = "ITDLServletUpdateAccount", urlPatterns = {"/ITDLServletUpdateAccount"})
public class ITDLServletUpdateAccount extends HttpServlet {
	public static Store storeLoggedin = null;
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try{
        	String storeEmail = request.getParameter("StoreID");
            storeLoggedin = Store.getStore(storeEmail);
            
    		response.sendRedirect("updateAccount.jsp?StoreID=" + storeEmail);
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
		String storeEmail = req.getParameter("email");
        String storeName = req.getParameter("name");
        String storePassword = req.getParameter("password");
        
    	storeLoggedin.updateStore(storeName, storeEmail, storePassword);
		
		resp.sendRedirect("ITDLServletHome?StoreID=" + storeEmail);
	}
}
