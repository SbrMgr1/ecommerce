package controllers.Guests;

import Dao.CMSDao;
import models.CMS;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/page/*")
public class Page extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String[] segments = uri.split("/page/");
        
        CMSDao cmsDao = (CMSDao)this.getServletContext().getAttribute("cmsDao");
        CMS cms = cmsDao.findBySlug(segments[1]);
        req.setAttribute("cms",cms);
        req.getRequestDispatcher("/WEB-INF/views/page.jsp").forward(req,resp);
    }
}
