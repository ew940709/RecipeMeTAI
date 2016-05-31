<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Spring MVC skeleton with Gradle build, Hibernate persistance and Selenium functional testing</title>
		<link rel="stylesheet" href="<c:url value='/styles/default.css'/>">
	</head>
	<body>
		<h1>Spring MVC skeleton with Gradle build, Hibernate persistance and Selenium functional testing</h1>
		<p>Go to <a href="<c:url value='/user' />">User</a> page.</p>
		<a href="<c:url value="j_spring_security_logout" />" > Logout</a>
		
		<sec:authorize access="isAnonymous()">
	    <form method="POST" action="<c:url value='j_spring_security_check'/>">
	        Username: <input name="j_username" type="text" value="${SPRING_SECURITY_LAST_USERNAME}" /> 
	        Password: <input name="j_password" type="password" /> 
	        <input type="submit" value="Sign in" />
	    </form>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
	    	<a href="<c:url value="/j_spring_security_logout" />">Logout</a>
		</sec:authorize>
	</body>
</html>
