package com.formacionbdi.springboot.app.productos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.IProductoService;

@RestController    //Convierte_la_respuesta_a_una_estructura_jSON
public class ProductoController {
	@Autowired  // Injeccion_de_dependencia
	private IProductoService productoService;
	
	@GetMapping("/listar") //Se_mapea el_metodo a_una_ruta_de_un_endpoint_para_que_se_comunique los otros servicios 
	public List<Producto> listar(){
		return productoService.findAll();
	}
	
	@GetMapping("/show/{id}")
	public Producto detalle(@PathVariable Long id) {
		return productoService.findById(id);
	}
}
