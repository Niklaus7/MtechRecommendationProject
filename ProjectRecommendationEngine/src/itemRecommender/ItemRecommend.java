package itemRecommender;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

import scala.collection.generic.BitOperations.Int;

public class ItemRecommend {
	String movieNames = new String();
	public ItemRecommend(){
		System.out.println("ItemRecommend called ....");
	}
	public String movienameGiver(){
//		System.out.println("##################################");
//		System.out.println(movieNames);
//		System.out.println("##################################");
		return movieNames;
	}
	public void OutputRoutine(long user){
		try {

			DataModel dm = new FileDataModel(new File("Recommendations/ItemRecommendationPOC/data/movies.csv"));
			
			//ItemSimilarity sim = new LogLikelihoodSimilarity(dm);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			TanimotoCoefficientSimilarity sim = new TanimotoCoefficientSimilarity(dm);
			
			GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(dm, sim);
			//System.out.println("Enter User ID : ");
			//int user = Integer.parseInt(br.readLine());
			//long user = Long.parseLong(br.readLine());
			System.out.println("User : "+user);
			int x=1;
			for(LongPrimitiveIterator items = dm.getItemIDs(); items.hasNext();) {
				long itemId = items.nextLong();
			//	System.out.println("item ID :"+itemId);
				List<RecommendedItem>recommendations = recommender.mostSimilarItems(itemId, 5);
				int i = 0;
				for(RecommendedItem recommendation : recommendations) {
					if(itemId == user)
					{
						//System.out.println("Item Id : "+itemId);
						DataMappingRoutine dmm = new DataMappingRoutine();
						HashMap<Long, String> mapp = dmm.createMovieMap();
						//System.out.println(mapp.get(recommendation.getItemID()));
						System.out.println(itemId + ", " + mapp.get(recommendation.getItemID()));        
					//	System.out.println(mapp);
						if(i<1){
							movieNames=mapp.get(recommendation.getItemID());
						}
						i++;
						int abc = (int) (recommendation.getValue()*250);
						System.out.println(abc);
					}
					
				}
				x++;
			//	if(x>10) System.exit(1);
			}
						
			
			
		} catch (IOException e) {
			System.out.println("There was an error.");
			e.printStackTrace();
		} catch (TasteException e) {
			System.out.println("There was a Taste Exception");
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		ItemRecommend ir = new ItemRecommend();
				

	}

}
