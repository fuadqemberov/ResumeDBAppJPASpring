package com.company;

import com.company.Entity.Nationality;
import com.company.Entity.User;
import com.company.dao.impl.UserRepositoryCustomImpl;
import com.company.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserServiceTest {


    @Mock
    UserRepositoryCustomImpl dao;

    @InjectMocks
    UserServiceImpl service;

    @BeforeClass
    public static void setup(){

        System.out.println("before class called");

    }


    @Before
    public void before() {
        System.out.println("before called");

        MockitoAnnotations.initMocks(this);

        System.out.printf("Setup called");
        List<User> list1 = new ArrayList<>();
        User u = new User();
        u.setName("Fuad");
        u.setSurname("Qemberov");
        u.setEmail("fuad@gmail.com");
        u.setNationalityId(new Nationality(1));
        list1.add(u);
        Mockito.when(dao.getAll(null,null,null)).thenReturn(list1);
        Mockito.when(dao.getByEmail(null)).thenReturn(null);
        Mockito.when(dao.getByEmail("fuad@gmail.com")).thenReturn(u);
        Mockito.when(dao.getAll("Fuad","Qemberov",null)).thenReturn(list1);
        Mockito.when(dao.getById(2)).thenReturn(u);
        Mockito.when(dao.getById(null)).thenReturn(null);
        Mockito.when(dao.findByEmail(null)).thenReturn(null);
        Mockito.when(dao.findByEmail("fuad@gmail.com")).thenReturn(u);

    }




	@Test
  public void testGivenNullThenGetAll() {

       List<User> list = service.getAll(null,null,null);

       Assert.assertEquals("User sayi 1 olmalidir",1,list.size());

       User user = list.get(0);
        Assert.assertEquals("Userin adi sehvdir","Fuad",user.getName());
        Assert.assertEquals("Userin soyadi sehvdir","Qemberov",user.getSurname());

        Mockito.verify(dao,Mockito.atLeastOnce()).getAll(null,null,null);

	}


	@Test
    public void testGivenAllParamsThenGetAllByFilter(){

        List<User> list = service.getAll("Fuad","Qemberov",null);

        Assert.assertTrue("User sayi 0 dan  cox olmalidir",list.size()>0);
     Mockito.verify(dao,Mockito.atLeastOnce()).getAll("Fuad","Qemberov",null);

    }



    @Test
    public void testGivenIdThenreturnUser(){

        User u = service.getById(2);
        Assert.assertEquals("Fuad",u.getName());


    }

    @Test

    public void testGivenNullReturnNull(){

        User u = service.getById(null);
        Assert.assertNull(u);
        Mockito.verify(dao,Mockito.atLeastOnce()).getById(null);
    }


    @Test
    public void testGivenNullEmailthenReturnNull(){

        User u = service.getByEmail(null);

        Assert.assertNull(u);
        Mockito.verify(dao,Mockito.atLeastOnce()).getByEmail(null);
    }

    @Test
    public void testGivenParamEmailthenReturnUser(){

        User u = service.getByEmail("fuad@gmail.com");

        Assert.assertNotNull(u);
        Mockito.verify(dao,Mockito.atLeastOnce()).getByEmail("fuad@gmail.com");
    }





}
