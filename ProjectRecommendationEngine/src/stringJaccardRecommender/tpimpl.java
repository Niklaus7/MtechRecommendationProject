package stringJaccardRecommender;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFlatMapFunction;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

//import SparkContextProvider;

import scala.Tuple2;

public class tpimpl implements Recommender {
	/**
	 * 
	 */
	//String namee ="";
	String[] MoviesNames = new String[]{};
	private static final long serialVersionUID = 2508614529651871610L;
	JavaSparkContext sc;

	public tpimpl() {
		sc = SparkContextProvider.getInstance().getSparkContext();
		//	setName(a);
	}
	//	public void setName(String s){
	//		this.namee = s;
	//	}

	private DataFrame readCSV(String csvPath) {
		SQLContext sqlContext = new SQLContext(sc);
		DataFrame df = sqlContext.read().format("com.databricks.spark.csv").option("inferSchema", "true")
				.option("header", "true").load(csvPath);
		df.printSchema();
		df.show();
		return df;
	}

	/**
	 * @author Devdatta
	 */
	@Override
	public List<User> getUserRecommendations(String coursesCSVFilePath, String usersCSVFilePath,
			int numRecommendation, String namee) {
		// Read courses csv - "CourseName,Tags,Domain,Duration,About"
		DataFrame dfCourses = readCSV(coursesCSVFilePath);
		// Read users csv
		DataFrame dfUsers = readCSV(usersCSVFilePath);

		//	DataFrame dfCoursesTagsCombined = dfCourses.selectExpr("CourseName", "concat(Tags,Domain) as Tags", "About");

		JavaRDD<User> rddUsers = dfUsers.javaRDD().map(new ConvertUserDFtoRDD());

		DataFrame dfUserCourses = dfUsers.join(dfCourses);

		//System.out.println("Cartetian product");
		dfUserCourses.show();
		//	System.out.println("***********Cartesian COunt*********************");
		//	System.out.println(dfUserCourses.count());
		//	System.out.println("********************************");

		JavaRDD<Row> rddRecommendations = dfUserCourses.javaRDD().filter(new FilterMatchingInterest());
		//		System.out.println("********************************");
		//		System.out.println(rddRecommendations.count());
		//		System.out.println("********************************");
		//		System.out.println("Recommendationssss");
		//		


		JavaPairRDD<String, String[]> prddUsernameToCourse = rddRecommendations.mapToPair(new MapUsernameToCourse());

		System.out.println("Tuples:");
		prddUsernameToCourse.foreach(tuple -> System.out.println(tuple._1 + StringUtils.join(tuple._2, ",")));

		System.out.println("Recommendations: ");
		JavaPairRDD<String, String[]> prddUsernameRecommendations = prddUsernameToCourse
				.reduceByKey(new MergeCourses());
		prddUsernameRecommendations.foreach(tuple -> {
			String abc = (String)tuple._1();
			String deff = namee;
		//	System.out.println("abc = "+abc);
		//	System.out.println("def = "+deff);
			if(abc.compareTo(deff)==0)
			{
				
				System.out.println("\n==============================\nUser:"
						+ tuple._1 + "\nRecommended for you :) = \n" + StringUtils.join(tuple._2, "\n")
						+ "");
			}
		});


		return null;
	}
	public String[] giveMeList(){
		System.out.println("*******************");
		System.out.println(MoviesNames[1]);
		System.out.println("*******************");
		return MoviesNames;
		
	}

	private static class MergeCourses implements Function2<String[], String[], String[]> {

		private static final long serialVersionUID = -8477264740361519438L;

		@Override
		public String[] call(String[] courses1, String[] courses2) throws Exception {
			Stream<String> sCoures1 = Arrays.stream(courses1);
			Stream<String> sCourses2 = Arrays.stream(courses2);

			String[] concatedCourses = Stream.concat(sCoures1, sCourses2).toArray(size -> new String[size]);
			return concatedCourses;
		}
	}

	private static class MapUsernameToCourse implements PairFunction<Row, String, String[]> {

		private static final long serialVersionUID = -1247819030015163401L;

