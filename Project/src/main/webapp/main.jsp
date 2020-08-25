<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="resources/css/style.css">
	<link href="https://fonts.googleapis.com/css?family=Lobster|Oswald:400,700|Poiret+One&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
	<title>Coding City</title>
</head>
<body>
<header class="header">
	<div class="container">
		<div class="header_inner">
			<div class="header_logo">Coding City</div>
			<nav class="nav">
				<ul>
                    <c:if test="${role == 'ADMIN'}">
                        <li><a class="nav_link" href="admin/cabinet">Create course</a></li>
                    </c:if>
                    <c:choose>
                                <c:when test="${email != null}">
                                         <li><a class="nav_link" href="#">Cabinet</a>
                    			                <ul class="submenu">
                    			                    <li><a class="nav_link" href="/cabinet">Your profile</a></li>
                    					        <li><a class="nav_link" href="/logout">Sing out</a></li>
                    			                </ul>
                    			            </li>
                                           </c:when>
                                           <c:otherwise>
                                               <ul>
                    				           <li><a class="nav_link" href="${pageContext.request.contextPath}/login">Sign in</a></li>
                    			            </ul>
                                           </c:otherwise>
                                        </c:choose>
					<li><a class="nav_link" href="/courses">Our courses</a></li>

				</ul>
			</nav>
		</div>
	</div>
</header>

	<div class="intro">
		<div class="container">
			<div class="intro_inner">
				<h1 class="intro_title">Welcome to CodingCity</h1>
				<a class="btn" href="#start">Let's start</a>

			</div>
		</div>
	</div>
	<section class="section" id="start">
		<div class="container">
			<div class="section_header">
				<h3 class="section_suptitle">What we do</h3>
				<h2 class="section_title">Story about us</h2>
				<div class="section_text">
					<p class="text">We are a little company, which helps people to "enter" the IT. </p>
				</div>
			</div>
			
			<div class="about">
				<div class="about_item">
					<div class="about_img">
						<img class="about_imgs" src="resources/images/about1.jpg">
					</div>
					<div class="about_text">
						advanced technologies
					</div>
				</div>
				<div class="about_item">
					<div class="about_img">
						<img class="about_imgs" src="resources/images/about3.jpg">
					</div>
					<div class="about_text">
						super team
					</div>
				</div>
				<div class="about_item">
					<div class="about_img">
						<img class="about_imgs" src="resources/images/about2.jpg">
					</div>
					<div class="about_text">
						employment
					</div>
				</div>
			</div>
		</div>	
	</section>
	<div class="statistic">
		<div class="container">
			<div class="stat">
				<div class="stat_item">
					<div class="stat_num">175</div>
					<div class="stat_text">students</div>
				</div>
				<div class="stat_item">
					<div class="stat_num">95</div>
					<div class="stat_text">employed students</div>
				</div>
				<div class="stat_item">
					<div class="stat_num">27</div>
					<div class="stat_text">online</div>
				</div>
			</div>
		</div>
	</div>    
</body>
</html>