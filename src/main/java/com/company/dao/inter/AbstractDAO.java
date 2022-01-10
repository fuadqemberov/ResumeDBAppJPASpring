
package com.company.dao.inter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractDAO {
        private static EntityManagerFactory emf =null;
    
    public EntityManager em(){
        
        if(emf==null){
        emf = Persistence.createEntityManagerFactory("resumePU");
        }
        EntityManager entitymanager = emf.createEntityManager();
    
    
    return entitymanager;
    }
    
    
    public void closeEmf(){
        emf.close();
     
    
    
    }
}
