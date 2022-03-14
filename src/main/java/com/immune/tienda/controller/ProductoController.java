package com.immune.tienda.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.immune.tienda.entity.Producto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ProductoController {   //Llamo al request para que lleve al apartado para crear un nuevo producto

	@RequestMapping("/CrearProducto")
    @ResponseBody
	public ModelAndView crearProducto(){
		ModelAndView model = new ModelAndView("CrearProducto");

		String bienvenida ="Crear nuevo producto";

		model.addObject("stringBienvenida", bienvenida);
		
		return model;
	}

	@RequestMapping("/NuevoProducto")   //Realizo un request para que lleve al apartado para un nuevo producto, en donde le inserto los parametros de su nombre y precio
    @ResponseBody
	public ModelAndView nuevo(@RequestParam String productoNombre,@RequestParam String productoPrecio) throws Exception{
		
		
		Producto pr = new Producto(productoNombre, Integer.parseInt(productoPrecio));
	
		return registerProduct(pr);
	}

	private ModelAndView registerProduct(Producto pr) throws Exception {
        String url = "jdbc:mysql://localhost:3306/Tienda?user=root&password=immune";    //Por fallos de concexion con la base de datos, tuve que escrbir este link manualmente para que funcionara
		Connection conexion = DriverManager.getConnection(url);
        Statement stm = null;
        String sql = "INSERT INTO producto (nombre,precio) VALUES ('"+pr.getNombre()+"',"+pr.getPrecio()+")";   //Inserto la Querry

        try {                                   //Prueba de conexion
            stm = conexion.createStatement();
            stm.execute(sql);
            stm.close();
            conexion.close();
        } catch (SQLException e ) {
            System.out.println(e.getMessage());
        }

		return new ModelAndView("redirect:/Consulta");  //Se redirecciona a consulta

	}

	@RestController
	public class EliminarController{

    @RequestMapping("/EliminarPorId")   //Metodo para eliminar el producto segun su Id
    @ResponseBody
	public ModelAndView eliminar(@RequestParam String producto) throws Exception{
		return eliminarPorId(producto);
		
	}

	public ModelAndView eliminarPorId(String id) throws Exception {
        
        String url = "jdbc:mysql://localhost:3306/Tienda?user=root&password=immune";    //Realizo la misma conexion del request anterior
		Connection conexion = DriverManager.getConnection(url);
        Statement stm = null;
        String sql = "DELETE FROM producto where id ="+id;  //Querry para porder buscar y luego eliminar por Id
        try {
            stm = conexion.createStatement();
            stm.execute(sql);
            stm.close();
            conexion.close();
            
        } catch (SQLException e ) {
            System.out.println(e.getMessage());

        }
        return new ModelAndView("redirect:/Consulta"); //Redirecciono a consulta
		}
	}

	@RequestMapping("/EditarProducto")  //Se edita el producto
    @ResponseBody
	public ModelAndView editar(@RequestParam String productoId, @RequestParam String productoNombre, @RequestParam String productoPrecio) throws Exception{
		return actualizarPorId(productoId,productoNombre,productoPrecio);
	}

	public ModelAndView actualizarPorId(String id,String nombre, String precio) throws Exception {    //Se actualiza el producto por Id
        String url = "jdbc:mysql://localhost:3306/Tienda?user=root&password=immune";
		Connection conexion = DriverManager.getConnection(url);
        Statement stm = null;
        String sql = "UPDATE producto SET nombre='"+nombre+"',precio="+precio+" where id="+id;  //Querry para actualizar el producto
        try {
            stm = conexion.createStatement();
            stm.execute(sql);
            stm.close();
            conexion.close();
            
        } catch (SQLException e ) {
            System.out.println(e.getMessage());

        }
		return new ModelAndView("redirect:/Consulta");  //Se redirecciona a consulta
        
		}

    
}

