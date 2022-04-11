/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.porfolio.repository.Foto;

import com.porfolio.porfolio.model.Foto;

/**
 *
 * @author dante
 */
public interface IFotoRepository {
    public void actualizarFoto(Foto foto);
    public Foto obtenerFoto();
}
