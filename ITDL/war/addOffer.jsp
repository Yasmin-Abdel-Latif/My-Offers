<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Offer</title>
<style>
@import url(http://fonts.googleapis.com/css?family=Exo:100,200,400);
@import url(http://fonts.googleapis.com/css?family=Source+Sans+Pro:700,400,300);

body{
	margin: 0;
	padding: 0;
	background: gray;
	
	color: gray;
	font-family: Arial;
	font-size: 12px;
}

.body{
	position: absolute;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	background-image: url(128-193.jpg);
	background-repeat: repeat;
    filter: alpha(opacity=30);
	z-index: 0;
}

.grad{
	position: absolute;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.65))); /* Chrome,Safari4+ */
	z-index: 1;
	opacity: 0.7;
}

.home{
	position: absolute;
	top: calc(15% - 75px);
	left: calc(0% - 0px);
	height: 100%;
	padding: 10px;
	z-index: 2;
}

.home input:not([type=submit]){
	width: 250px;
	height: 30px;
	background: white;
	border: 1px solid rgba(255,255,255,0.6);
	border-radius: 2px;
	color: blue;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
}

.home input[type=submit]{
	width: 260px;
	height: 35px;
	background: #fff;
	border: 1px solid #fff;
	cursor: pointer;
	border-radius: 2px;
	color: #a18d6c;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 6px;
	margin-top: 10px;
}

.home select{
	width: 300px;
    height: 35px;
    background: #fff;
    border: 1px solid #fff;
    cursor: pointer;
    border-radius: 2px;
    color: #a18d6c;
    font-family: 'Exo', sans-serif;
    font-size: 16px;
    font-weight: 400;
    padding: 6px;
    margin-top: 20px;
}

.home textarea{
    background: #fff;
    border: 1px solid #fff;
    cursor: pointer;
    border-radius: 2px;
    color: #a18d6c;
    font-family: 'Exo', sans-serif;
    font-size: 16px;
    font-weight: 400;
    padding: 6px;
    margin-top: 20px;
}
</style>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script>
$(document).ready(function() {
	<%
	String storeEmail = (String) request.getParameter("StoreID");
	%>
	function parseEvaluateDate(str) {
	    var mdy = str.split('/');
	    return new Date(mdy[2], mdy[1]-1, mdy[0]);
	}

	function daydiff(first, second) {
	    return Math.round((second-first)/(1000*60*60*24));
	}
	
	$("#datepickerStart").datepicker({ dateFormat: 'dd/mm/yy' });
	$("#datepickerEnd").datepicker({ dateFormat: 'dd/mm/yy' });
	$("#offerform").submit(function(e){
		var startDate = $("#datepickerStart").val();
		var endDate = $("#datepickerEnd").val();
		var currentTime = new Date();
	    var month = currentTime.getMonth() + 1;
	    var day = currentTime.getDate();
	    var year = currentTime.getFullYear();
	    var currentDate = day + "/" + month + "/" + year;
	    if(daydiff(parseEvaluateDate(currentDate), parseEvaluateDate(startDate)) < 0)
		{
			alert("The Offer Start Date MUST Be The Current Date Or Later But Not Earlier!");
			e.preventDefault();
		}
	    else
    	{
	    	if(daydiff(parseEvaluateDate(startDate), parseEvaluateDate(endDate)) < 0)
			{
				alert("The Offer Start Date MUST Be Before The End Date Of The Offer!");
				e.preventDefault();
			}
	    	else
    		{
	    		alert("Your Offer Was Added");
    		}
    	}
	});
});
</script>
</head>
<body>
<div class="body"></div>
<div class="grad"></div>

<div class="home" style="width: 100%; overflow: auto;">
	<div ALIGN="center">
		<p style="font-family: 'Exo', sans-serif; font-size: 40px; font-weight: 200;">
			<b>My<span style="color: #CC0000 !important;"><font color="#cccccc" face="Lucida Calligraphy">Offers</font></span></b>
		</p>
	</div>
	<br>
	<div style="position: absolute; left: 10%; width: 20%;">
		<div ALIGN="center">
			<input type="submit" class="addoffer" value="Add Offer">
			<input type="submit" class="updateaccount" value="Update Account">
		</div>
	</div>
	<div style="position: absolute; left: 30%; right: 10%; top: 20%;">
		<div ALIGN="center">
			<form action="ITDLServletAddOffer" id="offerform" method="post">
				<font size="4" color="#ffffff" face="Lucida Calligraphy">
					<b>
						Start Date : 
					</b>
				</font>
				<input name="datepickerStart" id="datepickerStart" style="margin-right: 20px;"/>
				<font size="4" color="#ffffff" face="Lucida Calligraphy">
					<b>
						End Date   : 
					</b>
				</font>
				<input name="datepickerEnd" id="datepickerEnd" style="margin-right: 20px;"/>
				<br>
				<select name='category' required>
	                 <option selected="selected"></option>
	                 <option value="Arts and Entertainments">Arts and Entertainments</option>
	                 <option value="Movies">Movies</option>
	                 <option value="Music">Music</option>
	                 <option value="Food and drinks">Food and drinks</option>
	                 <option value="Technology">Technology</option>
	                 <option value="Sports">Sports</option>
	                 <option value="Health">Health</option>
	                 <option value="Religion">Religion</option>
	                 <option value="Education">Education</option>
	                 <option value="Pets and animals">Pets and animals</option>
	                 <option value="Fashion">Fashion</option>
	                 <option value="Reading">Reading</option>
	             </select>
	             <br>
	             <textarea name="offerContent" rows="7" cols="50" id="offerAddedContent" class="offerContent" placeholder="Enter Offer Content..."></textarea>
	             <br>
	             <input type="submit" class="doneAdding" value="Done">
	             <input type="hidden" name="StoreID" value="<%=storeEmail%>">
			</form>
			
		</div>
	</div>
</div>
</body>
</html>