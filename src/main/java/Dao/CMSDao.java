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
        CMS cms1 = new CMS("About Us","about-us","this si description1");
        CMS cms2 = new CMS("Terms and Condition","terms-and-conditions","this si description1");
        CMS cms3 = new CMS("Privacy Policy","privacy-policy","this si description1");
        CMS cms4= new CMS("FAQ","faq","this si description1");
        cmss.put(cms1.getId(),cms1);
        cmss.put(cms2.getId(),cms2);
        cmss.put(cms3.getId(),cms3);
        cmss.put(cms4.getId(),cms4);
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

    public void deleteCMS(Long id)

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
