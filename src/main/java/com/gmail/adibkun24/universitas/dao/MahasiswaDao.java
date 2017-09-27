package com.gmail.adibkun24.universitas.dao;

import com.gmail.adibkun24.universitas.Konfig.KonfigDB;
import com.gmail.adibkun24.universitas.Model.Jurusan;
import com.gmail.adibkun24.universitas.Model.Kelas;
import com.gmail.adibkun24.universitas.Model.Mahasiswa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MahasiswaDao {

    public List<Mahasiswa> semuaDataMahasiswa() throws SQLException {
        List<Mahasiswa> listMahasiswa = new ArrayList<>();

        String sql = "select mhs.id as id_mahasiswa,\n"
                + "mhs.nama as nama_mahasiswa,\n"
                + "mhs.nim as nim_mahasiswa,\n"
                + "kelas.id as id_kelas,\n"
                + "kelas.nama as nama_kelas,\n"
                + "kelas.angkatan as angkatan_kelas,\n"
                + "jur.id as id_jurusan,\n"
                + "jur.nama as nama_jurusan\n"
                + "from universitas.mahasiswa mhs join universitas.kelas on (mhs.kls = kelas.id) "
                + "join universitas.jurusan jur on (jur.id = mhs.jurusan)";
        try {
            Connection connection = KonfigDB.getDatasource().getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Mahasiswa mhs = new Mahasiswa();
                mhs.setId(rs.getInt("id_mahasiswa"));
                mhs.setNama(rs.getString("nama_mahasiswa"));
                mhs.setNim(rs.getString("nim_mahasiswa"));

                Jurusan jur = new Jurusan();
                jur.setId(rs.getInt("id_jurusan"));
                jur.setNama(rs.getString("nama_jurusan"));
                mhs.setJurusan(jur);

                Kelas kelas = new Kelas();
                kelas.setId(rs.getInt("id_kelas"));
                kelas.setNama(rs.getString("nama_kelas"));
                kelas.setAngkatan(rs.getInt("angkatan_kelas"));
                mhs.setKelas(kelas);

                listMahasiswa.add(mhs);

            }

            rs.close();
            st.close();
            connection.close();
            
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return listMahasiswa;
    }

    public void simpanMahasiswa(Mahasiswa mhs){
    String sql = "insert into universitas.mahasiswa (id, nim, nama, kelas,jurusan) values (nextvalue('mahasiswa_id_seq'),?,?,?,?)";
    
    Connection connection;
        try {
            connection = KonfigDB.getDatasource().getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, mhs.getNim());
        ps.setString(2, mhs.getNama());
        ps.setInt(3, mhs.getKelas().getId());
        ps.setInt(4, mhs.getJurusan().getId());
        ps.executeUpdate();
        
        ps.close();
        connection.close();
        } catch (SQLException error) {
            error.printStackTrace();
        }
        
    
}


}
