/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.adibkun24.universitas.Controller;

import com.gmail.adibkun24.universitas.Model.Jurusan;
import com.gmail.adibkun24.universitas.dao.JurusanDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADIB PC
 */
@WebServlet (urlPatterns={"/jurusan/new"})
public class JurusanAddFormController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //   super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    Jurusan jurusanBaru= new Jurusan();
    
    jurusanBaru.setNama(req.getParameter("jurusanName"));
  
    
    JurusanDao jurusanDao = new JurusanDao();
    jurusanDao.save(jurusanBaru);
       
    resp.sendRedirect(req.getServletContext().getContextPath()+"/jurusan/list");
    }
   
}
