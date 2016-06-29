<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@
	taglib
	prefix="form" uri="http://www.springframework.org/tags/form"%><%@
	taglib
	prefix="spring" uri="http://www.springframework.org/tags"%>
<%@	taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Users</title>
<link rel="stylesheet" href="<c:url value='/styles/site.css'/>">
<link rel="stylesheet" href="<c:url value='/styles/bootstrap.min.css'/>">
<link rel="stylesheet"
	href="<c:url value='/styles/bootstrap-theme.css'/>">
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="<c:url value='/scripts/lib/bootstrap.min.js'/>"></script>

</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">RecipeMe</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="<c:url value='/index' />">Home page <span
						class="sr-only">(current)</span></a></li>
				<li><a href="<c:url value='/findRecipe' />">Find recipe</a></li>
				<li><a href="<c:url value='/addRecipe' />">Add recipe</a></li>
			</ul>

			<sec:authorize access="isAnonymous()">
				<ul class="nav navbar-nav navbar-right navMargin">
					<li><a href="<c:url value='/user' />">Sign Up</a></li>
					<li><a class="active" href="<c:url value='/login' />">
							Login</a></li>
				</ul>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<ul class="nav navbar-nav navbar-right navMargin">
					<li><a href="<c:url value="/j_spring_security_logout" />">
							Logout</a></li>
				</ul>
			</sec:authorize>
		</div>
	</nav>

	<div class="container loginBox">
		<div class="row">
			<div class="col-sm-4">
				<c:forEach var="recipe" items="${recipes}" varStatus="status">
					<div class="container">

						<div id="panelBox" class="panel panel-primary ">

							<div class="panel-heading">

								<c:set var="recipeURL">
									<c:url value="recipeDetails">
										<c:param name="Id" value="${recipe.id}" />
									</c:url>
								</c:set>
								<h2 class="recipeLink">
									<a href="<c:url value="${recipeURL}"/>"><span
										id="recipeLink">${recipe.title}</span></a>
								</h2>
							</div>
							<div class="panel-body">
								<div class="container">
									<div class="row">
										<div class="col-sm-5">
											<label>Ingredients:</label>
											<c:forEach var="ingredient"
												items="${recipe.ingredientMatches}">

												<c:if test="${ingredient.matching}">
													<span class="ingredient"> <i
														class="fa fa-plus-square plus"></i> <label>${ingredient.ingredientName}</label>
													</span>

												</c:if>
												<c:if test="${!ingredient.matching}">
													<span class="ingredient"> <i
														class="	fa fa-minus-square minus"></i> <label>${ingredient.ingredientName}</label>
													</span>
												</c:if>
											</c:forEach>

										</div>
										<div class="col-sm-3">
											<label>Author: </label>${recipe.author.name }
										</div>
									</div>
								</div>


							</div>
						</div>


					</div>
				</c:forEach>
				

			</div>
			<div class="col-sm-4">
			
			</div>
		</div>


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