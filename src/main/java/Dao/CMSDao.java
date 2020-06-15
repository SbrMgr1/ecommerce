package Dao;

import models.CMS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class CMSDao {
    public CMSDao()
    {

    }
    HashMap<Integer, CMS> cmss=new HashMap<>();

    public  void addCMS(CMS cms)
    {
        System.out.println(cms);
        cmss.put(generateId(),cms);
    }
    public Integer generateId() {

        return cmss.size()+1;
    }


    public CMS findCMSById(int  id)
    {
     return(cmss.get(id));
    }

    public void deleteCMS(int id)
    {
        cmss.remove(id);
    }

    public void updateCMS(CMS cms){
        cmss.put(cms.getId(), cms);
    }

    public List<CMS> getAllCMS(){
        return new ArrayList<>(cmss.values());
    }



}
