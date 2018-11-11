package stringJaccardRecommender;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * Singleton class for providing a shared SparkContext
 * @author pratik
 *
 */
public class SparkContextProvider {
	private static SparkContextProvider sparkContextProvider;
	SparkConf conf;
	JavaSparkContext jsc;
	private SparkContextProvider(){
		conf = new SparkConf().setAppName("example_app").setMaster("local");
		jsc = new JavaSparkContext(conf);
	}
	
	public static SparkContextProvider getInstance(){
		if(sparkContextProvider == null){
			sparkContextProvider = new SparkContextProvider();
		}
		return sparkContextProvider;
	}
	
	public JavaSparkContext getSparkContext(){
		return jsc;
	}	
}
