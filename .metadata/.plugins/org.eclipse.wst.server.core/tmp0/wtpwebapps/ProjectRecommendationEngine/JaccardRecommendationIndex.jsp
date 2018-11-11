<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Interests</title>
<style>
			div.heading {
				background-color:orange;
				color:white;
				margin:20px;
				padding:20px;
				font-size: 20;

			}
			form{
			padding:20px;
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
			input.chkbx{
				
				background-color:orange;
				margin-top:10px;
				text-align:center;
				color:white;
				width:100px;
				height: 40px;
				font-weight:bolder;
				font-size:large;
				
			}
			input.txtbx{
				
				background-color:orange;
				text-align:center;
				color:white;
				width:200px;
				height: 20px;
				margin-left:20px;
				font-weight:bolder;
				font-size:large;
				
			}
			select{
			background-color:orange;
			color:white;
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
		<h2>Jaccard Coefficient on Interest Strings</h2>	
	<hr />
	<form name="userform" method="post" action="submitInterestTags">
	<h4>Select the genre/s you like from the drop down list</h4>
	<label>Enter Your Name</label>
	<input type="text" class = "txtbx" id="firstname" name="firstname"><br>
     
  			<input type = "checkbox"  name = "interestTag" value="Action">Action<br>
			<input type = "checkbox" name = "interestTag" value="Adventure">Adventure<br>
			<input type = "checkbox" name = "interestTag" value="Animation">Animation<br>
			<input type = "checkbox" name = "interestTag" value="Comedy">Comedy<br>
			<input type = "checkbox" name = "interestTag" value="Crime">Crime<br>
			<input type = "checkbox" name = "interestTag" value="Documentary">Documentary<br>
			<input type = "checkbox" name = "interestTag" value="Drama">Drama<br>
			<input type = "checkbox" name = "interestTag" value="Fantasy">Fantasy<br>
			<input type = "checkbox" name = "interestTag" value="Horror">Horror<br>
			<input type = "checkbox" name = "interestTag" value="Musical">Musical<br>
			<input type = "checkbox" name = "interestTag" value="Mystery">Mystery<br>
			<input type = "checkbox" name = "interestTag" value="Romance">Romance<br>
			<input type = "checkbox" name = "interestTag" value="SciFi">SciFi<br>
			<input type = "checkbox" name = "interestTag" value="Thriller">Thriller<br>
			<input type = "checkbox" name = "interestTag" value="War">War<br>
      <input type="submit" class = "chkbx" name="Submit" value="Submit" tabindex="2" />
</form>
</body>
</html>