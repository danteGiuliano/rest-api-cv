/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.porfolio.model;

import javax.persistence.*;
import lombok.*;

/**
 * @author dante
 */
@Entity
@Getter
@Setter

public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private int porcentaje;
    
}
