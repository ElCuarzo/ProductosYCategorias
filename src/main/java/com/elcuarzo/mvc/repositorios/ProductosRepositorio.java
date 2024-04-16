package com.elcuarzo.mvc.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elcuarzo.mvc.modelos.Productos;

public interface ProductosRepositorio extends CrudRepository<Productos, Long>{
	List<Productos> findAll();
}
