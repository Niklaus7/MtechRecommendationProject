package movieDecisionTree;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author devdattag
 *
 */
public class RecommendationProvider {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public List<String> RecommendationList(String path, List<String> mlist) throws IOException{
		List<String> recoList = new ArrayList<String>();
		BufferedReader brr = new BufferedReader(new FileReader(path));
		String line;
		while((line = brr.readLine()) != null) {
			String[] values = line.split(",", -1);
			//System.out.println(values[0] + "  :  " + values[1]);
			recoList.add(values[0]);
								
		}
		System.out.println("All Elements of A :"+recoList);
		List<String> intersection = new ArrayList<String>();
		intersection.addAll(recoList);
		System.out.println("Elements after addall : "+ intersection);
		intersection.retainAll(mlist);
		System.out.println("Intersection : "+intersection);

		recoList.removeAll(intersection);
		System.out.println("Final List : "+recoList);
		return recoList;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecommendationProvider rpp = new RecommendationProvider();

	}

}
