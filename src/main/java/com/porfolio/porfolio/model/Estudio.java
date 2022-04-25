/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.porfolio.model;

import javax.persistence.*;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
/**
 * @author dante
 */
public class Estudio {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
   private String titulo;
   private String institucion;
   private String fecha_inicio;
   private String acerca_de;
   private String fecha_fin;
   private String url_logo;
}
