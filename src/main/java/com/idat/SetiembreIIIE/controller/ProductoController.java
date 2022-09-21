package com.idat.SetiembreIIIE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.SetiembreIIIE.model.Producto;
import com.idat.SetiembreIIIE.service.ProductoService;

@RestController
@RequestMapping("/producto/v1")//esto es el recurso pricipal o raiz
public class ProductoController {
	
	
	@Autowired
	private ProductoService productoService;
	
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)//esto es el subrecurso u el metodo
	public ResponseEntity<List<Producto>> listarproductos(){//cuando queremos interactuar con respuesta http debemos poner  ResponseEntity
		return new ResponseEntity<List<Producto>>(productoService.listar(), HttpStatus.OK) ;
	}
	
	
	//cuando usamos los metodos post y actualizar, siempre recibiremos un objeto, usamos el requestbody
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Producto producto){
		productoService.guardar(producto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	//cuando mandamos parametros por el uri usamos el pathvariable
	@RequestMapping(path = "/listar/{id}",method = RequestMethod.GET)
	public ResponseEntity<Producto> obtenerPorId(@PathVariable Integer id){
		
		Producto proexistente = productoService.obtener(id);
		if(proexistente !=null) {
			return new ResponseEntity<Producto>(proexistente,HttpStatus.OK);
		}else {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@RequestMapping(path = "/editar",method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Producto producto){
		
		Producto proexistente = productoService.obtener(producto.getIdProducto());
		
		if(proexistente != null) {
			productoService.actualizar(producto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Producto proexistente = productoService.obtener(id);
		if(proexistente != null) {
			productoService.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}

	

}
