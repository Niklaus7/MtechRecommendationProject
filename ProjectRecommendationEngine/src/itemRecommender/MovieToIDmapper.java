
package itemRecommender;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MovieToIDmapper {
	
	
	public HashMap<String, Long> getIDfromMovie() throws NumberFormatException, IOException{
		HashMap<String, Long> Movies = new HashMap<String, Long>(); 
		
		BufferedReader brr = new BufferedReader(new FileReader("Recommendations/ItemRecommendationPOC/data/u.item"));
		String line;
	
		while((line = brr.readLine()) != null) {
			String[] values = line.split(",", -1);
			//System.out.println(values[0] + "  :  " + values[1]);
			Movies.put(values[1],(long) Integer.parseInt(values[0]));
								
			}
	//	System.out.println(Movies);
		return Movies;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MovieToIDmapper dm = new MovieToIDmapper();
		HashMap<String, Long> mapp = dm.getIDfromMovie();

		
	}

}
