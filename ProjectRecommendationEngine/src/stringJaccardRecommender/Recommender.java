package stringJaccardRecommender;


import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

/**
 * Recommender interface
 * @author pratik
 *
 */
public interface Recommender{
	public List<User> getUserRecommendations(String coursesCSVFilePath, String usersCSVFilePath, int numRecommendation, String namee);
}
