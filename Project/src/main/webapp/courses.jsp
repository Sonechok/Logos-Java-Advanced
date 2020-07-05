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
			<div class="header_logo"><a class="nav_link" href="/main">Coding City</a></div>
			<nav class="nav">
				<ul>
                    <c:if test="${role == 'ADMIN'}">
                        <li><a class="nav_link" href="/admin/cabinet">Create course</a></li>
                    </c:if>
                    <c:choose>
                                <c:when test="${email != null}">
                                         <li><a class="nav_link" href="#courses">Cabinet</a>
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
					<li><a class="nav_link" href="#courses">Our courses</a></li>

				</ul>
			</nav>
		</div>
	</div>
</header>
<body>
    <section class="section" id="courses">
    		<div class="container" id="java">
    			<div class="section_header">
    				<h2 class="section_title">Our courses</h2>
    				<h2 class="section_title1">Java</h2>
    			</div>
    			<div class="courses" >
    				<div class="courses_item" id = "j">
    				</div>
    				<div class="courses_item">
    					<div class="accordion" >
    						<div class="accordion_item">
    							<div class="accordion_title">Java</div>
    							<div class="accordion_content">
    								<p>
    									Java is a general-purpose programming language that is class-based, object-oriented, and designed to have as few implementation dependencies as possible. It is intended to let application developers write once, run anywhere (WORA), meaning that compiled Java code can run on all platforms that support Java without the need for recompilation. Java applications are typically compiled to bytecode that can run on any Java virtual machine (JVM) regardless of the underlying computer architecture. The syntax of Java is similar to C and C++, but it has fewer low-level facilities than either of them. As of 2019, Java was one of the most popular programming languages in use according to GitHub, particularly for client-server web applications, with a reported 9 million developers.
    								</p>
    							</div>
    						</div>
    					</div>
    				</div>
    			</div>
    		</div>
    	</section>
    	<section class="section" id="cs">
    		<div class="container">
    			<div class="section_header">
    				<h2 class="section_title1">C#</h2>
    			</div>
    			<div class="courses">
    				<div class="courses_item" id ="cSh"></div>
    				<div class="courses_item">
    					<div class="accordion" >
    						<div class="accordion_item">
    							<div class="accordion_title">C#</div>
    							<div class="accordion_content">
    								<p>
    									C# (pronounced see sharp, like the musical note C♯, but written with the number sign) is a general-purpose, multi-paradigm programming language encompassing strong typing, lexically scoped, imperative, declarative, functional, generic, object-oriented (class-based), and component-oriented programming disciplines. It was developed around 2000 by Microsoft as part of its .NET initiative, and later approved as an international standard by Ecma (ECMA-334) and ISO (ISO/IEC 23270:2018). Mono is the name of the free and open-source project to develop a compiler and runtime for the language. C# is one of the programming languages designed for the Common Language Infrastructure (CLI).C# was designed by Anders Hejlsberg, and its development team is currently led by Mads Torgersen. The most recent version is 8.0, which was released in 2019 alongside Visual Studio 2019 version 16.3.
    								</p>
    							</div>
    						</div>
    					</div>
    				</div>
    			</div>
    		</div>
    	</section>
    	<section class="section" id="python">
    		<div class="container">
    			<div class="section_header">
    				<h2 class="section_title1">Python</h2>
    			</div>
    			<div class="courses">
    				<div class="courses_item" id="py">
    				</div>
    				<div class="courses_item">
    					<div class="accordion" >
    						<div class="accordion_item">
    							<div class="accordion_title">Python</div>
    							<div class="accordion_content">
    								<p>
    									Python is an interpreted, high-level, general-purpose programming language. Created by Guido van Rossum and first released in 1991, Pythons design philosophy emphasizes code readability with its notable use of significant whitespace. Its language constructs and object-oriented approach aim to help programmers write clear, logical code for small and large-scale projects. Python is dynamically typed and garbage-collected. It supports multiple programming paradigms, including structured (particularly, procedural), object-oriented, and functional programming. Python is often described as a "batteries included" language due to its comprehensive standard library.
    								</p>
    							</div>
    						</div>
    					</div>
    				</div>
    			</div>

    		</div>

    	</section>
    	<section class="section">
    	<div class="container">
    	<h2 class="section_title1">Enter course you want to buy(JAVA, C#, PYTHON)</h2>
    	<form method="post">
              <input type="text" name="course" placeholder="Course">
             <input type="submit" name="" value="Buy">
                  </form>
              </div>
    	</section>
</body>
</html>