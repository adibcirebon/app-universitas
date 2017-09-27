
package com.gmail.adibkun24.universitas.Controller;

import com.gmail.adibkun24.universitas.Model.Jurusan;
import com.gmail.adibkun24.universitas.dao.JurusanDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/jurusan/list"})
public class JurusanListController  extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //  super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
    
      JurusanDao jurusanDao = new JurusanDao();
      List <Jurusan> dataJurusan =jurusanDao.semuaDataJurusan();
      
      
      req.setAttribute("listJurusan", dataJurusan);
      req.getRequestDispatcher("/pages/jurusan/index.jsp"). forward(req, resp);
    }
    

}
