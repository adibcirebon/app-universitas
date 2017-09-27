package com.gmail.adibkun24.universitas.Controller;

import com.gmail.adibkun24.universitas.dao.JurusanDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/jurusan/delete"})
public class JurusanDeleteController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
        Integer idJurusan = Integer.valueOf(req.getParameter("jurusanId"));
        JurusanDao jurusanDao = new JurusanDao();
        jurusanDao.hapusDataById(idJurusan);
        resp.sendRedirect(req.getServletContext().getContextPath() + "/jurusan/list");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        Integer idJurusan = Integer.valueOf(req.getParameter("jurusanId"));
        JurusanDao jurusanDao = new JurusanDao();
        jurusanDao.hapusDataById(idJurusan);
        resp.sendRedirect(req.getServletContext().getContextPath() + "/jurusan/list");

    }

}
