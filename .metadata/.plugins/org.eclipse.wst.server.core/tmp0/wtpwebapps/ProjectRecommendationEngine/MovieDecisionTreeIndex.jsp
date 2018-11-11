<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="java.io.*"%>
        <%@ page import="java.util.*"%>
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
			h1 {
				text-align: center;
			}
			h2 {
				text-align: center;
				color:orange;
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
		<h2>Recommendation Decision Tree</h2>
	<%
	BufferedReader brr = new BufferedReader(new FileReader("Recommendations/MovieDecisionTree/data/Movienames"));
	String line;
	List<String> listMovies = new ArrayList<String>();
	
	while((line = brr.readLine()) != null) {
		String[] values = line.split(",", -1);
		//System.out.println(values[0] + "  :  " + values[1]);
		listMovies.add(values[0]);
	}
	%>
	<hr />
		
	<form name="userform" method="post" action="submitMovieDecisionTree"><br />
	<h3>Fill in your age and interests</h3>
	<label style=padding-left:50px;padding-right:30px>User Age</label>
	<select property="Age" name="age" id="age">
	<option value="0">Your Age</option>
	<option value="1">Below 14</option>
	<option value="2">Above 14</option>
	</select><br /><br />
	<label style=padding-left:50px;padding-right:30px>Movie 1</label>
	<select property="Movie1" name="movie" id="movie">
	<option value="0">Select Movie 1</option>
	<%
		for(int i=0;i<listMovies.size();i++)
		{
			out.println(" <option>"+listMovies.get(i)+ "</option> ");
		}
	%>
	</select><br /><br />
	
	<label style=padding-left:50px;padding-right:30px>Movie 2</label>
	<select property="Movie2" name="movie2" id="movie2">
	<option value="0">Select Movie 2</option>
	<%
		for(int i=0;i<listMovies.size();i++)
		{
			out.println(" <option>"+listMovies.get(i)+ "</option> ");
		}
	%>
	</select><br /><br />
	
	<label style=padding-left:50px;padding-right:30px>Movie 3</label>
	<select property="Movie3" name="movie3" id="movie3">
	<option value="0">Select Movie 3</option>
	<%
		for(int i=0;i<listMovies.size();i++)
		{
			out.println(" <option>"+listMovies.get(i)+ "</option> ");
		}
	%>
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