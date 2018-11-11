package itemRecommender;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DevelopItemRecommendation
 */
@WebServlet("/DevelopItemRecommendation")
public class DevelopItemRecommendation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DevelopItemRecommendation() {
        super();
        System.out.println("************************************************");
        System.out.println("     User based Recommendation Servlet called ...");
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
	    String movie = request.getParameter("movie");
			String rating = request.getParameter("rating");
			String user = request.getParameter("user");
			String recordset = "";
			// File file = new File("Recommendations/HelloWorldJSP/data/givendata");
			
//			 String DomainName = "";
			 
			 
			 
//			dm.runAllExamples();
		      
		   //   response.sendRedirect(level);
		      if(Integer.parseInt(rating)>0)
		      {
		    	  System.out.println("Movie is ::" +movie);
		    	  MovieToIDmapper dmm = new MovieToIDmapper();
					HashMap<String,Long> MovietoID = dmm.getIDfromMovie();
					long movieID = MovietoID.get(movie);
		    	  recordset = user+","+movieID+"," +rating;
		    	  
			  	try {

					File file = new File("Recommendations/ItemRecommendationPOC/data/movies.csv");
					FileOutputStream fop = new FileOutputStream(file,true);

					// if file doesnt exists, then create it
					if (!file.exists()) {
						file.createNewFile();
					}

					// get the content in bytes
					byte[] contentInBytes = recordset.getBytes();
					
					fop.write(contentInBytes);
					fop.write(System.getProperty("line.separator").getBytes());
					fop.flush();
					fop.close();

					System.out.println("Done");
					ItemRecommend ir = new ItemRecommend();
					ir.OutputRoutine(Long.parseLong(user));
					String mname = ir.movienameGiver();
				//	System.out.println(recordset);
					
					PrintWriter out = response.getWriter();
					
			    	  out.println("<html>");
			    	  out.println("<title>");
			    	  out.println("Domain");
			    	  out.println("</title>");
			    	  out.println("<h1 style='color:orange' >");
			    	  out.println("Movie recommended to watch next...");
			    	  out.println("</h1>");
			    	  out.println("</head>");
			    	  out.println("<hr />");
			    	  out.println("<body>");
			    	  out.println("<h3 style='color:orange'>");
			    	  out.println(mname);
				  	  out.println("</h3>");
				  	  out.println("</body>");
				  	  out.println("</html>");	
			    	 

				} catch (IOException e) {
					e.printStackTrace();
				} 
			  	  
			  		
//		    	  request.setAttribute("responseText", recordset);
//		    	// response.sendRedirect("helloworld.jsp");
//		    	  request.getRequestDispatcher("helloworld.jsp").forward(request, response);
		    	 
		        
		    	  //request.getRequestDispatcher("helloworld.jsp").forward(request, response);
		      }else
		      {
		    	  recordset = "All fields are mandatory";
		    	  System.out.println("All Fields Mandatory");
		    	 
			  	  
			  		
//		    	  request.setAttribute("responseText", recordset);
//		    	  //response.sendRedirect("helloworld.jsp");
//		    	  request.getRequestDispatcher("helloworld.jsp").forward(request, response);
		      }
		    	  

	}

}
