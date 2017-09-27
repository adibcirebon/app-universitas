package com.gmail.adibkun24.universitas.Controller;

import com.gmail.adibkun24.universitas.Model.Jurusan;
import com.gmail.adibkun24.universitas.dao.JurusanDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/jurusan/update"})
public class JurusanUpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.

        Jurusan jurusan = new Jurusan();
        jurusan.setId(Integer.valueOf(req.getParameter("id")));

        JurusanDao jurusanDao = new JurusanDao();
        jurusan = jurusanDao.cariJurusanDenganId(jurusan.getId());

        req.setAttribute("j", jurusan);
        req.getRequestDispatcher("/pages/jurusan/updateJurusan.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.

        Jurusan jurusanBaru = new Jurusan();
        jurusanBaru.setId(Integer.valueOf(req.getParameter("jurusanId")));
        jurusanBaru.setNama(req.getParameter("jurusanName"));
 

        JurusanDao jurusanDao = new JurusanDao();
        jurusanDao.update(jurusanBaru);
        
        resp.sendRedirect(req.getServletContext().getContextPath () +"/jurusan/list");

    }

}
