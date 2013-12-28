package com.practicalJava.lesson14.chapter27;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class StockServerServlet
 */
@WebServlet("/pricequote")
public class StockServerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StockServerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String symbol = (request.getParameter("symbol")).toUpperCase();	
		String price = new StockQuoteGenerator().getPrice(symbol);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
	
		out.printf("<html>"+ 
					"<body text=\"#336699\">"+
				   		"<h2>Requested symbol: <font color = red>%s</font>"+
				   		"<h2>Price: <font color = green>%s</font>"+
				    "</body>"+
				   "</html>", 
				   symbol,price
		);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
