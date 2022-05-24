/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.porfolio.services;

import com.porfolio.porfolio.model.Proyecto;
import com.porfolio.porfolio.repository.Proyecto.IProyectoRepository;
import com.porfolio.porfolio.repository.Proyecto.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dante
 */
@Service
public class ProyectoService implements IProyectoRepository{
    @Autowired
    private ProyectoRepository repository;

    @Override
    public List<Proyecto> obtenerProyectos() {
        return this.repository.findAll();
    }

    @Override
    public void eliminarProyecto(Proyecto proyecto) {
        this.repository.delete(proyecto);
    }

    @Override
    public void agregarProyecto(Proyecto proyecto) {
        this.repository.save(proyecto);
    }
    
}
