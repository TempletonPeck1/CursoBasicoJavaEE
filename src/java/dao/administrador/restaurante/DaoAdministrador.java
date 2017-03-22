
package dao.administrador.restaurante;

import Utilidades.ConexionRestaurante;
import static dao.camarero.restaurante.DaoCamarero.insertarCamarero;
import entidades.Administrador;
import entidades.Camarero;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Una clase DAO es una clase de objetos que acceden a datos.
// // En los DAO se hacen los CRUD (Create, Read, Update y Delete).

public class DaoAdministrador {
     public static void insertarAdministrador(String usuario, String password, String nombre_administrador,String apellido_administrador) throws SQLException, ClassNotFoundException{
    
    Connection conexion = ConexionRestaurante.conexionRestaurante();
    Statement sentencia = conexion.createStatement();
    String consultaSQL = "insert into logeados (usuario, password, nombre_administrador, apellido_administrador) values ";
    consultaSQL += "('" + usuario + "','" + password + "','" + nombre_administrador + "','" + apellido_administrador + "')";
    int filas = sentencia.executeUpdate(consultaSQL);
    System.out.println("Número de filas insertadas " + filas);
    sentencia.close();
    ConexionRestaurante.cerrarConexion();
    //conexion.close();
}
    // Pasará a ser clase de negocio.
    public static void procesarPeticionAdministrador(HttpServletRequest request,HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {
    // Orientación a objetos.
    Administrador administrador = new Administrador();
    // Recogemos los datos del formulario.
    administrador.setUsuario(request.getParameter("usuario_administrador"));
    administrador.setPassword(request.getParameter("password_administrador"));
    administrador.setNombre_administrador(request.getParameter("nombre_administrador"));
    administrador.setApellido_administrador(request.getParameter("apellido_administrador"));
    // Llamamos al método insertarCamarero.
    insertarAdministrador(administrador.getUsuario(), administrador.getPassword(), administrador.getNombre_administrador(),administrador.getApellido_administrador());
    response.sendRedirect("/Restaurante17Marzo/mostrarServletAdministrador");
}  
}
