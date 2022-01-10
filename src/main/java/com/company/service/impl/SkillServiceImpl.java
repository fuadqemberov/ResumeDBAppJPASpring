package com.company.service.impl;

import com.company.Entity.Skill;
import com.company.dao.inter.SkillDaoInter;
import com.company.service.inter.SkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SkillServiceImpl implements SkillServiceInter {

    @Autowired
    SkillDaoInter dao;

    @Override
    public List<Skill> getAll() {
        return dao.getAll();
    }

    @Override
    public Skill getById(int id) {
        return dao.getById(id);
    }

    @Override
    public boolean updateSkill(Skill u) {
        return dao.updateSkill(u);
    }

    @Override
    public boolean removeSkill(int id) {
        return dao.removeSkill(id);
    }



    @Override
    public boolean insertSkill(Skill skl) {
        return dao.insertSkill(skl);
    }
}
