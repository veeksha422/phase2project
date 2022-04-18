package com.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Product;
/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String regex = "^[A-Z]{1,5}$";
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> errors = new HashMap<String, String>();
		String productDescription = "";
		HttpSession session = request.getSession();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(request.getParameter("productCategory"));
		
		if(!matcher.matches()) {
			errors.put("invalidCateg","Invalid category<br/>");
		}
		if(request.getParameter("productName").length() == 0) {
			errors.put("nullProdName","Enter a product name<br/>");
		}
		if(request.getParameter("productDescription").length() == 0) {
			productDescription = "No description";
		}else {
			productDescription = request.getParameter("productDescription");
		}
		try {
			Integer.parseInt(request.getParameter("productId"));
		}catch(NumberFormatException e) {
			errors.put("notInt", "<br/>Invalid product ID<br/>");
		}
		if(errors.isEmpty()) {
			Product p1 = new Product(Integer.parseInt(request.getParameter("productId")), request.getParameter("productName"), request.getParameter("productCategory"), productDescription);
			session.setAttribute("product", p1);
			response.sendRedirect("display.jsp");
		}else {
			session.setAttribute("errors", errors);
			response.sendRedirect("index.jsp");
		}
		
	}

}



