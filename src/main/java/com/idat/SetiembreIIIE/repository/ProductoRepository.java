package com.idat.SetiembreIIIE.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.SetiembreIIIE.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	
	//si el microservicio solo se quiere hacer un crud se extiende de crudrepository
	// si se quiere paginar se extiende de PagingAndSortingRepository
	//si se quiere hacer las dos cosas anteriores mas querys, se extiende de jparepository
	
}
