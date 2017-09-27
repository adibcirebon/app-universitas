package com.gmail.adibkun24.universitas.dao;

import com.gmail.adibkun24.universitas.Konfig.KonfigDB;
import com.gmail.adibkun24.universitas.Model.Jurusan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JurusanDao {

    public List<Jurusan> semuaDataJurusan() {
        List<Jurusan> listJurusan = new ArrayList<>();
        try {
            Connection koneksiDB = KonfigDB.getDatasource().getConnection();
            String sql = "select id, nama from universitas.jurusan";
            Statement s = koneksiDB.createStatement();
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                Jurusan jurusan = new Jurusan();
                jurusan.setId(r.getInt("id"));
                jurusan.setNama(r.getString("nama"));
                listJurusan.add(jurusan);

            }
            r.close();
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(JurusanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listJurusan;
    }

    public void save(Jurusan objJurusan) {
        try {
            Connection koneksiDB = KonfigDB.getDatasource().getConnection();
            String sql = "insert into universitas.jurusan(nama) values (?)";
            PreparedStatement ps = koneksiDB.prepareStatement(sql);
            ps.setString(1, objJurusan.getNama());
           
            ps.executeUpdate();

            ps.close();
            koneksiDB.close();
        } catch (SQLException ex) {
            Logger.getLogger(JurusanDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public Jurusan cariJurusanDenganId(Integer id) {
        try {
            Connection koneksi = KonfigDB.getDatasource().getConnection();
        String sql = "select id, nama from universitas.jurusan where id=?";
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Jurusan jurusan = new Jurusan();
            if(rs.next()){
                jurusan.setId(rs.getInt("id"));
                jurusan.setNama(rs.getString("nama"));
                
            
            }
            return jurusan;
        
        } catch (SQLException ex) {
            Logger.getLogger(JurusanDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public void update(Jurusan objJurusan) {
        try {
            Connection koneksiDB = KonfigDB.getDatasource().getConnection();
            String sql = "update universitas.jurusan set nama = ? where id=?";
            PreparedStatement ps = koneksiDB.prepareStatement(sql);
            ps.setString(1, objJurusan.getNama());
            ps.setInt(2, objJurusan.getId());
            ps.executeUpdate();

            ps.close();
            koneksiDB.close();
        } catch (SQLException ex) {
            Logger.getLogger(JurusanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
 public void hapusDataById(Integer id){
   String sql ="delete from universitas.kelas where id =?";  
 
        try {
            Connection conection = KonfigDB.getDatasource().getConnection();
        PreparedStatement ps = conection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        conection.close();
        } catch (SQLException ex) {
            Logger.getLogger(KelasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
}
