package ratingAuthentication;

import java.io.*;



import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.*;

import java.sql.*;
import java.util.*;


/**
 * Servlet implementation class DevelopReviewAuthTest
 */
@WebServlet("/DevelopReviewAuthTest")
public class DevelopReviewAuthTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DevelopReviewAuthTest() {
        super();
        System.out.println("************************************************");
        System.out.println("     Review Authentication Servlet Called ....");
        System.out.println("************************************************");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tag1 = request.getParameter("tag1");
		String tag2 = request.getParameter("tag2");
		String tag3 = request.getParameter("tag3");
		String tag4 = request.getParameter("tag4");
		String rating1 = request.getParameter("rating1");
		String rating2 = request.getParameter("rating2");
		String rating3 = request.getParameter("rating3");
		String rating4 = request.getParameter("rating4");
		String recordset = "";
		//File file = new File("Recommendations/ReviewAuthencticityTest/data/givendata");
		FileOutputStream fop = null;
		 String ReviewType = "";
		 
		 
		 
//		dm.runAllExamples();
	      
	   //   response.sendRedirect(level);
	      if(Integer.parseInt(tag1)>0 && Integer.parseInt(tag2)>0 && Integer.parseInt(tag3)>0 && Integer.parseInt(tag4)>0 && Integer.parseInt(rating1)>0 && Integer.parseInt(rating2)>0 && Integer.parseInt(rating3)>0 && Integer.parseInt(rating4)>0)
	      {
	    	  ReviewMappingRoutine rmm = new ReviewMappingRoutine();
	    	  HashMap<Integer, Integer> mapp = rmm.createReviewMap();
	    	  
	    	  System.out.println(mapp);
	    	  int avg1 = mapp.get(Integer.parseInt(tag1));
	    	  int avg2 = mapp.get(Integer.parseInt(tag2));
	    	  int avg3 = mapp.get(Integer.parseInt(tag3));
	    	  int avg4 = mapp.get(Integer.parseInt(tag4));
	    	  int diff1 = rmm.calculateClass(Integer.parseInt(rating1), avg1);
	    	  int diff2 = rmm.calculateClass(Integer.parseInt(rating2), avg2);
	    	  int diff3 = rmm.calculateClass(Integer.parseInt(rating3), avg3);
	    	  int diff4 = rmm.calculateClass(Integer.parseInt(rating4), avg4);
	    	  recordset = "1 1:"+diff1+ " " +"2:"+ diff2 + " " +"3:"+ diff3 + " " +"4:"+ diff4;
	    	  System.out.println(recordset);
	    	  try {

					File file = new File("Recommendations/ReviewAuthenticityTest/data/givenData");
					fop = new FileOutputStream(file);

					// if file doesnt exists, then create it
					if (!file.exists()) {
						file.createNewFile();
					}

					// get the content in bytes
					byte[] contentInBytes = recordset.getBytes();

					fop.write(contentInBytes);
					fop.flush();
					fop.close();

					System.out.println("Done");
					ReviewDecisionTree reviewtree = new ReviewDecisionTree();
					ReviewType = reviewtree.demo();
					PrintWriter out = response.getWriter();
			    	  out.println("<html>");
			    	  out.println("<title>");
			    	  out.println("Domain");
			    	  out.println("</title>");
			    	  out.println("<h1 style='color:orange'>");
			    	  out.println("Recommendation Decision Tree");
			    	  out.println("</h1>");
			    	  out.println("</head>");
			    	  out.println("<hr />");
			    	  out.println("<body>");
			    	  out.println("<h3 style='color:orange'>");
			    	  out.println(ReviewType);
				  	  out.println("</h3>");
				  	  out.println("</body>");
				  	  out.println("</html>");	

				} catch (IOException e) {
					e.printStackTrace();
				} 
	      }else
	      {
	    	  recordset = "All fields are mandatory";
	    	  System.out.println("All Fields Mandatory");
	    	  PrintWriter out = response.getWriter();
	    	  out.println("<html>");
	    	  out.println("<title>");
	    	  out.println("Domain");
	    	  out.println("</title>");
	    	  out.println("<h1>");
	    	  out.println("Recommendation Decision Tree");
	    	  out.println("</h1>");
	    	  out.println("</head>");
	    	  out.println("<hr />");
	    	  out.println("<body>");
	    	  out.println("<h3>");
	    	  out.println(recordset);
		  	  out.println("</h3>");
		  	  out.println("</body>");
		  	  out.println("</html>");	
//	    	  request.setAttribute("responseText", recordset);
//	    	  //response.sendRedirect("helloworld.jsp");
//	    	  request.getRequestDispatcher("helloworld.jsp").forward(request, response);
	      }
	    	  

	}

}
