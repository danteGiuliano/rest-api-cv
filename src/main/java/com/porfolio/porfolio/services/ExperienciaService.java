/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.porfolio.services;

import com.porfolio.porfolio.model.Experiencia;
import com.porfolio.porfolio.repository.Experiencia.ExperienciaRepository;
import com.porfolio.porfolio.repository.Experiencia.IExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dante
 */
@Service
public class ExperienciaService implements IExperienciaRepository {
    @Autowired
    private ExperienciaRepository repository;
    @Override
    public List<com.porfolio.porfolio.model.Experiencia> obtenerExperiencias() {
    return this.repository.findAll();
    }

    @Override
    public void agregarExperiencia(Experiencia experiencia) {
        this.repository.save(experiencia);
    }
    
}
