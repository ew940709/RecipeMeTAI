<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@
	taglib
	prefix="form" uri="http://www.springframework.org/tags/form"%><%@
	taglib
	prefix="spring" uri="http://www.springframework.org/tags"%>
<%@	taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
</head>
<body>

	<h2>Submitted Information</h2>
	<div>
		<c:forEach var="ingredient" items="${ingrefientList.ingList}" varStatus="status">
			<div class="form-group row checkbox">
			<label class="form-control-label">${ingredient.name}</label><label class="form-control-label">${ingredient.selected}</label>
			</div>
		</c:forEach>
	</div>
</body>
</html>