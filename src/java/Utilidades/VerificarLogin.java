
package Utilidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class VerificarLogin {
   
    public static boolean comprobarLogin(String usuario,String password) throws ClassNotFoundException, SQLException {
        
        boolean nRegistro = false;
        String sql = "select * from logeados where usuario = '"+ usuario +"' AND password = '"+ password +"'";
        Connection con = ConexionRestaurante.conexionRestaurante();
        PreparedStatement comprobarLogin = con.prepareStatement(sql);
        
        // Las executeQuery devuelven conjuntos de resultados (Columnas,etc...)
        // Las executeQuery se usan SOLO cuando se hace un select.
        ResultSet rs = comprobarLogin.executeQuery(sql); 
        
        if(rs.next()) {
            // Si devuelve resultados el login es correcto.
            nRegistro = true;
        }

        return nRegistro;
    }  
}