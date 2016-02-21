package com.fci.itdl.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fci.itdl.model.Offer;

@SuppressWarnings("serial")

@WebServlet(name = "ITDLServletDeleteOffer", urlPatterns = {"/ITDLServletDeleteOffer"})
public class ITDLServletDeleteOffer  extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try{
            String offerID = request.getParameter("OfferID");
            String storeEmail = request.getParameter("StoreID");
            Offer.deleteOffer(offerID, storeEmail);
            
    		response.sendRedirect("ITDLServletHome?StoreID=" + storeEmail);
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
