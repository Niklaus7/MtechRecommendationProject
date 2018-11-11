package movieDecisionTree;


import java.io.*;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.*;


import java.sql.*;
import java.util.*;

/**
 * Servlet implementation class DevelopMovieDecisionTree
 */
@WebServlet("/DevelopMovieDecisionTree")
public class DevelopMovieDecisionTree extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DevelopMovieDecisionTree() {
        super();
        System.out.println("************************************************");
        System.out.println("     Movie Decision Tree Servlet Called ....");
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
		String age = request.getParameter("age");
	    String Movie1 = request.getParameter("movie");
	    String Movie2 = request.getParameter("movie2");
	    String Movie3 = request.getParameter("movie3");
		FileOutputStream fop = null;
		String DomainName = "";
		Double domainID;
		List<String> movieList = new ArrayList<String>();
		movieList.add(Movie1);
		movieList.add(Movie2);
		movieList.add(Movie3);
		MovieMappingRoutine mm = new MovieMappingRoutine();
		HashMap<String, Integer> MovieMap = mm.createMovieMap();
		
		 if(Integer.parseInt(age)>0 && Movie1!="Select Movie 1" && Movie2!="Select Movie 2" && Movie3!="Select Movie 3")
	      {	   
			 	int m1 = MovieMap.get(Movie1);
				int m2 = MovieMap.get(Movie2);
				int m3 = MovieMap.get(Movie3);
				String recordset = "0 1:"+age+" 2:"+m1+" 3:"+m2+" 4:"+m3;
	    	    System.out.println("Recordset is::" +recordset);
	    	  
		  	try {

				File file = new File("Recommendations/MovieDecisionTree/data/givenData");
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
				long startTime = System.currentTimeMillis();
				
				MoviesDecisionTree md = new MoviesDecisionTree();
				long midTime = System.currentTimeMillis();
				
				domainID = md.demo();
				long endTime = System.currentTimeMillis();
				
				RecommendationProvider rp = new RecommendationProvider();
				List<String>PredictionClosure = new ArrayList<String>();
				switch(domainID.intValue()){
					case 0:
					{
						System.out.println("Probable Gender : Male");
						PredictionClosure.addAll(rp.RecommendationList("Recommendations/MovieDecisionTree/data/MRomance", movieList));
						break;					
					}
					case 1:
					{
						System.out.println("Probable Gender : Male");
						PredictionClosure.addAll(rp.RecommendationList("Recommendations/MovieDecisionTree/data/MSuspense", movieList));
						break;					
					}
					case 2:
					{
						System.out.println("Probable Gender : Male");
						PredictionClosure.addAll(rp.RecommendationList("Recommendations/MovieDecisionTree/data/MAction", movieList));
						break;					
					}
					case 3:
					{
						System.out.println("Probable Gender : Male");
						PredictionClosure.addAll(rp.RecommendationList("Recommendations/MovieDecisionTree/data/MComedy", movieList));
						break;					
					}
					case 4:
					{
						System.out.println("Probable Gender : Female");
						PredictionClosure.addAll(rp.RecommendationList("Recommendations/MovieDecisionTree/data/FRomance", movieList));
						break;					
					}
					case 5:
					{
						System.out.println("Probable Gender : Female");
						PredictionClosure.addAll(rp.RecommendationList("Recommendations/MovieDecisionTree/data/FComedy", movieList));
						break;					
					}
					case 6:
					{
						System.out.println("Probable Gender : Female");
						PredictionClosure.addAll(rp.RecommendationList("Recommendations/MovieDecisionTree/data/FDrama", movieList));
						break;					
					}
					case 7:
					{
						System.out.println("Probable Gender : Female");
						PredictionClosure.addAll(rp.RecommendationList("Recommendations/MovieDecisionTree/data/Animations", movieList));
						break;					
					}
					case 8:
					{
						System.out.println("Might be an Underage user");
						PredictionClosure.addAll(rp.RecommendationList("Recommendations/MovieDecisionTree/data/Kids", movieList));
						break;					
					}
					case 9:
					{
						System.out.println("Might be an Underage user");
						PredictionClosure.addAll(rp.RecommendationList("Recommendations/MovieDecisionTree/data/KSuspense", movieList));
						break;					
					}
					case 10:
					{
						System.out.println("Might be an Underage user");
						PredictionClosure.addAll(rp.RecommendationList("Recommendations/MovieDecisionTree/data/data10", movieList));
						break;					
					}
					case 11:
					{
						PredictionClosure.addAll(rp.RecommendationList("Recommendations/MovieDecisionTree/data/data11", movieList));
						break;					
					}
					case 12:
					{
						PredictionClosure.addAll(rp.RecommendationList("Recommendations/MovieDecisionTree/data/data12", movieList));
						break;					
					}
					default:
					{
						System.out.println("Default executed... line 137... check for switch");
						break;
					}
				}
				System.out.println("Start time : "+startTime);
				System.out.println("Mid time : "+midTime);
				System.out.println("End time : "+endTime);
				System.out.println("Total Time for Computation (in miliseconds) : "+(endTime-midTime));
				Collections.shuffle(PredictionClosure);
				System.out.println("*********** Recommendations **************");
				for(int i = 0; i<3; i++)
				{
					System.out.println(PredictionClosure.get(i));
				}
				System.out.println("******************************************");
				DomainName = PredictionClosure.get(0);
				//System.out.println(PredictionClosure);
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
		    	  out.println(DomainName);
			  	  out.println("</h3>");
			  	  out.println("</body>");
			  	  out.println("</html>");	

			} catch (IOException e) {
				e.printStackTrace();
			} 
		  	request.setAttribute("responseText",recordset);

		  	
		  		
//	    	  request.setAttribute("responseText", recordset);
//	    	// response.sendRedirect("helloworld.jsp");
//	    	  request.getRequestDispatcher("helloworld.jsp").forward(request, response);
	    	 
	        
	    	  //request.getRequestDispatcher("helloworld.jsp").forward(request, response);
	      }else
	      {
	    	  System.out.println("All Fields Mandatory");
	    	  PrintWriter out = response.getWriter();
	    	  out.println("<html>");
	    	  out.println("<title>");
	    	  out.println("Domain");
	    	  out.println("</title>");
	    	  out.println("<h1 style='color:orange'>");
	    	  out.println("Movie Recommender");
	    	  out.println("</h1>");
	    	  out.println("</head>");
	    	  out.println("<hr />");
	    	  out.println("<body>");
	    	  out.println("<h3 style='color:orange'>");
	    	  out.println("All Fields Mandatory");
		  	  out.println("</h3>");
		  	  out.println("</body>");
		  	  out.println("</html>");	
		  	  
		  		
//	    	  request.setAttribute("responseText", recordset);
//	    	  //response.sendRedirect("helloworld.jsp");
//	    	  request.getRequestDispatcher("helloworld.jsp").forward(request, response);
	      }
	    	  
	   

	}

}
