package com.immune.tienda.controller;

import com.immune.tienda.service.RolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RolController {	//En este se donomina los roles para la base de datos, como administrador y usuario.

	@Autowired
	private RolService rolService;	//No se utiliza mucho a lo largo de la aplicacion.

	@GetMapping("/roles")
	public ResponseEntity<Object> getRoles() {
		return new ResponseEntity<Object>(rolService.getRols(), HttpStatus.OK);
	}

}