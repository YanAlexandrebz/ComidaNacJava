<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>

<title>Comidas - Cadastro</title>

<!-- link com o css e js-->
<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/js" var="js" />
<c:set value="${pageContext.request.contextPath}" var="contextPath" />
<link href="${css}/bootstrap.css" rel="stylesheet">
<link href="${css}/small-business.css" rel="stylesheet">

</head>

<body>
	<!--PREENCHIMENTO PARA UMA NOVA COMIDA-->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="${contextPath}/comida">3SIAGourmet</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="well">

					<h2>Comida</h2>

					<form:form modelAttribute="comidaModel"
						action="${contextPath}/comida/cardapio" method="post">

						<spring:hasBindErrors name="comidaModel">
							<div class="alert alert-danger" role="alert">
								<form:errors path="*" class="has-error" />
							</div>
						</spring:hasBindErrors>
						
						<!--NOME-->
						<div class="form-group">
							<label class="control-label" for="nome">Nome:</label>
							<form:input type="text" path="nome" id="nome"
								class="form-control" maxlength="50" size="50" />
							<font color="red"><form:errors path="nome" /></font><br />
						</div>

						<!--DESCRI��O-->
						<div class="form-group">
							<label class="control-label" for="descricao">Descri��o:</label>
							<form:textarea class="form-control" path="descricao" rows="4"
								cols="100" />
							<font color="red"><form:errors path="descricao" /></font><br />
						</div>

						<!--PRE�O-->
						<div class="form-group">
							<label class="control-label" for="preco">Pre�o:</label>
							<form:input type="number" id="preco" path="preco"
								class="form-control" />
							<font color="red"><form:errors path="preco" /></font><br />
						</div>

						<!--TIPO-->
						<div class="form-group">
							<label class="control-label" for="tipo">Tipo:</label>
							<form:textarea id="tipo" class="form-control" path="tipo"
								rows="4" cols="100" />
							<font color="red"><form:errors path="tipo" /></font><br />
						</div>


						<!--ACOMPANHAMENTO-->
						<div class="form-group">
							<label class="control-label" for="">Acompanhamento:</label>
							<form:textarea id="acompanhamento" class="form-control"
								path="acompanhamento" rows="4" cols="100" />
							<font color="red"><form:errors path="acompanhamento" /></font><br />
						</div>
						<hr>

						<!--CANCELAR-->
						<a class="btn btn-default btn-lg"
							href="${contextPath}/comida/cardapio">Cancelar</a>
						<button type="submit" class="btn btn-primary btn-lg">Gravar</button>

						<br>
						<br>
					</form:form>

				</div>
			</div>
		</div>
	</div>

	<!--SCRIPT-->
	<script src="${js}/jquery.js"></script>
	<script src="${js}/bootstrap.min.js"></script>

</body>
</html>