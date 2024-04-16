<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Mostrar Productos</title>
</head>
<body>
	<h1><c:out value="${producto.nombre}"></c:out></h1>
	
	
	<h3>Categorias dentro del producto: </h3>
	<c:forEach items="${categoriasEnProducto}" var="categoriaEnProducto">
		<ul>
			<li>
				<c:out value="${categoriaEnProducto.nombre}"></c:out>
			</li>
		</ul>
	</c:forEach>
	
	<form action="/productos/${producto.id}/agregarCategoria" method = "POST">
		<label for="categoriaId">Agregar Producto: </label>
		<select name="categoriaId" id="categoriaId">
			<c:forEach items="${categorias}" var="categoria">
				<option value="${categoria.id}">
					<c:out value="${categoria.nombre}"></c:out>
				</option>
			</c:forEach>
		</select>
		<button>Agregar</button>
	</form>
</body>
</html>