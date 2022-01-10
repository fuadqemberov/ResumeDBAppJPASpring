
package com.company.dao.inter;

import com.company.Entity.Nationality;
import java.util.List;

/**
 *
 * @author Fuad
 */
public interface NationalityDaoInter {
    
    List<Nationality> getAll();
     
    public Nationality getById(int id);
     
    boolean updateCountry(Nationality u);
     
    boolean removeCountry(int id);
}
