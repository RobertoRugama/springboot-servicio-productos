package com.formacionbdi.springboot.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.IProductoService;

@RestController    //Convierte_la_respuesta_a_una_estructura_jSON
public class ProductoController {
	
	//@Autowired
	//private Environment env;
	
	@Value("${server.port}")
	private Integer port;
	@Autowired  // Injeccion_de_dependencia
	private IProductoService productoService;
	
	@GetMapping("/listar") //Se_mapea el_metodo a_una_ruta_de_un_endpoint_para_que_se_comunique_los_otros_servicios 
	public List<Producto> listar(){
		return productoService.findAll().stream().map(producto->{
			//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			producto.setPort(port);
			return producto;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/show/{id}")
	public Producto detalle(@PathVariable Long id) {
		Producto producto = productoService.findById(id);
		//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		producto.setPort(port);
		/*boolean ok = false; //Comentamos la seccion que nos genera a excepcion y a si simular un fallo
		if(!ok) {
			throw new RuntimeException("No se pudo cargar El producto");
		}*/
		return producto;
	}
}
