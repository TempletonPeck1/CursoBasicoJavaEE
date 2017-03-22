
package dao.camarero.restaurante;

import Utilidades.ConexionRestaurante;
import entidades.Camarero;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Una clase DAO es una clase de objetos que acceden a datos.
// En los DAO se hacen los CRUD (Create, Read, Update y Delete).
public class DaoCamarero {
    public static void insertarCamarero(String idcamarero,String nombre,String apellido) throws SQLException, ClassNotFoundException{
    
    Connection conexion = ConexionRestaurante.conexionRestaurante();
    Statement sentencia = conexion.createStatement();
    String consultaSQL = "insert into camarero (idcamarero,nombre,apellido) values ";
    consultaSQL += "('" + idcamarero + "','" + nombre + "','" + apellido + "')";
    int filas = sentencia.executeUpdate(consultaSQL);
    System.out.println("Número de filas insertadas " + filas);
    sentencia.close();
    ConexionRestaurante.cerrarConexion();
    //conexion.close();
}
    public static ResultSet verCamareros() throws ClassNotFoundException, SQLException{
    
      Connection conexion = ConexionRestaurante.conexionRestaurante();
      Statement sentencia = conexion.createStatement();
      String consultaSQL = "select idcamarero,nombre,apellido from camarero";
      ResultSet lista_camareros = sentencia.executeQuery(consultaSQL);
      ConexionRestaurante.cerrarConexion();
      return lista_camareros;
    
    
}
    // Pasará a ser clase de negocio.
    public static void procesarPeticionCamarero(HttpServletRequest request,HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {
    // Orientación a objetos.
    Camarero camarero = new Camarero();
    // Recogemos los datos del formulario.
    camarero.setIdcamarero(request.getParameter("idcamarero"));
    camarero.setNombre(request.getParameter("nombre"));
    camarero.setApellido(request.getParameter("apellido"));
    // Llamamos al método insertarCamarero.
    insertarCamarero(camarero.getIdcamarero(), camarero.getNombre(), camarero.getApellido());
    response.sendRedirect("/Restaurante17Marzo/mostrarServletCamarero");
} 
    // Faltan métodos update y delete.
}
