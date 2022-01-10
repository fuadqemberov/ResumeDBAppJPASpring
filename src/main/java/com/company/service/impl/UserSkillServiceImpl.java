package com.company.service.impl;

import com.company.Entity.UserSkill;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.service.inter.UserSkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserSkillServiceImpl implements UserSkillServiceInter {

    @Autowired
    UserSkillDaoInter dao;

    @Override
    public List<UserSkill> getAllSkillByUserId(int id) {
        return dao.getAllSkillByUserId(id);
    }

    @Override
    public boolean insertUserSkill(UserSkill u) {
        return dao.insertUserSkill(u);
    }

    @Override
    public boolean updateUserSkill(UserSkill u) {
        return dao.updateUserSkill(u);
    }

    @Override
    public boolean removeUser(int id) {
        return dao.removeUserById(id);
    }
}
