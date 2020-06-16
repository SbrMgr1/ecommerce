package Dao;

import models.CMS;

import java.util.*;

public class CMSDao {
    HashMap<Long, CMS> cmss=new HashMap<Long, CMS>();
    public CMSDao(){

        CMS cms1 = new CMS("About Us","about-us","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        CMS cms2 = new CMS("Terms and Condition","terms-and-conditions","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        CMS cms3 = new CMS("Privacy Policy","privacy-policy","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        CMS cms4= new CMS("FAQ","faq","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
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
    public CMS findBySlug(String  slug){

        Optional optional = cmss.entrySet().stream().map(Map.Entry::getValue).filter(c -> c.getSlug().equals(slug)).findFirst();
        if(optional.isPresent()){
            return (CMS)optional.get();
        }else{
            return null;
        }
    }

//    public List<CMS> getAboutUs()
//    {
//
//    }



}
