package com.idat.SetiembreIIIE.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.idat.SetiembreIIIE.model.Producto;

@Repository
public class ProductoRepositoryImp implements ProductoRepository {
	
	//declarando una variable de clase, que se esta comportando como la tabla de base de datos
	List<Producto> almacenamiento = new ArrayList<>();
	

	@Override
	public void guardar(Producto producto) {
		almacenamiento.add(producto);

	}

	@Override
	public void actualizar(Producto producto) {
		Producto exististente = obtener(producto.getIdProducto());
		eliminar(exististente.getIdProducto());
		almacenamiento.add(producto);
		
		

	}

	@Override
	public void eliminar(Integer id) {
		Producto exististenteEliminar = obtener(id);
		almacenamiento.remove(exististenteEliminar);

	}

	@Override
	public List<Producto> listar() {
		return almacenamiento;
	}

	@Override
	public Producto obtener(Integer id) {
		// TODO Auto-generated method stub
		//programacion en flujos, solo funcionan con listas
		return almacenamiento.stream().filter(p->p.getIdProducto() == id).findFirst().orElse(null);
	}
	
	

}
