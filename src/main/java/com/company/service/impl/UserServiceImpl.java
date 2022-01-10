/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.impl;


import com.company.Entity.User;
import com.company.dao.impl.UserRepositoryCustom;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 *
 * @author Fuad
 */
@Service("serviceimpl")
@Transactional
public class UserServiceImpl implements UserServiceInter {

    @Autowired
    @Qualifier("daoimpl")
    UserRepositoryCustom dao;

    @Override
    public List<User> getAll(String name, String surname, Integer id) {
        return dao.getAll(name,surname,id);
    }

    @Override
    public User getById(Integer id) {
        return null;
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public boolean addUser(User u) {
      return dao.addUser(u);
    }

    @Override
    public boolean removeUserById(int id) {
        return false;
    }

    @Override
    public boolean updateUser(User u) {
        return false;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }
}
