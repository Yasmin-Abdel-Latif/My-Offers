package com.fci.itdl.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.fci.itdl.model.Offer;
import com.fci.itdl.model.Store;


@SuppressWarnings("serial")

@WebServlet(name = "ITDLServletHome", urlPatterns = {"/ITDLServletHome"})
public class ITDLServletHome extends HttpServlet {
	
	public static ArrayList<Offer> offers;
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try{
        	offers = new ArrayList<Offer>();
            String storeEmail = request.getParameter("StoreID");
            offers.addAll(Store.getStoreOffers(storeEmail));
			response.sendRedirect("homepage.jsp?StoreID=" + storeEmail);
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
