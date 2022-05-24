/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.porfolio;

import com.porfolio.porfolio.login.Login;
import com.porfolio.porfolio.model.Estudio;
import com.porfolio.porfolio.model.Experiencia;
import com.porfolio.porfolio.model.Foto;
import com.porfolio.porfolio.model.Persona;
import com.porfolio.porfolio.model.Proyecto;
import com.porfolio.porfolio.model.Skill;
import com.porfolio.porfolio.repository.security.JWTAuthResonseDTO;
import com.porfolio.porfolio.repository.security.JwtTokenProvider;
import com.porfolio.porfolio.services.EstudioService;
import com.porfolio.porfolio.services.ExperienciaService;
import com.porfolio.porfolio.services.FotoService;
import com.porfolio.porfolio.services.PersonaService;
import com.porfolio.porfolio.services.ProyectoService;
import com.porfolio.porfolio.services.SkillService;
import io.jsonwebtoken.Claims;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author dante
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/**")
public class controller {

    @Autowired
    private PersonaService persona;
    @Autowired
    private EstudioService estudio;
    @Autowired
    private SkillService skill;
    @Autowired
    private ProyectoService proyecto; 
    @Autowired
    private ExperienciaService experiencia;
    @Autowired
    private FotoService foto;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;
    private JWTAuthResonseDTO token = new JWTAuthResonseDTO("null");
    @GetMapping("/")
    public String test() {
        return "Api funcionando";
    }
    
    @PostMapping("/tokenValido")
    public ResponseEntity<?> tokenValido(){
        return ResponseEntity.ok(true);
    }


    @PostMapping("/iniciarSesion")
    public ResponseEntity<?> authenticateUser(@RequestBody Login login) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsernameOrEmail(), login.getPassword()));

       SecurityContextHolder.getContext().setAuthentication(authentication);

       String token = this.jwtTokenProvider.generarToken(authentication);
        return ResponseEntity.ok(new JWTAuthResonseDTO(token));
    }

    @GetMapping("/info-persona")
    public Persona obtenerPersona() {
        return this.persona.obtenerPersona();
    }

    @PostMapping("/actualizarPersona")
    public ResponseEntity<?> actualizarPersona(@RequestBody Persona persona) {
        this.persona.agregarPersona(persona);
        return this.refresh();
    }
     @PostMapping("/agregarProyecto")
    public ResponseEntity<?> actualizarProyecto(@RequestBody Proyecto proyecto) {
        this.proyecto.agregarProyecto(proyecto);
        return this.refresh();
    }
    @PostMapping("/agregarEstudio")
    public void agregarEstudio(@RequestBody Estudio updatear) {
        this.estudio.agregarEstudio(updatear);
    }

    @GetMapping("/extraerEstudios")
    public List<Estudio> getEstudios() {
        return this.estudio.obtenerEstudios();
    }@GetMapping("/extraerProyectos")
    public List<Proyecto> getProyecto() {
        return this.proyecto.obtenerProyectos();
    }

    @PostMapping("/agregarSkill")
    public void agregarSkill(@RequestBody Skill skill) {
        this.skill.agregarSkill(skill);
    }

    @GetMapping("/extraerSkills")
    public List<Skill> obtenerSkills() {
        return this.skill.obtenerSkills();
    }

    @PostMapping("/agregarExperiencia")
    public void agregarExperiencia(@RequestBody Experiencia experiencia) {
        this.experiencia.agregarExperiencia(experiencia);
    }

    @GetMapping("/extraerExperiencias")
    public List<Experiencia> obtenerExperiencias() {
        return this.experiencia.obtenerExperiencias();
    }

    @PostMapping("/updatearFoto")
    public void agregarFotoBanner(@RequestBody Foto foto) {
        this.foto.actualizarFoto(foto);
    }

    @GetMapping("/obtenerFoto")
    public Foto obtenerFotoPerfil() {
        return this.foto.obtenerFoto();
    }

    @PostMapping("/eliminarExperiencia")
    public void eliminarExperiencia(@RequestBody Experiencia experiencia) {
        this.experiencia.eliminarExperiencia(experiencia);
    }
     @PostMapping("/eliminarProyecto")
    public void eliminarProyecto(@RequestBody Proyecto proyecto) {
        this.proyecto.eliminarProyecto(proyecto);
    }

    @PostMapping("/eliminarEstudio")
    public void eliminarEstudio(@RequestBody Estudio estudio) {
        this.estudio.eliminarEstudio(estudio);
    }

    @PostMapping("/eliminarSkill")
    public void eliminarSkil(@RequestBody Skill skill) {
        this.skill.eliminarSkill(skill);
    }
    
    private ResponseEntity refresh(){
        this.token.setTokenDeAcceso(jwtTokenProvider.refreshToken(this.token.getTokenDeAcceso()));
        return ResponseEntity.ok().body(token);
    }
}
