<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="/jquery-2.1.4.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Details</title>
<style>
			div.heading {
				background-color:orange;
				color:white;
				margin:20px;
				padding:20px;
				font-size: 20;

			}
			h2 {
				text-align: center;
				color:orange;
			}
			form{
			padding:20px;
			}
			input{
				
				background-color:orange;
				text-align:center;
				color:white;
				width:100px;
				height: 40px;
				font-weight:bolder;
				font-size:large;
				
			}
			select{
			background-color:orange;
			color:white;
			font-size:large;
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
		</style>


</head>
<body>
<div class="heading">
			<h1>Personalized Movie Recommendation System</h1>
		</div>
		<h2>Rating Validity Authenticator</h2>
	
	<hr />
	
	<form name="userform" method="post" action="submitReviewAuthTest">
	<h3>Fill in your level and interests</h3>
	<label style=padding-left:1px>Movie</label>
	<label style=padding-left:180px>Rating</label><br>
	<select style=margin-top:30px property="Tag1" name="tag1">
	<option value="0">Select Tag1</option>
	<option value="1">Toy Story</option>
	<option value="2">GoldenEye</option>
	<option value="3">Four Rooms</option>
	<option value="4">Get Shorty</option>
	<option value="5">Copycat</option>
	<option value="6">Shanghai Triad</option>
	<option value="7">Twelve Monkeys</option>
	<option value="8">Babe</option>
	<option value="9">Dead Man Walking</option>
	<option value="10">Richard III</option>
	<option value="11">Seven (Se7en)</option>
	<option value="12">The Usual Suspects </option>
	<option value="13">Mighty Aphrodite</option>
	<option value="14">Postino Il</option>
	<option value="15">Mr Hollands Opus</option>
	<option value="16">French Twist</option>
	<option value="17">From Dusk Till Dawn</option>
	<option value="18">The White Balloon</option>
	<option value="19">Antonias Line</option>
	<option value="20">Angels and Insects</option>
	</select>
	
	<select style=margin-left:30px property="rating1" name="rating1">
	<option value="0">Select Rating</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	</select><br />
	
	<select style=margin-top:40px property="Tag2" name="tag2">
	<option value="0">Select Tag1</option>
	<option value="1">Toy Story</option>
	<option value="2">GoldenEye</option>
	<option value="3">Four Rooms</option>
	<option value="4">Get Shorty</option>
	<option value="5">Copycat</option>
	<option value="6">Shanghai Triad</option>
	<option value="7">Twelve Monkeys</option>
	<option value="8">Babe</option>
	<option value="9">Dead Man Walking</option>
	<option value="10">Richard III</option>
	<option value="11">Seven (Se7en)</option>
	<option value="12">The Usual Suspects </option>
	<option value="13">Mighty Aphrodite</option>
	<option value="14">Postino Il</option>
	<option value="15">Mr Hollands Opus</option>
	<option value="16">French Twist</option>
	<option value="17">From Dusk Till Dawn</option>
	<option value="18">The White Balloon</option>
	<option value="19">Antonias Line</option>
	<option value="20">Angels and Insects</option>
	</select>
	
	<select style=margin-left:30px property="rating2" name="rating2">
	<option value="0">Select Rating</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	</select><br />
	
	<select style=margin-top:40px property="Tag3" name="tag3">
	<option value="0">Select Tag1</option>
	<option value="1">Toy Story</option>
	<option value="2">GoldenEye</option>
	<option value="3">Four Rooms</option>
	<option value="4">Get Shorty</option>
	<option value="5">Copycat</option>
	<option value="6">Shanghai Triad</option>
	<option value="7">Twelve Monkeys</option>
	<option value="8">Babe</option>
	<option value="9">Dead Man Walking</option>
	<option value="10">Richard III</option>
	<option value="11">Seven (Se7en)</option>
	<option value="12">The Usual Suspects </option>
	<option value="13">Mighty Aphrodite</option>
	<option value="14">Postino Il</option>
	<option value="15">Mr Hollands Opus</option>
	<option value="16">French Twist</option>
	<option value="17">From Dusk Till Dawn</option>
	<option value="18">The White Balloon</option>
	<option value="19">Antonias Line</option>
	<option value="20">Angels and Insects</option>
	</select>
	
	<select style=margin-left:30px property="rating3" name="rating3">
	<option value="0">Select Rating</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	</select><br />
	
	<select style=margin-top:40px property="Tag4" name="tag4">
	<option value="0">Select Tag1</option>
	<option value="1">Toy Story</option>
	<option value="2">GoldenEye</option>
	<option value="3">Four Rooms</option>
	<option value="4">Get Shorty</option>
	<option value="5">Copycat</option>
	<option value="6">Shanghai Triad</option>
	<option value="7">Twelve Monkeys</option>
	<option value="8">Babe</option>
	<option value="9">Dead Man Walking</option>
	<option value="10">Richard III</option>
	<option value="11">Seven (Se7en)</option>
	<option value="12">The Usual Suspects </option>
	<option value="13">Mighty Aphrodite</option>
	<option value="14">Postino Il</option>
	<option value="15">Mr Hollands Opus</option>
	<option value="16">French Twist</option>
	<option value="17">From Dusk Till Dawn</option>
	<option value="18">The White Balloon</option>
	<option value="19">Antonias Line</option>
	<option value="20">Angels and Insects</option>
	</select>
	
	<select style=margin-left:30px property="rating4" name="rating4">
	<option value="0">Select Rating</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	</select><br />
      
    <input id="Submit" style=margin-top:50px type="submit" value="Submit" /><br />
    <label id="Output"></label>
    </form>
    <p>
    
    </p>
      <script>
      $(document).ready(function(){
    	  console.log("Ready");
    	  var givendata = "";
    	 $('#Submit').click(function(){
    		 
    		 var givendata = "1 1:"+$('#level').val() + " " +"2:"+ $('#tag1').val() + " " +"3:"+ $('#tag2').val() + " " +"4:"+ $('#tag3').val();
    		 console.log(givendata);
    		 var result = request.getAttribute("responseText");
    		 $("#Output").text(result);
    	 }) 
      });
      </script>
</body>

</html>