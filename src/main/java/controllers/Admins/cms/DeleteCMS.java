package controllers.Admins.cms;

import Dao.CMSDao;
import com.google.gson.Gson;
import models.CMS;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/administration/delete")
public class DeleteCMS extends HttpServlet {

    Gson mapper=new Gson();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CMSDao cmsDao = (CMSDao)this.getServletContext().getAttribute("cmsDao");
        String  cmsId = req.getParameter("id");
        System.out.println(cmsId);
        cmsDao.deleteCMS(Long.valueOf(cmsId));
        String data="Successfully Deleted";
        List<CMS> cmss=cmsDao.getAllCMS();
        System.out.println(cmss);
        PrintWriter out = resp.getWriter();
        out.print(mapper.toJson(data));
    }
}
