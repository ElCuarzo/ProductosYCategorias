<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Mostrar Categorias</title>
</head>
<body>
	<h1><c:out value="${categoria.nombre}"></c:out></h1>
	
	<h2>Productos dentro de la categoria:</h2>
	<c:forEach items="${productosEnCategoria}" var="productoEnCategoria">
		<ul>
			<li>
				<c:out value="${productoEnCategoria.nombre}"></c:out>
			</li>
		</ul>
	</c:forEach>
	
	<h2>Agregar Producto A La Categoria:</h2>
	<form action="/categorias/${categoria.id}/agregarProducto" method = "POST">
		<label for="productoId">Agregar Producto: </label>
		<select name="productoId" id="productoId">
			<c:forEach items="${productos}" var="producto">
				<option value="${producto.id}">
					<c:out value="${producto.nombre}"></c:out>
				</option>
			</c:forEach>
		</select>
		<button>Agregar</button>
	</form>
</body>
</html>