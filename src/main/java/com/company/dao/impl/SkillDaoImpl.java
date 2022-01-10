/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.Entity.Skill;
import com.company.dao.inter.SkillDaoInter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fuad
 */
@Repository
public class SkillDaoImpl implements SkillDaoInter {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Skill> getAll() {
        List<Skill> list = new ArrayList<>();
        Query q = em.createQuery("select s from Skill s",Skill.class);
        list = q.getResultList();
        return list;
    }

    @Override
    public Skill getById(int id) {
        Skill s = em.find(Skill.class,id);
        return s;
    }

    @Override
    public boolean updateSkill(Skill u) {
        em.merge(u);

        return true;
    }

    @Override
    public boolean removeSkill(int id) {
        Skill s = em.find(Skill.class,id);
        em.remove(s);
        return true;
    }


    @Override
    public boolean insertSkill(Skill skl) {
       em.persist(skl);
        return true;
    }
}
