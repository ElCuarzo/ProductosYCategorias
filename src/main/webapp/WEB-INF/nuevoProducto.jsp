<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Producto</title>
</head>
<body>
	<h1>Nuevo Producto</h1>
	
	<form action="/crear/producto" method="POST">
		<label for="nombre">Nombre: </label>
		<input type="text" id="nombre" name="nombre" required>
		<br>
		<label for="descripcion">Descripción: </label>
		<input type="text" id="descripcion" name="descripcion" required>
		<br>
		<label for="precio">Precio: </label>
		<input type="number" id="precio" name="precio" step="0.01" required>
		<br>
		<button>Crear</button>
	</form>
</body>
</html>