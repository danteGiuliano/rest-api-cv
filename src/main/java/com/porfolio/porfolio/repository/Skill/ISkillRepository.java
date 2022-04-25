/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.porfolio.repository.Skill;

import com.porfolio.porfolio.model.Skill;
import java.util.List;

/**
 *
 * @author dante
 */
public interface ISkillRepository {
    
    public List<Skill> obtenerSkills();
    public void agregarSkill(Skill skill);
    public void eliminarSkill(Skill skill);
}
