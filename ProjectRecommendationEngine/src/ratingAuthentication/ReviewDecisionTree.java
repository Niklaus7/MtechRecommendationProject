package ratingAuthentication;

/**
 * 
 */

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.mllib.regression.LabeledPoint;
import org.apache.spark.mllib.tree.DecisionTree;
import org.apache.spark.mllib.tree.model.DecisionTreeModel;
import org.apache.spark.mllib.util.MLUtils;



import scala.Tuple2;

/**
 * @author devdattag
 *
 */
public class ReviewDecisionTree implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -839480507722373412L;

	static class testErrors implements Function<Tuple2<Double, Double>, Boolean> {
		/**
		 *  Used for testing the error coefficient
		 */
		private static final long serialVersionUID = -1496754373157898204L;

		@Override
		public Boolean call(Tuple2<Double, Double> pl) {
			System.out.println("Predicted : "+pl._1());
			System.out.println("Actual : "+pl._2());
			return !pl._1().equals(pl._2());
		}		
	}		

	
	public String demo() {
		// TODO Auto-generated method stub
		SparkConf sparkConf = new SparkConf().setAppName("JavaDecisionTreeClassificationExample")
				.setMaster("local");
		JavaSparkContext jsc = new JavaSparkContext(sparkConf);


		String datapath = "Recommendations/ReviewAuthenticityTest/data/reviewValue";
		JavaRDD<LabeledPoint> data = MLUtils.loadLibSVMFile(jsc.sc(), datapath).toJavaRDD();

		String givenDatapath = "Recommendations/ReviewAuthenticityTest/data/givenData";
		JavaRDD<LabeledPoint> givenData = MLUtils.loadLibSVMFile(jsc.sc(), givenDatapath).toJavaRDD();

		System.out.println("*********** Data ******************");
		data.foreach(a -> System.out.println(a));
		System.out.println(data.count());
		JavaRDD<LabeledPoint>[] splits = data.randomSplit(new double[]{0.9, 0.1});
		splits[0].foreach(a->System.out.println(a));
		System.out.println(splits[1].count());
		JavaRDD<LabeledPoint> trainingData = splits[0];
		System.out.println("Training Data : "+trainingData.count());
		JavaRDD<LabeledPoint> testData = splits[1];
		Integer numClasses = 4;
		
		Map<Integer, Integer> categoricalFeaturesInfo = new HashMap<Integer, Integer>();
		// For Poker Dataset
//		categoricalFeaturesInfo.put(0,5);
//		categoricalFeaturesInfo.put(1,14);
//		categoricalFeaturesInfo.put(2,5);
//		categoricalFeaturesInfo.put(3,14);
//		categoricalFeaturesInfo.put(4,5);
//		categoricalFeaturesInfo.put(5,14);
//		categoricalFeaturesInfo.put(6,5);
//		categoricalFeaturesInfo.put(7,14);
//		categoricalFeaturesInfo.put(8,5);
//		categoricalFeaturesInfo.put(9,14);
		
		
		//For Course Dataset
		categoricalFeaturesInfo.put(0,4);
		categoricalFeaturesInfo.put(1,4);
		categoricalFeaturesInfo.put(2,4);
		categoricalFeaturesInfo.put(3,4);

		System.out.println(categoricalFeaturesInfo);
		String impurity = "entropy";
		String result = "";
		//		Integer maxDepth =5;	For smaller dataset
		//		Integer maxBins = 14;	For smaller dataset
		Integer maxDepth =10;	
		Integer maxBins = 64;

		final DecisionTreeModel model = DecisionTree.trainClassifier(trainingData, numClasses,
				categoricalFeaturesInfo, impurity, maxDepth, maxBins);

		JavaPairRDD<Double, Double> predictionAndLabel =
				testData.mapToPair(new PairFunction<LabeledPoint, Double, Double>() {
					/**
					 * predicts labels (classification class) for test data based on features of model 
					 */
					private static final long serialVersionUID = -357857469054135489L;

					@Override
					public Tuple2<Double, Double> call(LabeledPoint p) {
						return new Tuple2<Double, Double>(model.predict(p.features()), p.label());
					}
				});

		JavaPairRDD<Double, Double> predictGivenData =
				givenData.mapToPair(new PairFunction<LabeledPoint, Double, Double>() {
					/**
					 * predicts labels (classification class) for given data based on features of model
					 */
					private static final long serialVersionUID = -357857469054135489L;

					@Override
					public Tuple2<Double, Double> call(LabeledPoint p) {
						return new Tuple2<Double, Double>(model.predict(p.features()), p.label());
					}
				});

		Double testErr =
				1.0 * predictionAndLabel.filter(new testErrors()).count() / testData.count();
		
		Double accuracy = 100 - (testErr * 100);
		System.out.println("Test Error: " + testErr);
		System.out.println("Accuratcy : " + accuracy);
		System.out.println("Learned classification tree model:\n" + model.toDebugString());
		System.out.println("************** Predicition *************");
		predictGivenData.foreach(x -> System.out.println(x));
		predictGivenData.foreach(y -> System.out.println("Prediction for given dataset : "+y._1));
		predictGivenData.foreach(y -> System.out.println("Candidate belongs to domain : "+printDomain(y._1)));
		System.out.println("****************************************");
		
		result = printDomain(predictGivenData.first()._1());
		jsc.stop();
		return result;
		
	}

	private String printDomain(Double pl) {
		// TODO Auto-generated method stub
		switch((pl.intValue())) {
			case 0:
			{
				return "OK";
			}
			case 1:
			{
				return "Choosy User";
			}
			case 2:
			{
				return "Watch this one";
			}
			case 3:
			{
				return "Fake Review" ;
			}
			default:
			{
				return "Undefined";
			}

		}

	}
	public static void main(String[] args) {
		//Recommender recommender = new StringMatchBasedRecommenderImpl();
		//recommender.getUserRecommendations("data/Dataset.csv", "data/users.csv", 3);
		
		ReviewDecisionTree reviewtree = new ReviewDecisionTree();
		reviewtree.demo();
		
	}
	
}
