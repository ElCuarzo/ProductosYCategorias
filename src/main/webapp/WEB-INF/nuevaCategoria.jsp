<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Categoria</title>
</head>
<body>
	<h1>Nueva Categoria</h1>
	<form action="/crear/categoria" method="POST">
		<label for="nombre">Nombre: </label>
		<input type="text" name="nombre" id="nombre">
		<br>
		<button>Crear</button>
	</form>
</body>
</html>