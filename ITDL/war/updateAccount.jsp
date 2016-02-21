<%@page import="com.fci.itdl.controller.ITDLServletUpdateAccount"%>
<%@page import="com.fci.itdl.controller.ITDLServletUpdateOffer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Account</title>
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
</style>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="jquery-1.11.3.min.js"></script>
<script src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">
$(document).ready(function() {
	<%
	String storeEmail = (String) request.getParameter("StoreID");
	double lat = ITDLServletUpdateAccount.storeLoggedin.getLat();
	double lon = ITDLServletUpdateAccount.storeLoggedin.getLon();
	%>
	lat = "<%=lat%>";
	lon = "<%=lon%>";
	latlon = new google.maps.LatLng(lat, lon)
	mapholder = document.getElementById('mapholder')
	mapholder.style.height = '350px';
	mapholder.style.width = '700px';

	var myOptions = {
		center : latlon,
		zoom : 14,
		mapTypeId : google.maps.MapTypeId.ROADMAP,
		mapTypeControl : false,
		navigationControlOptions : {
			style : google.maps.NavigationControlStyle.SMALL
		}
	}

	var map = new google.maps.Map(document
			.getElementById("mapholder"), myOptions);
	
	var infowindow = new google.maps.InfoWindow({
	    content: '<b>Store Location</b>'
	});
	
	var marker = new google.maps.Marker({
		position : latlon,
		map : map,
		title : "Store Location"
	});
	
	infowindow.open(map, marker);
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
			<form action="ITDLServletUpdateAccount" id="storeform" method="post">
				<input type="text" id="name" name="name" value="<%=ITDLServletUpdateAccount.storeLoggedin.getName()%>"> <br>
				<input type="email" id="email" name="email" value="<%=ITDLServletUpdateAccount.storeLoggedin.getEmail()%>" style="margin-top: 10px;"> <br>
				<input type="password" id="password" name="password" value="<%=ITDLServletUpdateAccount.storeLoggedin.getPassword()%>" style="margin-top: 10px;"> <br>
				<p id="demo"></p>
				<div id="mapholder"></div>
				<input type="submit" class="doneEditting" value="Done">
				<input type="hidden" name="StoreID" value="<%=storeEmail%>">
			</form>
			
		</div>
	</div>
</div>
</body>
</html>