package com.company.service.impl;

import com.company.Entity.Nationality;
import com.company.dao.inter.NationalityDaoInter;
import com.company.service.inter.NationalityServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NationalityServiceImpl implements NationalityServiceInter {

    @Autowired
    NationalityDaoInter dao;

    @Override
    public List<Nationality> getAll() {
        return dao.getAll();
    }

    @Override
    public Nationality getById(int id) {
        return dao.getById(id);
    }

    @Override
    public boolean updateCountry(Nationality u) {
        return dao.updateCountry(u);
    }

    @Override
    public boolean removeCountry(int id) {
        return dao.removeCountry(id);
    }
}
