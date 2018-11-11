package reviewToRating;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DevelopReviewToRating
 */
@WebServlet("/DevelopReviewToRating")
public class DevelopReviewToRating extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DevelopReviewToRating() {
        super();
        System.out.println("************************************************");
        System.out.println("     Review To Rating Servlet Called ....");
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
		String reviewText = request.getParameter("reviewText");
		System.out.println("Review Text : ");
		System.out.println(reviewText);
		ReviewMapperRoutine r = new ReviewMapperRoutine();
		String ratingNum = r.ReviewToRatingConvertor(reviewText);
		System.out.println("Final Rating : "+ratingNum);
		PrintWriter out = response.getWriter();
  	  out.println("<html>");
  	  out.println("<title>");
  	  out.println("Domain");
  	  out.println("</title>");
  	  out.println("<h1 style='color:orange'>");
  	  out.println("Final Rating for the Review");
  	  out.println("</h1>");
  	  out.println("</head>");
  	  out.println("<hr />");
  	  out.println("<body>");
  	  out.println("<h3 style='color:orange'>");
  	  out.println(ratingNum);
	  	  out.println("</h3>");
	  	  out.println("</body>");
	  	  out.println("</html>");	
	}

}
