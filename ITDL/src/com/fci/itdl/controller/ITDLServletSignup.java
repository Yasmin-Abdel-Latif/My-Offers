package com.fci.itdl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.fci.itdl.model.Store;


@SuppressWarnings("serial")

@WebServlet(name = "ITDLServletSignup", urlPatterns = {"/ITDLServletSignup"})
public class ITDLServletSignup extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        try{

            String storeEmail = req.getParameter("email");
            String storeLatitude = req.getParameter("latitude");
            String storeLongitude = req.getParameter("longitude");
            String storeAddress = req.getParameter("address");
            String storePassword = req.getParameter("password");
            String storeName = req.getParameter("name");
            Store store = new Store(storeName, storeEmail, storePassword, storeAddress, Double.parseDouble(storeLatitude), Double.parseDouble(storeLongitude));
    		store.saveStore();
            out.println(storeEmail);
            out.close();
//    		HttpSession session = req.getSession(true);
//            session.setAttribute("StoreID", storeEmail);
//            session.setMaxInactiveInterval(30*60);
//            Cookie userName = new Cookie("StoreID", storeEmail);
//            userName.setMaxAge(30*60);
//            resp.addCookie(userName);
        }
        catch(Exception e){
        	
        }
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		resp.setContentType("text/html;charset=UTF-8");
		String responseOut = "";
        PrintWriter out = resp.getWriter();
        try{

            String storeEmail = req.getParameter("email");
            Store store = Store.getStore(storeEmail);
    		if (store == null) 
    		{
    			responseOut = "<font size=\"4\" color=\"#000000\" face=\"Lucida Calligraphy\"><b>If the store is not in the current location"
	                		+ ", then please enter the store address at the box below</b></font><br>"
	                		+ "<input type=\"text\" id=\"address\" name=\"address\" placeholder=\"Store Address...\"> <br>";
                out.println(responseOut);
    		}
        }
        catch(Exception e){
        	
        }
	}
}
