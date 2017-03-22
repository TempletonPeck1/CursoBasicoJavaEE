
package dao.cocinero.restaurante;

import Utilidades.ConexionRestaurante;
import entidades.Cocinero;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

    // Una clase DAO es una clase de objetos que acceden a datos.
    // En los DAO se hacen los CRUD (Create, Read, Update y Delete).
public class DaoCocinero {
    
    
    public static void insertarCocinero(int idcocinero,String nombre,String apellido) throws ClassNotFoundException, SQLException {
    Connection conexion = ConexionRestaurante.conexionRestaurante();
    Statement sentencia = conexion.createStatement();
    String consultaSQL = "insert into cocinero (idcocinero,nombre,apellido) values ";
    consultaSQL += "('" + idcocinero + "','" + nombre + "','" + apellido + "')";
    sentencia.executeUpdate(consultaSQL);//???????
    sentencia.close();
    conexion.close();//////?????????
}
public static ResultSet verCocineros() throws ClassNotFoundException, SQLException {
    Connection conexion = ConexionRestaurante.conexionRestaurante();
    Statement sentencia = conexion.createStatement();
    String consultaSQL = "select idcocinero,nombre,apellido from cocinero";
    ResultSet lista_cocineros = sentencia.executeQuery(consultaSQL);
    
    return lista_cocineros;
}

// Pasará a ser clase de negocio.
public static void procesarPeticionCocinero(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
    
    // Orientación a objetos.
    Cocinero masterCheff = new Cocinero();
    // Recogemos los datos del formulario.
    masterCheff.setIdcocinero(Integer.parseInt(request.getParameter("idcocinero")));
    masterCheff.setNombre(request.getParameter("nombre"));
    masterCheff.setApellido(request.getParameter("apellido"));
    // Llamamos al método insertarCamarero.
    insertarCocinero(masterCheff.getIdcocinero(),masterCheff.getNombre(),masterCheff.getApellido());
    response.sendRedirect("/Restaurante17Marzo/mostrarServletCocinero");
}
}
