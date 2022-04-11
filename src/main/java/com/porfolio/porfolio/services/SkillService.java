/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.porfolio.services;

import com.porfolio.porfolio.model.Skill;
import com.porfolio.porfolio.repository.Skill.ISkillRepository;
import com.porfolio.porfolio.repository.Skill.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dante
 */
@Service
public class SkillService implements ISkillRepository {
    @Autowired
    private SkillRepository repository;
    @Override
    public List<Skill> obtenerSkills() {
        return this.repository.findAll();
    }

    @Override
    public void agregarSkill(Skill skill) {
        this.repository.save(skill);
    }
    
}
