package com.immune.tienda.controller;

import java.sql.SQLException;

import com.immune.tienda.entity.Producto;
import com.immune.tienda.entity.Usuario;
import com.immune.tienda.service.ProductoService;
import com.immune.tienda.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService userService;

	@Autowired
	private ProductoService productoService;

	@GetMapping("/usuarios")	//Consulta de usuarios.
	public ResponseEntity<Object> getUsers() {
		return new ResponseEntity<Object>(userService.getUsers(), HttpStatus.OK);
	}

    @GetMapping("/usuario")	//Consulta para el usuario.
    public ResponseEntity<Object> getUser(@RequestParam Integer userId){
        return new ResponseEntity<Object>(userService.getUserById(userId), HttpStatus.OK);
    }

	@PostMapping("/Agregar")	//Agregar los uarios a la base de datos.
	public ResponseEntity<Object> registerUser(@RequestBody Usuario user) throws Exception {
		try {			
			return new ResponseEntity<Object>(userService.registerUser(user), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}	
	
	@RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

	@GetMapping("/consulta")	//Consulta, es la pagina principal, que contiene las tablas y los botenes de la App.
	public ModelAndView prueba() throws SQLException{
		ModelAndView model = new ModelAndView("consulta");

		String bienvenida ="Bienvenido a mi pagina web";

		Integer cantidadUsuarios = 5;

		model.addObject("stringBienvenida", bienvenida);
		model.addObject("intUsuarios", cantidadUsuarios);

		Iterable<Usuario> usuarios = userService.getUsers();
		model.addObject("usuarios", usuarios);

		Iterable<Producto> productos = productoService.getProductos();
		model.addObject("productos", productos);

		return model;
	}

	@RequestMapping("/Nuevo")	//Consulta para un nuevo producto.
	public ModelAndView nuevo(@RequestParam String producto,@RequestParam String productoNombre,@RequestParam String productoPrecio) throws Exception{
		
		Producto pr = new Producto(productoNombre, Integer.parseInt(productoPrecio));
	
		registerProduct(pr);
		
		return null;
	}

	private void registerProduct(Producto pr) throws Exception {	//Registra el producto.
		
		productoService = new ProductoService();
		productoService.registerProducto(pr);
	}

	
	@GetMapping("/Eliminar")	//Elimina los datos de la base de datos.
	public ModelAndView eliminar(){
		ModelAndView model = new ModelAndView("Delete");
		
		return model;
	}

	@RequestMapping("/Actualizar")	//Actualiza los datos de la base de datos.
	public ModelAndView actualizar(){
		ModelAndView model = new ModelAndView("Update");
		
		return model;
	}

	@RequestMapping("/CrearUsuario")	//Consulta para crear a un usuario.
	public ModelAndView crearUsuario(){
		ModelAndView model = new ModelAndView("CrearUsuario");
		
		return model;
	}

	@RequestMapping("/NuevoUsuario")	//Pide los campos para crear a ese nuevo usuario.
	@ResponseBody
	public ModelAndView nuevo(@RequestParam String nombre ,@RequestParam String contrasena,@RequestParam String id_Rol,@RequestParam String correo) throws Exception{

		Usuario us = new Usuario(nombre, correo, contrasena, Integer.parseInt(id_Rol));

		userService.registerUser(us);

		return new ModelAndView("redirect:/consulta");
	}


	@RequestMapping("/EliminarUsuario")	//Consulta para eliminar al usuario
	public ModelAndView eliminarUsuario(){
		ModelAndView model = new ModelAndView("DeleteUsuario");
		
		return model;
	}

	@RestController
	public class EliminarController{

		@PostMapping("/EliminarUsuarioPorId")	//Elimina usuario por Id.
		@ResponseBody
		public ModelAndView eliminar(@RequestParam String usuario) throws Exception{
			return eliminarUsuarioPorId(usuario);
			
		}

		public ModelAndView eliminarUsuarioPorId(String id) throws Exception {

		ModelAndView model = new ModelAndView("consulta"); 
			int id_usuario = Integer.parseInt(id);
			userService.delete(id_usuario);
		return model;
			}
	}

	@RequestMapping("/ActualizarUsuario")	//Actualiza al usuario y sus campos.
	public ModelAndView actualizarUsuario(){
		ModelAndView model = new ModelAndView("UpdateUsuario");
		
		return model;
	}

	@RequestMapping("/EditarUsuario")	//Edita los campos del usuario.
    @ResponseBody
	public ModelAndView editar(@RequestParam String usuarioId, @RequestParam String nombre, @RequestParam String password, @RequestParam String correo) throws Exception{
		return actualizarUsuarioPorId(usuarioId,nombre,password,correo);
	}

	public ModelAndView actualizarUsuarioPorId(String id,String nombre, String password, String correo) throws Exception {
		
		ModelAndView model = new ModelAndView("consulta");
			int usuarioId = Integer.parseInt(id);
			userService.update(nombre, password, correo, usuarioId);
		return model;
        
		}


}