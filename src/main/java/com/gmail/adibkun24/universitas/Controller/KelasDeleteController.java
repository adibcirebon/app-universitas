package com.gmail.adibkun24.universitas.Controller;

import com.gmail.adibkun24.universitas.dao.KelasDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/kelas/delete"})
public class KelasDeleteController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
        Integer idKelas = Integer.valueOf(req.getParameter("kelasId"));
        KelasDao kelasDao = new KelasDao();
        kelasDao.hapusDataById(idKelas);
        resp.sendRedirect(req.getServletContext().getContextPath() + "/kelas/list");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        Integer idKelas = Integer.valueOf(req.getParameter("kelasId"));
        KelasDao kelasDao = new KelasDao();
        kelasDao.hapusDataById(idKelas);
        resp.sendRedirect(req.getServletContext().getContextPath() + "/kelas/list");

    }

}
