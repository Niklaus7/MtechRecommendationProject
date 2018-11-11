package itemRecommender;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class DataMappingRoutine {
	
	
	public HashMap<Long, String> createMovieMap() throws NumberFormatException, IOException{
		HashMap<Long, String> Movies = new HashMap<Long, String>(); 
		
		BufferedReader brr = new BufferedReader(new FileReader("Recommendations/ItemRecommendationPOC/data/u.item"));
		String line;
	
		while((line = brr.readLine()) != null) {
			String[] values = line.split(",", -1);
			//System.out.println(values[0] + "  :  " + values[1]);
			Movies.put((long) Integer.parseInt(values[0]), values[1]);
								
			}
	//	System.out.println(Movies);
		return Movies;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DataMappingRoutine dm = new DataMappingRoutine();
		HashMap<Long, String> mapp = dm.createMovieMap();

		
	}

}
