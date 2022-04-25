/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.porfolio.repository.Experiencia;

import com.porfolio.porfolio.model.Experiencia;
import java.util.List;

/**
 *
 * @author dante
 */
public interface IExperienciaRepository  {
    
    public List<Experiencia> obtenerExperiencias();
    public void agregarExperiencia(Experiencia experiencia);
    public void eliminarExperiencia(Experiencia experiencia);
}
