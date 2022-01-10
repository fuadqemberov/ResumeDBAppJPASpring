package com.company.dao.impl;

import com.company.Entity.UserSkill;
import com.company.dao.inter.UserSkillDaoInter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserSkillDaoImpl implements UserSkillDaoInter {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<UserSkill> getAllSkillByUserId(int id) {

        List<UserSkill> list = new ArrayList<>();
        Query q = em.createNativeQuery("select * from userskill where user_id=id");
        list = q.getResultList();

        return list;
    }

    @Override
    public boolean insertUserSkill(UserSkill u) {
        em.persist(u);
        return true;
    }

    @Override
    public boolean updateUserSkill(UserSkill u) {
        em.merge(u);
        return true;
    }

    @Override
    public boolean removeUserById(int id) {
        Query q =em.createNativeQuery("delete * from userskill where user_id=id ");
        return true;
    }
}
