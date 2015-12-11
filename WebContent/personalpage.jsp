<!DOCTYPE HTML>
<html>
<head>
<title>Plaintech | Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Electrolize'
	rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
</head>
<body>
	<%
		if (session == null || session.getAttribute("username") == null) {
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			rs.forward(request, response);
		} else {
			String user = (String) session.getAttribute("username");
	%>
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
					<li><form action="manageVM" method="post">
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
	<div class="clear"></div>
	<div class="main">
		<div class="content_top">
			<div class="wrap">
				<div class="personal_page">
					<h3>
						Welcome on your personal page
						<%
						out.println(user);
					%>
					</h3>

					<h4>Check the status of your Virtual Machine.</h4>
					<form action="Status" method="post">
						<div class="buttonsss">
							<button type="submit" value="register" class="grey">Click
								here to check</button>
						</div>
					</form>

					<h4>Start your Virtual Machine.</h4>
					<form method="post" action="Startstopvm">
						<input type="hidden" type="text" name="startstop" id="startstop"
							value="1">
						<div class="buttonsss">
							<button type="submit" value="register" class="grey">Start
								Virtual Machine</button>
						</div>
					</form>
					<h4>Stop your Virtual Machine.</h4>
					<form method="post" action="Startstopvm">
						<input type="hidden" type="text" name="startstop" id="startstop" value="2">
						<div class="buttonsss">
							<button type="submit" value="register" class="grey">Stop
								Virtual Machine</button>
						</div>
					</form>
					<h4>Delete your Virtual Machine.</h4>
					<form method="post" action="Startstopvm">
						<input type="hidden" type="text" name="startstop" id="startstop" value="3">
						<div class="buttonsss">
							<button type="submit" value="register" class="grey">Delete
								Virtual Machine</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="clear"></div>
	<div class="main">
		<div class="content_bottom">
			<div class="wrap">
				<div class="ptables">
					<div class="change_vm">
						<h3>Change the specifications of your VM.</h3>

						<form method="post" action="changeVM">
							Choose the amount of CPU's. <input name="CPU" id="CPU"
								type="text"><br> Choose the amount of RAM. <input
								name="RAM" id="RAM" type="text"><br> Choose the
							amount of Storage. <input name="STORAGE" id="STORAGE" type="text">
							<div class="buttons">
								<button type="submit" value="register" class="grey">Update
									VM</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="clear"></div>
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
	<%
		}
	%>
</body>
</html>

