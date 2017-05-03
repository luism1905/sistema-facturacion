/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadisystem.model.BD;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    
    static String bd ="cadif1";
    static String login="root";
    static String password="mysql";
    static String url = "jdbc:mysql://localhost/"+bd;
    public static Connection cn;
    
    public void conectar(){
        
        cn = null;
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, login, password);
        }
        catch(Exception e){
            
        }

    }
    public  void desconectar(){
        cn = null;
        
    }
}
