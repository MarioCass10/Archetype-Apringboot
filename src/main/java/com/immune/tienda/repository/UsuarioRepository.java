package com.immune.tienda.repository;

import javax.transaction.Transactional;

import com.immune.tienda.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{	//En el usuario repository solamente inserto dos Querrys.
	
	@Query(value = "SELECT * FROM usuario WHERE correo = ?1", nativeQuery = true)	//Identificar el correo
	public Usuario getByEmail(String email); 

	@Transactional
	@Modifying
	@Query(value = "UPDATE usuario SET nombre=?1 ,password=?2 ,correo=?3 where id=?4", nativeQuery = true)	//Actualizar y Editar usuario
	public void update(String nombre, String password, String correo, Integer id);
	
	/*@Query(value = "SELECT mail FROM user WHERE correo = '{$correo}' ", nativeQuery = true)
    public Usuario getByCorreo(String correo);*/

}