/**
 * 
 */
package ratingAuthentication;

/**
 
* @author devdattag
 *
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ReviewMappingRoutine {
	
	public HashMap<Integer, Integer> createReviewMap() throws NumberFormatException, IOException{
		HashMap<Integer, Integer> Reviews = new HashMap<Integer, Integer>(); 
		
		BufferedReader brr = new BufferedReader(new FileReader("Recommendations/ReviewAuthenticityTest/data/ReviewAvarageRatings.csv"));
		String line;
	
		while((line = brr.readLine()) != null) {
			String[] values = line.split(",", -1);
			//System.out.println(values[0] + "  :  " + values[1]);
			Reviews.put(Integer.parseInt(values[0]), Integer.parseInt(values[3]));
								
			}
	//	System.out.println(Movies);
		return Reviews;
	}

	public int calculateClass(int UserRating, int AvgRating){
		int classNum=0;
		if((UserRating - AvgRating)==0)
		{
			classNum=1;
			return classNum;
		}else if((Math.abs(UserRating - AvgRating))==1)
		{
			classNum=2;
			return classNum;
		}else
		{
			classNum=3;
			return classNum;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ReviewMappingRoutine rm = new ReviewMappingRoutine();
		HashMap<Integer, Integer> mapp = rm.createReviewMap();

	}

}


