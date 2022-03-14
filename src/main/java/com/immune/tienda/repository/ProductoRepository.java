package com.immune.tienda.repository;

import com.immune.tienda.entity.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{      //Como se puede ver no uso mi producto repository, 
//ya que conecto con la base de datos de otra manera.
	

}
