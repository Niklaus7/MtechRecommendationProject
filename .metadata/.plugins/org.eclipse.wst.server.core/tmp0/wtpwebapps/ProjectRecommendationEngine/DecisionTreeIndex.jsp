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
		</style>


</head>
<body>
<div class="heading">
			<h1>Personalized Movie Recommendation System</h1>
		</div>
		<h1>Recommendation Decision Tree</h1>
	<%= "Fill in your level and interests" %>
	<hr />
	<label style=padding-left:1px>Level</label>
	<label style=padding-left:50px>Interest Tag 1</label>
	<label style=padding-left:50px>Interest Tag 2</label>
	<label style=padding-left:50px>Interest Tag 3</label>
	
	<form name="userform" method="post" action="submitLevel">
	
	<select property="level" name="level">
	<option value="0">Select Level</option>
	<option value="1">Beginner</option>
	<option value="2">Advanced</option>
	</select>
	
	<select property="Tag1" name="tag1">
	<option value="0">Select Tag1</option>
	<option value="1">HTML</option>
	<option value="2">Javascript</option>
	<option value="3">JQuery</option>
	<option value="4">CSS</option>
	<option value="5">Responsive</option>
	<option value="6">Hadoop</option>
	<option value="7">Spark</option>
	<option value="8">R</option>
	<option value="9">Machine Learning</option>
	<option value="10">Android</option>
	<option value="11">Mobile</option>
	<option value="12">Google Services</option>
	<option value="13">Physics</option>
	<option value="14">Algebra</option>
	<option value="15">Psychology</option>
	<option value="16">Chemistry</option>
	</select>
	
	<select property="Tag2" name="tag2">
	<option value="0">Select Tag2</option>
	<option value="1">HTML</option>
	<option value="2">Javascript</option>
	<option value="3">JQuery</option>
	<option value="4">CSS</option>
	<option value="5">Responsive</option>
	<option value="6">Hadoop</option>
	<option value="7">Spark</option>
	<option value="8">R</option>
	<option value="9">Machine Learning</option>
	<option value="10">Android</option>
	<option value="11">Mobile</option>
	<option value="12">Google Services</option>
	<option value="13">Physics</option>
	<option value="14">Algebra</option>
	<option value="15">Psychology</option>
	<option value="16">Chemistry</option>
	</select>
	
	<select property="Tag3" name="tag3">
	<option value="0">Select Tag3</option>
	<option value="1">HTML</option>
	<option value="2">Javascript</option>
	<option value="3">JQuery</option>
	<option value="4">CSS</option>
	<option value="5">Responsive</option>
	<option value="6">Hadoop</option>
	<option value="7">Spark</option>
	<option value="8">R</option>
	<option value="9">Machine Learning</option>
	<option value="10">Android</option>
	<option value="11">Mobile</option>
	<option value="12">Google Services</option>
	<option value="13">Physics</option>
	<option value="14">Algebra</option>
	<option value="15">Psychology</option>
	<option value="16">Chemistry</option>
	</select>
      
    <input id="Submit" type="submit" value="Submit" /><br />
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