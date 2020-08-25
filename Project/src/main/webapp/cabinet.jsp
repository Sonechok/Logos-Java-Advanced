<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="resources/css/style.css">
	<link href="https://fonts.googleapis.com/css?family=Lobster|Oswald:400,700|Poiret+One&display=swap" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <script src="resources/js/jquery.vide.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
	<title>Registration</title>
</head>
<body>
<header class="header">
	<div class="container">
		<div class="header_inner">
			<div class="header_logo">Coding City</div>
			<nav class="nav">
				<ul>
                    <c:if test="${role == 'ADMIN'}">
                        <li><a class="nav_link" href="/admin/cabinet">Create course</a></li>
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
                                        </c:choose>
					<li><a class="nav_link" href="/courses">Our courses</a></li>

				</ul>
			</nav>
		</div>
	</div>
</header>
    <div class="intro">
    <h2 class="section_title1">Welcome to your cabinet ${email}</h2>
    </div>
</body>
</html>