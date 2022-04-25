/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.porfolio.repository.Persona;

import com.porfolio.porfolio.model.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dante
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

  public Optional<Persona> findByEmail(String email);
	
	public Optional<Persona> findByUsernameOrEmail(String username,String email);
	
	public Optional<Persona> findByUsername(String username);
	
	public Boolean existsByUsername(String username);
	
	public Boolean existsByEmail(String email);
	

}
