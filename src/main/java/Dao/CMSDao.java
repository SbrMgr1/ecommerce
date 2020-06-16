package Dao;

import models.CMS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class CMSDao {
    HashMap<Integer, CMS> cmss=new HashMap<>();
    public CMSDao()
    {
    cmss.put(generateId(),new CMS(generateId(),"Abcde1","ssadfg","this si description1"));
    cmss.put(generateId(),new CMS(generateId(),"Abcde2","ssadfg","this si description2"));
    }

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
