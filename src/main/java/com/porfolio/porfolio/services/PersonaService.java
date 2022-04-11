/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.porfolio.services;

import com.porfolio.porfolio.model.Persona;
import com.porfolio.porfolio.repository.Persona.IPersonaRepository;
import com.porfolio.porfolio.repository.Persona.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author dante
 */
@Service
public class PersonaService implements IPersonaRepository{
    @Autowired
    private PersonaRepository repository;

    @Override
    public List<Persona> obtenerPersonas() {
        return this.repository.findAll();
    }
    public void agregarPersona(Persona persona){
    this.repository.save(persona);
    }
}
