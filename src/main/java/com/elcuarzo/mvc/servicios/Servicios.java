package com.elcuarzo.mvc.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcuarzo.mvc.modelos.Categorias;
import com.elcuarzo.mvc.modelos.Productos;
import com.elcuarzo.mvc.repositorios.CategoriasRepositorio;
import com.elcuarzo.mvc.repositorios.ProductosRepositorio;

@Service
public class Servicios {
	
	@Autowired
	private ProductosRepositorio productoRep;
	
	@Autowired
	private CategoriasRepositorio categoriaRep;
	
	//Crear Producto
	public Productos crearProducto(Productos p) {
		return productoRep.save(p);
	}
	
	//Crear Categoria
	public Categorias crearCategoria(Categorias c) {
		return categoriaRep.save(c);
	}
	
	//Todos los Productos
	public List<Productos> todosLosProductos() {
		return productoRep.findAll();
	}
	
	//Todos las Categorias
	public List<Categorias> todasLasCategorias(){
		return categoriaRep.findAll();
	}
	
	//Encontrar Categoria por id
	public Categorias encontrarCategoriaPorId(Long id) {
		return categoriaRep.findById(id).orElse(null);
	}
	
	//Encontrar Producto por id
	public Productos encontrarProductoPorId(Long id) {
		return productoRep.findById(id).orElse(null);
	}
	
	//Agregar Producto a Categoria
	public void agregarProductoACategoria(Long productoId, Long categoriaId) {
		Optional<Productos> producto = productoRep.findById(productoId);
		Optional<Categorias> categoria = categoriaRep.findById(categoriaId);
		if(producto.isPresent() && categoria.isPresent()) {
			Categorias cat = categoria.get();
			Productos prod = producto.get();
			cat.getProductos().add(prod);
			categoriaRep.save(cat);
		}
	}
	
	//Agregar Categoria a Producto
	public void agregarCategoriaAProducto(Long productoId, Long categoriaId) {
		Optional<Productos> producto = productoRep.findById(productoId);
		Optional<Categorias> categoria = categoriaRep.findById(categoriaId);
		if(producto.isPresent() && categoria.isPresent()) {
			Categorias cat = categoria.get();
			Productos prod = producto.get();
			prod.getCategorias().add(cat);
			productoRep.save(prod);
		}
	}
}
