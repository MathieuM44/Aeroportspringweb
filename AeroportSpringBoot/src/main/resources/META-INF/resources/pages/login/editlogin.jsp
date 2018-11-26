<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>editer des logins</title>
</head>
<body>
	<div class="container">
		<fieldset>
			<legend> edition de logins </legend>
			<div>
				<div>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<form:form action="./save" method="get" modelAttribute="log">
							<form:hidden path="version" />
							<div class="form-group">
								<form:label path="id">id</form:label>
								<form:input path="id" readonly="true" cssClass="form-control" />
							</div>
							<div class="form-group">
								<form:label path="login">login</form:label>
								<form:input path="login" cssClass="form-control" />
								<form:errors path="login">login</form:errors>
							</div>
							<div class="form-group">
								<form:label path="motDePasse">motDePasse</form:label>
								<form:input path="motDePasse" cssClass=" form-control" />
								<form:errors path="motDePasse">motDePasse</form:errors>
							</div>
							<div class="form-group">
								<form:label path="admin">admin</form:label>
								<form:input path="admin" cssClass=" form-control" />
								<form:errors path="admin"></form:errors>
							</div>
							<div class="form-group">
								<button type="submit" class=" btnbtn-success">enregistrer</button>
								<a class="btn btn-danger" href="./">annuler</a>
							</div>
						</form:form>
					</sec:authorize>
				</div>
				<div>
					<sec:authorize access="hasRole('ROLE_USER')">
						<form:form action="./save" method="get" modelAttribute="log">
							<form:hidden path="version" />
							<div class="form-group">
								<form:label path="id">id</form:label>
								<form:input path="id" readonly="true" cssClass="form-control" />
							</div>
							<div class="form-group">
								<form:label path="login">login</form:label>
								<form:input path="login" cssClass="form-control" />
								<form:errors path="login">login</form:errors>
							</div>
							<div class="form-group">
								<form:label path="motDePasse">motDePasse</form:label>
								<form:input path="motDePasse" cssClass=" form-control" />
								<form:errors path="motDePasse">motDePasse</form:errors>
							</div>
							<c:choose>
								<c:when test="${admin==null}">
									<div class="form-group">
										<form:label path="admin">admin</form:label>
										<form:input path="admin" readonly="false"
											cssClass=" form-control" />
										<form:errors path="admin"></form:errors>
									</div>
								</c:when>
								<c:otherwise>
									<div class="form-group">
										<form:label path="admin">admin</form:label>
										<form:input path="admin" readonly="true"
											cssClass=" form-control" />
										<form:errors path="admin"></form:errors>
									</div>
								</c:otherwise>
							</c:choose>
							<div class="form-group">
								<button type="submit" class=" btnbtn-success">enregistrer</button>
								<a class="btn btn-danger" href="./">annuler</a>
							</div>
						</form:form>
					</sec:authorize>
				</div>
			</div>

		</fieldset>
	</div>
</body>
</html>