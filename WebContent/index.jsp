<!DOCTYPE HTML>
<html>
<head>
<title>Plaintech | Home</title>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Electrolize'
	rel='stylesheet' type='text/css'>
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
				<%
					if (session == null || session.getAttribute("username") == null) {
				%>
				<div class="login_button">
					<div class="call">
						<p>Call us now: 033-7500800</p>
					</div>
					<ul>
						<li><form action="login" method="post">
								<input id="emaillogin" name="emaillogin" type="text"
									value="Username" class="field"> <input id="passlogin"
									name="passlogin" type="password" value="Password" class="field">
								<div class="buttonss">
									<button class="grey">Login</button>
								</div>
							</form></li>
					</ul>
				</div>

				<div class="clear"></div>
			</div>

			<%
				} else {
			%>
			<div class="login_button">
				<div class="call1">
					<p>Call us now: 033-7500800</p>
				</div>
				<ul>
					<li><form action="personalpage.jsp" method="post">
							<div class="buttonss">
								<button type="submit" class="grey" value="personalpage.jsp">Personal
									page</button>
							</div>
						</form></li>
					<li><form action="logout" method="post">
							<div class="buttonss">
								<button type="submit" class="grey" value="Logout">Log
									out</button>
							</div>
						</form></li>
				</ul>
			</div>
		</div>
		<div class="clear"></div>

		<%
			}
		%>
	</div>


	<div class="menu">
		<div class="wrap">
			<ul>
				<li><a href="index.jsp">Home</a></li>
				<li><a href="hosting.jsp">Cloud Hosting</a></li>
				<li><a href="services.jsp">Cloud Services</a></li>
				<li><a href="about.jsp">About Plaintech</a></li>
				<li><a href="support.jsp">Support</a></li>
			</ul>
		</div>
	</div>

	<div class="main">
		<div class="content_top">
			<div class="wrap">
				<div class="ptables">
					<ul class="green pricing jcarousel-list jcarousel-list-horizontal">
						<li>
							<ul>
								<li class="title"><h3>Lite</h3>
									<h4>
										€100<small>/month</small>
									</h4></li>
								<li class="divider"></li>
								<li>2 Core CPU</li>
								<li>4GB RAM</li>
								<li>50GB Disk Space</li>
								<li>No Backup</li>
								<li>8 AM to 5 PM Live Support</li>
								<li><form method="post" action="storeVM">
										<input type="hidden" name="vmstore" id="vmstore" value="1" />
										<div class="buttons">
											<button type="submit" class="grey">Buy it now!</button>
										</div>
									</form></li>
							</ul>
						</li>
						<li>
							<ul>
								<li class="title"><h3>Pro</h3>
									<h4>
										€150<small>/month</small>
									</h4></li>
								<li class="divider"></li>
								<li>4 Core CPU</li>
								<li>8GB RAM</li>
								<li>100GB Disk Space</li>
								<li>Normal Backup</li>
								<li>6 AM to 10 PM Live Support</li>
								<li><form method="post" action="storeVM">
										<input type="hidden" name="vmstore" id="vmstore" value="2" />
										<div class="buttons">
											<button type="submit" class="grey">Buy it now!</button>
										</div>
									</form></li>
							</ul>
						</li>
						<li>
							<ul>
								<li class="title"><h3>Plus</h3>
									<h4>
										€208<small>/month</small>
									</h4></li>
								<li class="divider"></li>
								<li>8 Core CPU</li>
								<li>16GB RAM</li>
								<li>150GB Disk Space</li>
								<li>Normal Backup &Aacute; Extra Backup</li>
								<li>24/7 Live Support</li>
								<li><form method="post" action="storeVM">
										<input type="hidden" name="vmstore" id="vmstore" value="3" />
										<div class="buttons">
											<button type="submit" class="grey">Buy it now!</button>
										</div>
									</form></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="clear"></div>
		<div class="content_bottom">
			<div class="wrap">
				<%
					if (session == null || session.getAttribute("username") == null) {
				%>
				<div class="register_account">
					<h3>Register New Account</h3>
					<form method="post" action="register">
						<table>
							<tbody>
								<tr>
									<td><input type="email" id="email" name="email"
										value="E-Mail" /><br /> <input type="password" id="pass"
										name="pass" value="password" /><br /> <input type="text"
										id="name" name="name" value="Name" /><br /> <input type="text"
										id="address" name="address" value="Address" /><br /></td>
									<td><input type="text" id="city" name="city" value="City" /><br />
										<input type="text" id="country" name="country" value="Country" /><br />
										<input type="text" id="telnumber" name="telnumber"
										value="Telephone number" /><br /> <input type="text"
										id="company" name="company" value="Company Name" /><br /></td>
								</tr>
							</tbody>
						</table>
						<div class="search">
							<button type="submit" value="register" class="grey">Create
								Account</button>
						</div>
						<p class="terms">
							By clicking 'Create Account' you agree to the <a href="#">Terms
								&amp; Conditions</a>.
						</p>
					</form>

				</div>
				<div class="login_panel">
					<h3>Existing Customers</h3>
					<p>Sign in with the form below.</p>
					<form action="login" method="post">
						<input id="emaillogin" name="emaillogin" type="text"
							value="Username" class="field"> <input id="passlogin"
							name="passlogin" type="password" value="Password" class="field">
						<div class="buttons">
							<div>
								<button type="submit" value="login" class="grey">Sign
									In</button>
							</div>
						</div>
					</form>
					<p class="note">
						If you forgot your password just enter your email and click <a
							href="#">here</a>
					</p>

				</div>
				<div class="clear"></div>
				<%
					} else {
					}
				%>
			</div>
		</div>
	</div>


	<div class="footer">
		<div class="wrap">
			<div class="footer_grides">
				<div class="footer_grid2" style="padding: 0px">
					<h3>About Us</h3>
					<p>Plaintech UK is an internationally operating organization
						with its main headquarters in Birmingham (UK). One division of
						Plaintech is based in the Netherlands to address the Dutch market
						and Scandinavia. Plaintech has decades of experience in the
						hosting business.</p>
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
							<li><a href="hosting.jsp">Cloud Hosting</a></li>
							<li><a href="services.jsp">Cloud Services</a></li>
							<li><a href="about.jsp">About Plaintech</a></li>
							<li><a href="support.jsp">Support</a></li>
						</ul>
					</div>
				</div>
				<div class="footer_grid4">
					<h3>Follow</h3>
					<div class="img_list">
						<ul>
							<li><img src="images/facebook.png" alt="" /><a href="#">Join
									Us on Facebook</a></li>
							<li><img src="images/twitter.png" alt="" /><a href="#">Follow
									Us on Twitter</a></li>
						</ul>
					</div>
				</div>
				<div class="clear"></div>
			</div>

		</div>
	</div>

</body>
</html>
