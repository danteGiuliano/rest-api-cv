/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.porfolio.services;

import com.porfolio.porfolio.model.Estudio;
import com.porfolio.porfolio.repository.Estudio.EstudioRepository;
import com.porfolio.porfolio.repository.Estudio.IEstudioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dante
 */
@Service
public class EstudioService implements IEstudioRepository{
@Autowired

    private EstudioRepository repository;
    
    @Override
    public List<Estudio> obtenerEstudios() {
        return this.repository.findAll();
     }

    @Override
    public void agregarEstudio(Estudio estudio) {
        this.repository.save(estudio);
    }
    
    
}
