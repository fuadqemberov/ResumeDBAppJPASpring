
package com.company.dao.impl;

import com.company.Entity.User;
import java.util.List;

/**
 *
 * @author Fuad
 */
public interface UserRepositoryCustom {
    
      public List<User> getAll(String name,String surname,Integer id);
    
    public User getById(Integer id);
    
    public User getByEmail(String email);

    
    public boolean addUser(User u);
    
    public boolean removeUserById(int id);
    
    public boolean updateUser(User u);
    
     public User findByEmail(String email);
    
    
    
}
