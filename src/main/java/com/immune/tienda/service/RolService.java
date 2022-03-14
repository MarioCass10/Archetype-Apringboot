package com.immune.tienda.service;

import com.immune.tienda.entity.Rol;
import com.immune.tienda.repository.RolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {   //Servicio rol
    @Autowired
    private RolRepository rolRepositorio;

    public RolService(RolRepository rolRepository){
        
    }
    public Iterable<Rol> getRols(){ //Obtiene los roles que los devuelve al rol repository
        return rolRepositorio.findAll();
    }

    public Iterable<String> getCount(){ //Cuenta los roles y luego lo devuelve.
        return rolRepositorio.getCount();
    }
    

}