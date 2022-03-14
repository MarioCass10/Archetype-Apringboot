package com.immune.tienda.service;

import com.immune.tienda.entity.Producto;
import com.immune.tienda.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {	//Servicio producto
    
	private ProductoRepository productoRepository;
	
	public ProductoService() {
	}

	@Autowired
	public void setProductoRepository(ProductoRepository productoRepository){	
		this.productoRepository = productoRepository;
	}
	
	public ProductoService(ProductoRepository productoRepository) {	//Envia los datos al productorepository.
		this.productoRepository = productoRepository;
	}
	
	public Iterable<Producto> getProductos() {	//Obtiene todos los productos y los envia al repository,
		return productoRepository.findAll();
	}
	

	public void registerProducto(Producto producto) throws Exception{	//Resgistra el producto y sino lanza una excepcion.
		if (null==producto.getNombre()) {
			throw new Exception("Faltan campos");
		}
		
		this.productoRepository.save(producto);
	}

    public Producto getProductoById(Integer productoId){	//Obtiene y devuelve el id del producto.
        return productoRepository.findById(productoId).get();
    }
}
