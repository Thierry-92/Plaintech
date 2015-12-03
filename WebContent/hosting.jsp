<!DOCTYPE HTML>
<html>
<head>
<title>Plaintech | Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
<link href='http://fonts.googleapis.com/css?family=Electrolize' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>	
</head>
<body>
<div class="header">
       <div class="header_top">
       	 <div class="wrap">
			<div class="logo">
			     <a href="index.jsp"><font size="10">Plaintech</font></a>
			</div>
			<% if(session == null || session.getAttribute("username") == null) { %>
				<div class="login_button">
					<div class="call">
						<p>Call us now: 033-7500800</p>
					</div>
					    <ul>
					    	<li><form action="login" method="post">
					    	<input id="emaillogin" name="emaillogin" type="text" value="Username" class="field">
                   			<input id="passlogin" name="passlogin" type="password" value="Password" class="field">
					   		 <div class="buttonss"><button class="grey">Login</button></div>
					   		 </form></li>
					    </ul>
				  </div>
  			<div class="clear"></div>
  		</div>
	
				 <% } else { %> <div class="login_button">
					<div class="call1">
						<p>Call us now: 033-7500800</p>
					</div>
					    <ul> 
					    	<li><form action="manageVM" method="post">
					    	<div class="buttonss"><button type="submit" class="grey" value="manageVM">Personal page </button></div>
							</form></li>
					   		 <li><form action="logout" method="post">
								<div class="buttonss"><button type="submit" class="grey" value="Logout">Log out </button></div>
							</form></li>
					    </ul>
				  </div>
  			<div class="clear"></div>
  			
				 <% } %>
				 </div>
	</div>
   <div class="menu">
   	  <div class="wrap">
			<ul>
				<li><a href="index.jsp">Home</a></li>
				<li><a href="cloud.html">Cloud Hosting</a></li>
				<li><a href="services.html">Cloud Services</a></li>
				<li><a href="about.html">About Plaintech</a></li>
				<li><a href="support.html">Support</a></li>
			</ul>
        </div>
   </div>
   </div>

      <div class="main">
		<div class="content_top">
			<div class="wrap">
		
		</div>
   </div>
   </div>
   

   <div class="main">
		<div class="content_top">
			<div class="wrap">
		
		</div>
   </div>
   </div>
 <div class="footer">
   	  <div class="wrap">
   	    <div class="footer_grides">
				<div class="footer_grid2" style="padding:0px">
					<h3>About Us</h3>
					<p>Plaintech UK is an internationally operating organization with its main headquarters in Birmingham (UK). One division of Plaintech is based in the Netherlands to address the Dutch market and Scandinavia. Plaintech has decades of experience in the hosting business.</p>
				</div>
				<div class="footer_grid1">	
						<h3>Get In Touch</h3>
							<div class="address">
							<ul>
						  	 <li><span>E-mail :</span> team5@gmail.com</li>
						  	 <li><span>Telephone :</span>033-7500800</li>
						  </ul>
					  	</div>
			          </div>
				<div class="footer_grid3">
					<h3>Page Layouts</h3>
						<div class="f_menu">
							   <ul>
						       		<li><a href="index.jsp">Home</a></li>
									<li><a href="cloud.html">Cloud Hosting</a></li>
									<li><a href="services.html">Cloud Services</a></li>
									<li><a href="about.html">About Plaintech</a></li>
									<li><a href="support.html">Support</a></li>
						   	   </ul>
						</div>
				</div>
		<div class="footer_grid4">
			<h3>Follow</h3>
				<div class="img_list">
				    <ul>
					     <li><img src="images/facebook.png" alt="" /><a href="#">Join Us on Facebook</a></li>
					     <li><img src="images/twitter.png" alt="" /><a href="#">Follow Us on Twitter</a></li>
				    </ul>
				</div>
		 </div>
	 <div class="clear"></div>
  </div>

	 </div>
  </div>

</body>
</html>

