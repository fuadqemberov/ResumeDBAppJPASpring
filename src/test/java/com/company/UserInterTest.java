package com.company;

import com.company.Entity.User;
import com.company.dao.impl.UserRepositoryCustom;
import com.company.service.inter.UserServiceInter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class UserInterTest {

    @InjectMocks
    UserRepositoryCustom cus;
@Mock
    UserServiceInter inter;


    @Before

    public void before(){
        List<User> list = new ArrayList<>();
        User u = new User();
        u.setName("fuad");
        list.add(u);


        Mockito.when(cus.getAll(null,null,null)).thenReturn(list);

    }


    @Test
    public void getAllTest(){

 List<User> list =  cus.getAll(null,null,null);
        Mockito.verify(cus,Mockito.atLeastOnce()).getAll(null,null,null);

    }

}
