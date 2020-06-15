package Dao;

import models.CMS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class CMSDao {
    HashMap<Integer, CMS> cmss=new HashMap<>();

    public  void addCMS(CMS cms)
    {
        cmss.put(generateId(),cms);
    }
    public Integer generateId() {
        return cmss.size()+1;
    }


    public CMS findCMSById(int  id)
    {
     return(cmss.get(id));
    }

    public void deleteProduct(int id)
    {
        cmss.remove(id);
    }

    public void updateProduct(CMS cms){
        cmss.put(cms.getId(), cms);
    }

    public List<CMS> getAllProducts(){
        return new ArrayList<>(cmss.values());
    }



}
