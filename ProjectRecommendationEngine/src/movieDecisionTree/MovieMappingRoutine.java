package movieDecisionTree;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MovieMappingRoutine {
	
	
	public HashMap<String, Integer> createMovieMap() throws NumberFormatException, IOException{
		HashMap<String, Integer> Movies = new HashMap<String, Integer>(); 
		
		BufferedReader brr = new BufferedReader(new FileReader("Recommendations/MovieDecisionTree/data/MovieTree"));
		String line;
	
		while((line = brr.readLine()) != null) {
			String[] values = line.split(",", -1);
			//System.out.println(values[0] + "  :  " + values[1]);
			Movies.put(values[1], Integer.parseInt(values[2]));
								
			}
	//	System.out.println(Movies);
		return Movies;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MovieMappingRoutine mm = new MovieMappingRoutine();
		HashMap<String, Integer> mapp = mm.createMovieMap();

		
	}

}
