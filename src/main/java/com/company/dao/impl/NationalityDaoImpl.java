/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.Entity.Nationality;
import com.company.dao.inter.NationalityDaoInter;
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
public class NationalityDaoImpl implements NationalityDaoInter {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Nationality> getAll() {
        List<Nationality>  list =new ArrayList<>();
        Query q = em.createQuery("select n from Nationality n",Nationality.class);
        list = q.getResultList();
        return list;

    }

    @Override
    public Nationality getById(int id) {
        Nationality n;
       n = em.find(Nationality.class,id);
        return n;
    }

    @Override
    public boolean updateCountry(Nationality u) {
        em.merge(u);
        return true;
    }

    @Override
    public boolean removeCountry(int id) {
        Nationality n = em.find(Nationality.class,id);
        em.remove(n);
        return false;
    }
}
