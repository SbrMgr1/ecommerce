package Dao;

import models.CMS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class CMSDao {
    HashMap<Long, CMS> cmss=new HashMap<Long, CMS>();
    public CMSDao()
    {
        CMS cms1 = new CMS("Abcde1","ssadfg","this si description1");
        cmss.put(cms1.getId(),cms1);
    }

    public  void addCMS(CMS cms)
    {
        System.out.println(cms);
        cmss.put(cms.getId(),cms);
    }
    public Long generateId() {

        return Long.valueOf(cmss.size())+1;
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
