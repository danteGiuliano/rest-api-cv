/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.porfolio.repository.Estudio;

import com.porfolio.porfolio.model.Estudio;
import java.util.List;

/**
 *
 * @author dante
 */
public interface IEstudioRepository {
    public List<Estudio> obtenerEstudios();
    public void agregarEstudio(Estudio estudio);
    public void eliminarEstudio(Estudio estudio);
}
