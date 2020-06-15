package controllers.Admins;

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

@WebServlet("/administration/cms-managent")
public class ContentManage extends HttpServlet {
    private CMSDao cmsDao;
    Gson mapper=new Gson();

    @Override
    public void init(ServletConfig config) throws ServletException {
        cmsDao=new CMSDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("/WEB-INF/views/admins/cms.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cmsString=req.getParameter("cms");
        CMS cms=mapper.fromJson(cmsString, CMS.class);
        cms.setId(cmsDao.generateId());
        cmsDao.addCMS(cms);
        PrintWriter out = resp.getWriter();
        out.print(mapper.toJson(cms));
    }


}
