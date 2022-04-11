/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.porfolio;

import com.porfolio.porfolio.model.Estudio;
import com.porfolio.porfolio.model.Experiencia;
import com.porfolio.porfolio.model.Foto;
import com.porfolio.porfolio.model.Persona;
import com.porfolio.porfolio.model.Skill;
import com.porfolio.porfolio.services.EstudioService;
import com.porfolio.porfolio.services.ExperienciaService;
import com.porfolio.porfolio.services.FotoService;
import com.porfolio.porfolio.services.PersonaService;
import com.porfolio.porfolio.services.SkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author dante
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class controller {
@Autowired
private PersonaService persona;
@Autowired
private EstudioService estudio;
@Autowired
private SkillService skill;
@Autowired
private ExperienciaService experiencia;
@Autowired
private FotoService foto;



  @GetMapping("/")
public String test(){
return "Api funcionando";
}
@GetMapping("/persona")
public Persona obtenerPersona(){
return this.persona.obtenerPersonas().get(0);
}
@PostMapping("/agregarPersona")
public void actualizarPersona(@RequestBody Persona updatear){
this.persona.agregarPersona(updatear);
}
@PostMapping("/agregarEstudio")
public void agregarEstudio(@RequestBody Estudio updatear){
this.estudio.agregarEstudio(updatear);
}
@GetMapping("/extraerEstudios")
public List<Estudio> getEstudios(){
   return this.estudio.obtenerEstudios();
}
@PostMapping("/agregarSkill")
public void agregarSkill(@RequestBody Skill skill){
    this.skill.agregarSkill(skill);
}
@GetMapping("/extraerSkills")
public List<Skill> obtenerSkills(){
    return this.skill.obtenerSkills();
}

@PostMapping("/agregarExperiencia")
public void agregarExperiencia(@RequestBody Experiencia experiencia){
    this.experiencia.agregarExperiencia(experiencia);
}
@GetMapping("/extraerExperiencias")
public List<Experiencia> obtenerExperiencias(){
    return this.experiencia.obtenerExperiencias();
}
@PostMapping("/updatearFoto")
public void agregarFotoBanner (@RequestBody Foto foto){
    this.foto.actualizarFoto(foto);
}
@GetMapping("/obtenerFoto")
public Foto obtenerFotoPerfil(){
    return this.foto.obtenerFoto();
}

}
    
