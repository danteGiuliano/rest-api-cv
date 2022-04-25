/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.porfolio.model;

import javax.persistence.Entity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
/**
 * @author dante
 */

public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String trabajo;
    private String nombre_empresa;
    private String acerca_trabajo;
    private String url_imagen;
}
