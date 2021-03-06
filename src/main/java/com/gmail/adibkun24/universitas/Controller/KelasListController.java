
package com.gmail.adibkun24.universitas.Controller;

import com.gmail.adibkun24.universitas.Model.Kelas;
import com.gmail.adibkun24.universitas.dao.KelasDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/kelas/list"})
public class KelasListController  extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //  super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
    
      KelasDao kelasDao = new KelasDao();
      List <Kelas> dataKelas =kelasDao.semuaDataKelas();
      
      
      req.setAttribute("listKelas", dataKelas);
      req.getRequestDispatcher("/pages/kelas/index.jsp"). forward(req, resp);
    }
    

}
