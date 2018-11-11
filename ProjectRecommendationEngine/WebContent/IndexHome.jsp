<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<style>
			div.heading {
				background-color:orange;
				color:white;
				margin:20px;
				padding:20px;
				font-size: 20;

			}
			input{
				margin-top:-125px;
				margin-left:1070px;
				background-color:orange;
				color:white;
				width:100px;
				height: 40px;
				font-weight:bolder;
				font-size:large;
				
			}
			h1 {
				text-align: center
			}
			div.even{
				background-color:orange;
				color:white;
				margin:20px;
				padding:20px;	
				width:70%;
			}
			div.odd{
				background-color:orange;
				color:white;
				margin:20px;
				padding:20px;
				width:70%;
			}
		</style>
	</head>

	<body>
	
		<div class="heading">
			<h1>Personalized Movie Recommendation System</h1>
		</div>
	<form name="trendingForm" method="post" action="welcomeMain">
		<div class="even">
			<h2>What's New</h2>

			<p>See what's trending into the world of movies right now</p>

			<p>Get recommendations based upon the most trending things in ur favourite movie destination</p>
		</div>
		<input id="SubmitTrending" type="submit" value="Submit" /><br />

    </form>
    
    <form name="CollaborativeForm" method="post" action="ItemRecommenderIndex.jsp">
		 
		<div class="odd">
			<h2>What my friends are watching</h2>

			<p>See what ur friends watching right now</p>

			<p>Get recommendations based upon the most trending things in ur favourite movie destination</p>
		</div> 
		<input id="SubmitCollaborative" type="submit" value="Submit" /><br />

    </form>
		
		
		
		
<form name="DecisionTreeForm" method="post" action="MovieDecisionTreeIndex.jsp">
<div class="even">
			<h2>Show me according to my interest</h2>

			<p>your very personal choice of movies</p>

			<p>Get recommendations based upon your movie history</p>
		</div>
		<input id="SubmitDecisionTree"  type="submit" value="Submit" /><br />

    </form>
    
    
    <form name="StringMatchBasedForm" method="post" action="JaccardRecommendationIndex.jsp">
<div class="odd">
			<h2>I have versatile interests</h2>

			<p>Show me something based upon my favorite genres</p>

			<p>Get recommendations based upon our Jaccard index</p>
		</div>
		<input id="SubmitJaccardString"  type="submit" value="Submit" /><br />

    </form>
		
		
		
	<form name="RatingForm" method="post" action="RatingAuthTest.jsp">
		 
		<div class="even">
			<h2>Submit My Ratings</h2>

			<p>Provide your ratings and reviews to the movies you watched</p>

			<p>We appreciate your effort to provide ratings and reviews and for making our system better</p>
		</div>
		<input id="SubmitRating"  type="submit" value="Submit" /><br />

    </form>
    
    
    <form name="ReviewForm" method="post" action="ReviewToRatingIndex.jsp">
		 
		<div class="odd">
			<h2>Share My Reviews</h2>

			<p>Provide your reviews to the movies you watched</p>

			<p>We are happy to get short and sweet textual reviews.</p>
		</div>
		<input id="SubmitReview"  type="submit" value="Submit" /><br />

    </form>
		 <script type="text/javascript">
		 
		 </script>
		    
	</body>

</html>