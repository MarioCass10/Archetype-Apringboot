package com.immune.tienda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario", schema = "Tienda" )  //Tabla usuario en la base de datos.
public class Usuario {                       //Mi clase usuario que contiene todos los elementos que se encuentran en mi tabla producto en la base de datos.
	  public static final String HttpStatus = null;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", columnDefinition="text")
    private String nombre;
  
    @Column(name = "correo", columnDefinition="text")
    private String correo;

    @Column(name = "password", columnDefinition="text")
    private String password;
    
    @Column(name = "id_Rol")
    private Integer id_Rol;

    public Usuario() {
      this("","","",0);
    }
    public Usuario(String nombre, String correo, String password, int id_rol) {

      this.nombre = nombre;
      this.correo = correo;
      this.password = password;
      this.id_Rol = id_rol;
    }

    public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
      this.id = id;
    }

    public String getNombre() {
      return nombre;
    }

    public void setNombre(String nombre) {
      this.nombre = nombre;
    }

    public String getCorreo() {
      return correo;
    }

    public void setCorreo(String correo) {
      this.correo = correo;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    public Integer getId_rol() {
      return id_Rol;
    }

    public void setId_rol(Integer id_rol) {
      this.id_Rol = id_rol;
    }

}
