package com.company;


import com.company.Entity.User;

import com.company.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
public class UserDaoImplIT {


    @Autowired

    UserServiceImpl repo;






    @Test
    public void testGetAll(){

        List<User> list = repo.getAll(null,null,null);
        Assert.assertEquals("User sayi 3 olmalidir",3,list.size());

    }

//    @Test
//    public void testinsert(){
//
//        User u = new User();
//        Nationality n = new Nationality(1);
//        u.setNationalityId(n);
//        u.setName("Leyla");
//        u.setSurname("Qemberli");
//        u.setEmail("leyla@gmail.com");
//        u.setPassword("12345");
//
//        boolean b = repo.addUser(u);
//        System.out.println(b);
//        Assert.assertTrue(b);
//
//    }

    @Test
    public void testUpdate(){

        User u =null;
        boolean b = repo.updateUser(u);
        System.out.println(b);
        Assert.assertTrue(!b);


    }

    @Test
    public void testGivenNullEmail2thenReturnNull(){

        User u = repo.findByEmail(null);

        Assert.assertNull(u);

    }

    @Test
    public void testGivenParamEmail2ReturnUser(){

        User u = repo.findByEmail("fuad@gmail.com");

        Assert.assertNotNull(u);

    }



}
