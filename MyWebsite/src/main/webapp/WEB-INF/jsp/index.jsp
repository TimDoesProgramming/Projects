<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Portfolio</title>
	<!-- css files -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.3.1/css/bulma.min.css">
	<link href="<c:url value='/css/styles.css'/>" rel="stylesheet">

	<link type="image/x-icon" href="<c:url value='/img/favicon.png'/>" rel="icon">
	<meta name="author" content="Timothy Alban">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
	<body>
		<!-- Navbar -->
		<nav class="nav container void-background">
			<!-- This "nav-menu" is hidden on mobile -->
			<!-- Add the modifier "is-active" to display it on mobile -->
			<div class="nav-left">
				<a href="https://github.com/TimothyAlban" class="nav-item">
					<span class="icon">
						<i class="fa fa-github"></i>
					</span>
				</a>
			</div>

			<div class="nav-right nav-menu">
				<a class="nav-item" href="#about">About</a>
				<a class="nav-item" href="#projects">Projects</a>
				<a class="nav-item" href="#social">Social</a>
			</div>

			<!-- This "nav-toggle" hamburger menu is only visible on mobile -->
			<!-- You need JavaScript to toggle the "is-active" class on "nav-menu" -->
			<span class="nav-toggle">
				<span></span>
				<span></span>
				<span></span>
			</span>
		</nav>

		<!-- About Me -->
		<section id="about" class="section section-1">
			<div class="container has-text-centered">
				<!-- Source: https://flic.kr/p/pAZBNK -->
				<img class="avatar" src="<c:url value='/img/profile.png'/>">
			</div>
			<div class="container"></br>
				<p class="intro">
					Hi I&#39;m Timothy Alban. I started my career with a passion for technology and a desire to learn. I am currently an SDET with experience in Java, Selenium, and Cucumber.
				</p>
			</div>
		</section>

		<!-- Projects -->
		<section  id="projects" class="section section-2">
			<div class="container">
				<div class="has-text-centered">
					<h3 class="title is-3">Projects</h3>
				</div>

				<div class="columns is-multiline is-desktop">
					<!-- Project 1 -->
					<div class="column">
						<div class="box project-text">
							<article>
								<div>
									<figure class="image project-figure">
										<img src="<c:url value='/img/project-1.jpg'/>" alt="Image">
									</figure>
								</div>
								<div>
									<p>
										They don’t want us to eat. I told you all this before, when you have a swimming pool, do not use chlorine, use salt water, the healing, salt water is the healing.
									</p>
								</div>
							</article>
						</div>
					</div>
					<!-- Project 2 -->
					<div class="column">
						<div class="box project-text">
							<article>
								<div>
									<figure class="image project-figure">
										<img src="<c:url value='/img/project-2.jpg'/>" alt="Image">
									</figure>
								</div>
								<div>
									<p>
										Bless up. Another one. How’s business? Boomin. Don’t ever play yourself. Life is what you make it, so let’s make it.
									</p>
								</div>
							</article>
						</div>
					</div>
				</div>
			</div>
		</section>

		<!-- Social -->
		<section id="social" class="section section-3">
			<div class="container">
				<div class="has-text-centered">
					<h3 class="title is-3">Let's Socialize</h3>
				</div>
				<div class="social-container columns">
					<div class="column is-6 has-text-centered">
						<a target="_blank" href="https://www.linkedin.com/in/timothy-alban-2564551a7/"><img class="" src="<c:url value='/img/linkedin.png'/>"></a>
					</div>
					<div class="column is-6 has-text-centered">
						<a target="_blank" href="https://www.facebook.com/timmehhhhhhhhh/"><img class="" src="<c:url value='/img/facebook.png'/>"></a>
					</div>
				</div>
			</div>
		</section>

		<!-- Footer -->
		<section class="section-4 has-text-centered container">
			<a>Timothy Alban</a>
		</section>

		<!-- Scripts  -->
		<script src="<c:url value='/script/controller.js'/>"></script>
	</body>
</html>