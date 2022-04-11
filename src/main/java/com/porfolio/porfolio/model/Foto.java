package com.porfolio.porfolio.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author dante
 */
@Entity @Setter @Getter
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String url_banner;
    private String url_perfil;
    
}
