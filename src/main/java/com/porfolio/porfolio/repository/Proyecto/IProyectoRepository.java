/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.porfolio.repository.Proyecto;

import com.porfolio.porfolio.model.Proyecto;
import java.util.List;

/**
 *
 * @author Dante
 */
public interface IProyectoRepository {
    public List<Proyecto> obtenerProyectos();
    public void eliminarProyecto(Proyecto proyecto);
    public void agregarProyecto(Proyecto proyecto);
}
