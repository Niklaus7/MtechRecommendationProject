package reviewToRating;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class ReviewMapperRoutine {

	public HashMap<String, Integer> createReviewMap() throws NumberFormatException, IOException{
		HashMap<String, Integer> Movies = new HashMap<String, Integer>(); 

		BufferedReader brr = new BufferedReader(new FileReader("/home/devdatta/ReviewKeywords.csv"));
		String line;

		while((line = brr.readLine()) != null) {
			String[] values = line.split(",", -1);
			//System.out.println(values[0] + "  :  " + values[1]);
			Movies.put(values[0],Integer.parseInt(values[1]));					
		}
		//	System.out.println(Movies);
		return Movies;
	}

	public String ReviewToRatingConvertor(String s) throws NumberFormatException, IOException{
		HashMap<String, Integer> mapp = createReviewMap();
		Scanner in = new Scanner(System.in);
		
		String reviewText = s;
		int score=3;
		String scoreToReturn = "";
		int unfoundKeywords = mapp.keySet().size();
		for (String key : mapp.keySet()) {
			if(reviewText.contains(key)){
				score=score+mapp.get(key);
				unfoundKeywords--;
			}
		} 
		if(unfoundKeywords==19)
		{
			System.out.println("Irrelevant rating");
			scoreToReturn = "Irrelevant rating";
			return scoreToReturn;
		}else {
			if(score>5)

			{
				score = 5;
				
			}else if(score<0)
			{
				score = 0;
				
			}
			scoreToReturn = String.valueOf(score);
			System.out.println("Review Score : "+score);
			return scoreToReturn;
		}
	}
}