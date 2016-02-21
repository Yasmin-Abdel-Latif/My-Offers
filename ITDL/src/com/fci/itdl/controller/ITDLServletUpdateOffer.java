package com.fci.itdl.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fci.itdl.model.Offer;

@SuppressWarnings("serial")

@WebServlet(name = "ITDLServletUpdateOffer", urlPatterns = {"/ITDLServletUpdateOffer"})
public class ITDLServletUpdateOffer extends HttpServlet {
	public static Offer offerChosen = null;
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try{
        	String offerID = request.getParameter("OfferID");
            String storeEmail = request.getParameter("StoreID");
            offerChosen = Offer.getOffer(offerID);
            
    		response.sendRedirect("updateOffer.jsp?StoreID=" + storeEmail);
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
		String offerStart = req.getParameter("datepickerStart");
        String offerEnd = req.getParameter("datepickerEnd");
        String offerCategory = req.getParameter("category");
        String offerContent = req.getParameter("offerContent");
        String offerID = req.getParameter("OfferID");
        String storeEmail = (String) req.getParameter("StoreID");
        
    	Offer offer = new Offer(offerID, offerCategory, offerContent, offerStart, offerEnd);
		Offer.updateOffer(offer, storeEmail);
		
		resp.sendRedirect("ITDLServletHome?StoreID=" + storeEmail);
	}
}
