package controllers.Admins.cms;

import Dao.CMSDao;
import models.CMS;
import com.google.gson.Gson;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/administration/cms-managent")
public class ContentManage extends HttpServlet {

    Gson mapper=new Gson();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CMSDao cmsDao = (CMSDao)this.getServletContext().getAttribute("cmsDao");
        List<CMS> cmss= cmsDao.getAllCMS();
        req.setAttribute("cms",cmss);
       req.getRequestDispatcher("/WEB-INF/views/admins/cms.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CMSDao cmsDao = (CMSDao)this.getServletContext().getAttribute("cmsDao");
        String cmsString=req.getParameter("cms");
        System.out.println(cmsString);
        CMS cms=mapper.fromJson(cmsString, CMS.class);

        cmsDao.addCMS(cms);
        PrintWriter out = resp.getWriter();
        out.print(mapper.toJson(cms));
    }



}
