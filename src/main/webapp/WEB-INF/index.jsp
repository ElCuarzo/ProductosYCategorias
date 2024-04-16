<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Index</title>
</head>
<body>
	<a href="/nuevo/producto">Crear un producto nuevo!</a>
	<br>
	<a href="/crear/categoria">Crea una categoria nueva!</a>
	<br>
	<h1>Categorias: </h1>
	<c:forEach items="${categorias}" var="categoria">
		<ul>
			<li>
				<a href="/categorias/<c:out value="${categoria.id}"></c:out>"><c:out value="${categoria.nombre}"></c:out></a>
			</li>
		</ul>
	</c:forEach>
	<h1>Productos: </h1>
	<c:forEach items="${productos}" var="producto">
		<ul>
			<li>
				<a href="/productos/<c:out value="${producto.id}"></c:out>"><c:out value="${producto.nombre}"></c:out></a>
			</li>
		</ul>
	</c:forEach>
</body>
</html>