		@Override
		public Tuple2<String, String[]> call(Row row) throws Exception {
			// |UserName| Interests| CourseName| Tags| About|
			int userNameIndex = 0;
			// int interestsIndex = 1;
			int courseNameIndex = 2;
			// int tagsIndex = 3;
			//int aboutIndex = 4;
			String userName = row.isNullAt(userNameIndex) ? "" : row.getString(userNameIndex);
			String courseName = row.isNullAt(courseNameIndex) ? "" : row.getString(courseNameIndex);
			//	String about = row.isNullAt(aboutIndex) ? "" : row.getString(aboutIndex);

			String course = courseName + "" ;
			String[] courses = { course };
			Tuple2<String, String[]> tuple = new Tuple2<String, String[]>(userName, courses);

			return tuple;
		}

	}

	/**
	 * 
	 * @author Devdatta
	 *
	 */
	private static class ConvertUserDFtoRDD implements Function<Row, User> {

		public static final long serialVersionUID = 1L;

		@Override
		public User call(Row row) throws Exception {
			User user = new User();
			user.setName(row.isNullAt(0) ? "" : row.getString(0));
			user.setInterests(row.isNullAt(1) ? new String[0] : row.getString(1).split(","));
			return user;
		}

	}

	/**
	 * 
	 * @author Devdatta
	 *
	 */
	private static class FilterMatchingInterest implements Function<Row, Boolean> {

		private static final long serialVersionUID = -6326122756347290028L;

		@Override

		public Boolean call(Row row) throws Exception {
			// |UserName| Interests| CourseName| Tags| About|
			// int userNameIndex = 0;
			int interestsIndex = 1;
			int courseNameIndex = 2;
			int tagsIndex = 3;
			// int aboutIndex = 4;
			int interestt =0;
			int unn = 0;
			String username = row.isNullAt(0) ? "" : row.getString(0);
			String moviename = row.isNullAt(2) ? "" : row.getString(2);
			String interestStr = row.isNullAt(interestsIndex) ? "" : row.getString(interestsIndex);
			String tags = row.isNullAt(tagsIndex) ? "" : row.getString(tagsIndex);
			int taglen = tags.split(",").length;
			boolean match = false;
				
			
			/* ************************************************** */
			/* For showing the individual Jaccard for every user for every movie */
			/* Comment out the following codes in order to show the Jaccards individually */
			/* ************************************************** */
			
			
			//System.out.println("******************  "+username+"  *******************  "+moviename+"   *******************");
			for (String interest : interestStr.split(",")) {
				unn++;
				//		System.out.println("*******************  "+moviename+"   *******************  " + interest );
				//		System.out.println(interest.trim().length());
				if (interest.trim().length() > 0) {

					if (tags.contains(interest)) {
						interestt++;
						match = true;
						//	System.out.println(interest);

						//	System.out.println("---"+tags.split(",").length);
					}else{

					}
				}
				//	System.out.println(interestt);

			}
			unn = (unn+taglen)-interestt;
			//	System.out.println(courseNameIndex + " Intersection :- " + interestt);
			//System.out.println(courseNameIndex + " Union :- " + unn);
			Double jaccard = (double) (interestt) / (double) (unn);

			/* ******************************************************** */
			/*  Finds Out Jaccard Coefficient for each item per user  */
			/* ******************************************************** */
				System.out.println("Jaccard Coefficient : "+jaccard);

		//	int counterVariable = 0;

			if(jaccard > 0.50)
			{
				//counterVariable++;
				return match;
			}else
			{
				return false;
			}

		}
	}

	private static class ConvertRowToUser implements Function<Row, User> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 970892101305256834L;

		@Override
		public User call(Row row) throws Exception {
			// |UserName| Interests| CourseName| Tags| About|
			int userNameIndex = 0;
			int interestsIndex = 1;
			int courseNameIndex = 2;
			int tagsIndex = 3;
			//	int aboutIndex = 4;
			String userName = row.isNullAt(userNameIndex) ? "" : row.getString(userNameIndex);
			String interest = row.isNullAt(interestsIndex) ? "" : row.getString(interestsIndex);
			String courseName = row.isNullAt(courseNameIndex) ? "" : row.getString(courseNameIndex);
			String tags = row.isNullAt(tagsIndex) ? "" : row.getString(tagsIndex);
			//	String about = row.isNullAt(aboutIndex) ? "" : row.getString(aboutIndex);

			User user = new User();
			user.setName(userName);
			user.setInterests(interest.split(","));
			String[] recommendation = { courseName + " : Recommended"};
			user.setRecommendation(recommendation);
			return null;
		}

	}

}