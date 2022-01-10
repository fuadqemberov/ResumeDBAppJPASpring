/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Fuad
 */

@Repository("daoimpl")
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    
    @PersistenceContext
    EntityManager em;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


        @Autowired
        private PasswordEncoder passwordEncoder;
    
    
    public List<User> getAll(String name, String surname, Integer id) {

        List<User> list = new ArrayList<>();

       String jpql = "select u from User u where 1=1";

        
         if(name!=null && !name.trim().isEmpty()){
                jpql += " and u.name=:name ";
            }

            if(surname!=null && !surname.trim().isEmpty()){
                jpql += " and u.surname=:surname ";
            }

            if(id!=null){
               jpql += " and u.id =:id" ;
            }
           
            
            Query query =  em.createQuery(jpql ,User.class);
          
            
            int i=1;
            if(name!=null && !name.trim().isEmpty()){
               query.setParameter("name", name);
                i++;//2
            }

            if(surname!=null && !surname.trim().isEmpty()){
                query.setParameter("surname", surname);
                i++;//3
            }

            if(id!=null){
              query.setParameter("id", id);
            }

             list = query.getResultList();
             return list;
    }

    public User getById(Integer id) {
        User u =em.find(User.class, id);
    return u;
    }

    public User getByEmail(String email) {
        User t1 = new User();
       Query q2 =em.createQuery("select u from User u where u.email LIKE :email");
        q2.setParameter("email",email);


        List<User> list = q2.getResultList();
        if(list.size() == 1){
            t1 =(User)list.get(0);
            return  t1;

        }

 return t1;
        
    }

//    public User findByEmailAndPassword(String email, String password) {
//  Query q = em.createNativeQuery("select * from resume where email=? ,password=?");
//        q.setParameter(1,email);
//        q.setParameter(2,password);
//
//
//        List<User> list = q.getResultList();
//
//        if(list.size() ==1){
//        return list.get(0);
//        }
//
//        return null;
//
//    }

    
      
    public boolean addUser(User u) {
   u.setPassword(passwordEncoder.encode(u.getPassword()));
        em.persist(u);
        return true;
    }

    public boolean removeUserById(int id) {
User u = em.find(User.class, id);
   em.remove(u);

return true;
    }

    public boolean updateUser(User u) {
        if(u!=null){
           User u2 = em.merge(u);

           if(u2!=null){
               return true;
           }
        }

        return false;
    }

    public User findByEmail(String email) {
User u = em.find(User.class, email);
return u;
    }



//    User t1 = new User();
//        Query q2 =em.createNativeQuery("SELECT * FROM user WHERE email=?");
//        q2.setParameter(1,email);
//
//
//        List<User> list = q2.getResultList();
//        if(list.size() == 1){
//            t1 =(User)list.get(0);
//            return  t1;
//
//        }
//
//        return t1;

}
