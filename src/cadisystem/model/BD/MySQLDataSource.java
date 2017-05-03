/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.model.BD;

import static cadisystem.model.BD.Conexion.*;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.sql.DataSource;
/**
 *
 * @author carlos
 */
public class MySQLDataSource {

    
    public static DataSource getDS(){
        
     MysqlDataSource ds = null;
    try{
        
    ds = new MysqlDataSource();        
    ds.setURL(url);
    ds.setUser(login);
    ds.setPassword(password);
    }catch(Exception e){
    
}
    return ds;
        
    }
    
    
}
