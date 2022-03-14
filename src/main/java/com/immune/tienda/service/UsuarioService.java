package com.immune.tienda.service;

import com.immune.tienda.entity.Usuario;
import com.immune.tienda.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {	//Usuario Service
	@Autowired
	private UsuarioRepository userRepository;
	
	public UsuarioService(UsuarioRepository userRepository) {	//Conecta con el usuario repository
		this.userRepository = userRepository;
	}
	
	public Iterable<Usuario> getUsers() {	//Obtiene los usuarios y los devuelve al repository.
		return userRepository.findAll();
	}
	
	public Usuario getUserByEmail(String email) {	//Obtiene email de los usuarios y lode devuelve al repository.
		return userRepository.getByEmail(email);
	}

	/*public Usuario getUserCorreo(String email) {	//Obtiene email de los usuarios y lode devuelve al repository.
		return userRepository.getByCorreo(email);
	}*/

	public Usuario registerUser(Usuario user) throws Exception{	//Registra los usuarios y sino lanza una excepcion.
		if (null==user.getNombre() || null==user.getCorreo()) {
			throw new Exception("Faltan campos");
		}
		try{
			return this.userRepository.save(user);	//Luego los lleva al repository.
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		return null;
		
	}

	public Iterable<String> getUserByRol() {	//Obtiene al usuario dependiendo de su rol, pero este no devuelve nada
		return null;
	}

    public Usuario getUserById(Integer userId){	//Obtiene el usuario por su Id, luego lo envia al repository.
        return userRepository.findById(userId).get();
    }

	public void update(String nombre, String password, String correo, Integer id){	//Actualiza  y Edita el usuario.
    	userRepository.update(nombre, password, correo, id);
    }

	public void delete(Integer id){	//Metodo para eliminar el usuario.
		Usuario user = userRepository.findById(id).get();
		userRepository.delete(user);
	}
	
}