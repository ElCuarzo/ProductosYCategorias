package com.elcuarzo.mvc.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.elcuarzo.mvc.modelos.Categorias;
import com.elcuarzo.mvc.modelos.Productos;
import com.elcuarzo.mvc.servicios.Servicios;

@Controller
public class Controlador {
	
	@Autowired
	private Servicios servicios;
	
	
	//Index
	@RequestMapping("/")
	public String index(Model model) {
		List<Categorias> categorias = servicios.todasLasCategorias();
		List<Productos> productos = servicios.todosLosProductos();
		model.addAttribute("productos", productos);
		model.addAttribute("categorias", categorias);
		return "index.jsp";
	}
	
	//CREAR PRODUCTO
	@RequestMapping("/nuevo/producto")
	public String nuevoProducto() {
		return "/nuevoProducto.jsp";
	}
	
	@RequestMapping(value="/crear/producto", method = RequestMethod.POST)
	public String crearProducto(@RequestParam(value="nombre") String nombre,
								@RequestParam(value="descripcion") String descripcion,
								@RequestParam(value="precio") float precio){
		System.out.println(nombre);
		System.out.println(descripcion);
		System.out.println(precio);
		Productos producto = new Productos(nombre, descripcion, precio);
		servicios.crearProducto(producto);
		return "redirect:/";
	}
	
	
	//CREAR CATEGORIA
	@RequestMapping("/crear/categoria")
	public String nuevaCategoria() {
		return "nuevaCategoria.jsp";
	}
	
	@RequestMapping(value="/crear/categoria", method = RequestMethod.POST)
	public String crearCategoria(@RequestParam(value="nombre") String nombre) {
		Categorias categoria = new Categorias(nombre);
		servicios.crearCategoria(categoria);
		return "redirect:/";
	}
	
	
	//ADMINISTRAR PRODUCTOS
	@RequestMapping("/productos/{id}")
	public String adminsitrarProductos(@PathVariable("id") Long id,
										Model model) {
		Productos producto = servicios.encontrarProductoPorId(id);
		List<Categorias> categorias = servicios.todasLasCategorias();
		List<Categorias> categoriasEnProducto = producto.getCategorias();
		model.addAttribute("categoriasEnProducto", categoriasEnProducto);
		model.addAttribute("categorias", categorias);
		model.addAttribute("producto", producto);
		return "mostrarProductos.jsp";
	}
	
	@RequestMapping(value="/productos/{id}/agregarCategoria", method = RequestMethod.POST)
	public String agregarCategoriaAProducto(@PathVariable("id") Long productoId,
	                                        @RequestParam("categoriaId") Long categoriaId) {
	    servicios.agregarCategoriaAProducto(productoId, categoriaId);
	    return "redirect:/productos/" + productoId;
	}
	
	
	//ADMINISTRAR CATEGORIAS
	@RequestMapping("/categorias/{id}")
	public String adminsitrarCategorias(@PathVariable("id") Long id,
										Model model) {
		Categorias categoria = servicios.encontrarCategoriaPorId(id);
		List<Productos> productos = servicios.todosLosProductos();
		List<Productos> productosEnCategoria = categoria.getProductos();
		model.addAttribute("productosEnCategoria", productosEnCategoria);
		model.addAttribute("productos", productos);
		model.addAttribute("categoria", categoria);
		return "mostrarCategorias.jsp";
	}
	
	@RequestMapping(value="/categorias/{id}/agregarProducto", method = RequestMethod.POST)
	public String agregarProductoACategoria(@PathVariable("id") Long categoriaId,
											@RequestParam("productoId") Long productoId) {
		servicios.agregarProductoACategoria(productoId, categoriaId);
		return "redirect:/categorias/" + categoriaId;
	}
}
