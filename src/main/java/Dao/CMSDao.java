package Dao;

import models.CMS;

import java.util.*;

public class CMSDao {
    HashMap<Long, CMS> cmss=new HashMap<Long, CMS>();
    public CMSDao(){

        CMS cms1 = new CMS("About Us","about-us","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        CMS cms2 = new CMS("Terms and Condition","terms-and-conditions","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        CMS cms3 = new CMS("Privacy Policy","privacy-policy","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        CMS cms4= new CMS("FAQ","faq","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
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
