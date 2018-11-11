<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Review To Rating Mapper</title>
<style>
			div.heading {
				background-color:orange;
				color:white;
				margin:20px;
				padding:20px;
				font-size: 20;

			}
			h1 {
				text-align: center
			}
			div.even{
				background-color:white;
				color:orange;
				margin:20px;
				padding:20px;	
			}
			div.odd{
				background-color:orange;
				color:white;
				margin:20px;
				padding:20px;
			}
			form{
			padding:20px;
			}
			input{
				margin-top:20px;
				background-color:orange;
				text-align:center;
				color:white;
				width:100px;
				height: 40px;
				font-weight:bolder;
				font-size:large;
				margin-left:550px;
				
			}
			input.txtbx{
				margin-left:49px;
				background-color:orange;
				text-align:center;
				color:white;
				width:1100px;
				height: 50px;
				font-weight:bolder;
				font-size:large;
				
			}
			h2 {
				text-align: center;
				color:orange;
			}
		</style>

</head>
<body>
<div class="heading">
			<h1>Personalized Movie Recommendation System</h1>
		</div>
		<h2>Review To Rating Mapper</h2><hr />
<form name="userform" method="post" action="submitReviewText">
<h3>Write your review and convert it to corresponding rating</h3><br>
<label>Write Your Review Here</label>
<input class = "txtbx" type="text" id="reviewText" name="reviewText"><br>
<input type="submit" name="Submit" value="Submit" tabindex="2" />
</form>

</body>
</html>