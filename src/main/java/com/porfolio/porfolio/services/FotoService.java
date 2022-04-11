/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.porfolio.services;

import com.porfolio.porfolio.model.Foto;
import com.porfolio.porfolio.repository.Foto.FotoRepository;
import com.porfolio.porfolio.repository.Foto.IFotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dante
 */
@Service
public class FotoService implements IFotoRepository{
@Autowired
private FotoRepository repository;
    

    @Override
    public void actualizarFoto(Foto foto) {
      this.repository.save(foto);
    }

    @Override
    public Foto obtenerFoto() {
        return this.repository.findAll().get(0);
     }

   
    
}
