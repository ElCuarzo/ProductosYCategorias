package com.elcuarzo.mvc.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elcuarzo.mvc.modelos.Categorias;

public interface CategoriasRepositorio extends CrudRepository<Categorias, Long>{
	List<Categorias> findAll();
}
