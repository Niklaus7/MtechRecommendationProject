<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
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
			input{
				
				background-color:orange;
				text-align:center;
				color:white;
				width:100px;
				height: 40px;
				font-weight:bolder;
				font-size:large;
				
			}
			input.txtbx{
				margin-left:49px;
				background-color:orange;
				text-align:center;
				color:white;
				width:200px;
				height: 20px;
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
			h1 {
				text-align: center
			}
			div.even{
				background-color:white;
				color:orange;
				margin:20px;
				padding:20px;	
			}
			form{
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
	<h2>User Based Collaborative Filtering</h2>	
	<%
	BufferedReader brr = new BufferedReader(new FileReader("Recommendations/ItemRecommendationPOC/data/u.item"));
		
	%>
	
	<hr />
		
	<form name="userform" method="post" action="SubmitItemRecommendation"><br />
	
	<h3>Fill in your level and interests </h3>
	<label style=padding-left:50px;padding-right:30px>User ID</label>
	<input class="txtbx" type="number" name="user" id="user"><br><br>
	<label style=padding-left:50px;padding-right:30px>Movie Rating 1</label>
	<select property="Movie1" name="movie" id="movie">
	<option value="0">Select Movie 1</option>
	<%
	String line;
	
	while((line = brr.readLine()) != null) {
		String[] values = line.split(",", -1);
		//System.out.println(values[0] + "  :  " + values[1]);
		out.println(values[1]);
		out.print(" <option>"+values[1]+ "</option> ");
		}
	%>
	</select>
	
	<select property="Rating1" name="rating" id="rating">
	<option value="0">Your Rating</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	</select><br /><br />
	
		 
    <input style=margin-left:500px id="Submit" type="submit" value="Submit" /><br />
    <label id="Output"></label>
    </form>
      <script>
      $(document).ready(function(){
    	  console.log("Ready");
    	  var givendata = "";
    	 $('#Submit').click(function(){
    		 
    				 var givendata = "1 1:"+$('#movie').val() + " : "+ $('#rating').val();		 
    		
    		 
    		// alert(givendata);
    //		 var result = request.getAttribute("responseText");
    //		 $("#Output").text(result);
    	 }) 
      });
      </script>
</body>

</html>