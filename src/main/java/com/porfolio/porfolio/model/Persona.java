/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.porfolio.model;

import javax.persistence.*;
import lombok.*;
@Entity
@Getter @Setter
@Table(name = "Persona", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }),
		@UniqueConstraint(columnNames = { "email" }) })
public class Persona {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String password;
    private String username;
    private String email;

    private String nombre;
    private String apellido;
    private String especialidad;
    private String acerca_de;
}
