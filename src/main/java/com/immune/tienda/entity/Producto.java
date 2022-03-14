package com.immune.tienda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto", schema = "Tienda" ) //Tabla producto en la base de datos.
public class Producto {                       //Mi clase producto que contiene todos los elementos que se encuentran en mi tabla producto en la base de datos.
	  public static final String HttpStatus = null;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;
  
    @Column(name = "precio")
    private Integer precio;

    public Producto() {
      this("",0);
    }

    public Producto(String nombre, Integer precio) {

        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(Integer id, String nombre, Integer precio) {

        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
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

    public Integer getPrecio() {
      return precio;
    }

    public void setPrecio(Integer precio) {
    }
  }
