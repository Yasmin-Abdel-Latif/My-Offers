package com.fci.itdl.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.fci.itdl.model.Offer;


@SuppressWarnings("serial")

@WebServlet(name = "ITDLServletAddOffer", urlPatterns = {"/ITDLServletAddOffer"})
public class ITDLServletAddOffer extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try{
            String offerStart = request.getParameter("datepickerStart");
            String offerEnd = request.getParameter("datepickerEnd");
            String offerCategory = request.getParameter("category");
            String offerContent = request.getParameter("offerContent");
            
            String storeEmail = (String) request.getParameter("StoreID");
            
        	Offer offer = new Offer(offerCategory, offerContent, offerStart, offerEnd);
    		offer.saveOffer(storeEmail);
            
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
