<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<title>RecipeMe</title>
		<link rel="stylesheet" href="<c:url value='/styles/site.css'/>">
		<link rel="stylesheet" href="<c:url value='/styles/bootstrap.min.css'/>">
		<link rel="stylesheet" href="<c:url value='/styles/bootstrap-theme.css'/>">
		<script src="<c:url value='/scripts/lib/bootstrap.min.js'/>"></script>
	</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-header">
	  		 <a class="navbar-brand" href="#">RecipeMe</a>
	  	</div>
	  	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	  		<ul class="nav navbar-nav">
	  			<li class="active"><a href="#">Home page <span class="sr-only">(current)</span></a></li>
        		<li><a href="<c:url value='/findRecipe' />">Find recipe</a></li>
        		<li><a href="<c:url value='/addRecipe' />">Add recipe</a></li>
	  		</ul>
	  		<sec:authorize access="isAnonymous()">
		  		<ul class="nav navbar-nav navbar-right navMargin">
				      <li><a href="<c:url value='/user' />">Sign Up</a></li>
				      <li><a href="<c:url value='/login' />"> Login</a></li>
	   			</ul>
   			</sec:authorize>
   			<sec:authorize access="isAuthenticated()">
		  		<ul class="nav navbar-nav navbar-right navMargin">
				      <li><a href="<c:url value="/j_spring_security_logout" />""> Logout</a></li>
	   			</ul>
   			</sec:authorize>
	  	</div>
	</nav>
 <header id="top" class="header">
        <div class="text-vertical-center  shadowClass">
            <h1>RecipeMe</h1>
            <h3>When you don't know what you want.</h3>
            <br>
            <a class="btn btn-dark btn-lg">Find Out More</a>
        </div>
   </header>
   
  <section id="services" class="services bg-primary">
  <div class="container">
  <div class="row text-center">
    <div class="col-sm-4">
      <h3 class="text-center">Register</h3>
      <p>Register to fully appreciate using RecipeMe. You can be sure that you'll gain new opportunities which 
		you will find nowhere else.</p>
	  <a href="<c:url value='/login' />" class="btn btn-light">Register</a>
    </div>
     <div class="col-sm-4">
      <h3 class="text-center">Select ingredients</h3>
      <p>Select ingredients you have in your fridge from available list and find out dinner you can prepare using only ingredient you have.</p>
      <a href="<c:url value='/findRecipe' />" class="btn btn-light">Find</a>
    </div>
    <div class="col-sm-4">
      <h3 class="text-center">Rate and add recipe</h3> 
      <p>Share your favourite recipes and rate one that you tried. </p>
      <a href="<c:url value='/addRecipe' />" class="btn btn-light">Add</a>
    </div>
  </div>
  </div>
  </section>

	 <div class="container">
        <div class="col-sm-8 col-sm-offset-2 text-center">
             <h2 class="">RecipeMe</h2>

            <hr class="">
             <h4 class="">
        We love dinners together. We love eating.
      </h4>

            <p class="">Don't ask what to eat. Ask with whom instead.</p>
            <hr class="">
        </div>
        <!--/col-->
    </div>

	<div id="footer" class="">
	    <div class="container">
	   	 <div class="row text-center footerText">
	   		<div class="col-sm-3 pull-right">
	   			<p>RecipeMe 2016</p>
	   		</div>
	    </div>
	       
	    </div>
	</div>


</body>
</html>