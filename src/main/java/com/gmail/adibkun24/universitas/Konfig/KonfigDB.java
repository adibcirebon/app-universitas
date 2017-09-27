package com.gmail.adibkun24.universitas.Konfig;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;




public class KonfigDB {
    
    private final static String url ="jdbc:postgresql://localhost:5432/postgres";
    private final static String username = "postgres";
    private final static String password ="obed123zr";
    
    public static DataSource getDatasource(){
    BasicDataSource ds = new BasicDataSource();
    ds.setUrl(url);
    ds.setUsername(username);
    ds.setPassword(password);
    return ds;
    
    }
    
    
}
