
package ejemploServlet;

import Utilidades.VerificarLogin;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// Aqui se creea la sesion y comprueba que el usuario este logueado en el restode servlets
public class LogRestaurante extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        
        /*Recogemos parametros del formulario de LOGIN.html*/
        String user_login = request.getParameter("login_usuario");
        String pass_login = request.getParameter("login_password");
        
        boolean verificarUsuario = VerificarLogin.comprobarLogin(user_login, pass_login);
        
        if (verificarUsuario == true) {
            // Esta variable nos sirve para comprobar si el usuario está logeado en otros servlets.
            boolean log = true;
            HttpSession sesion_login = request.getSession();
        // Guardo en la sesion
        sesion_login.setAttribute("login_usuario", user_login);
        sesion_login.setAttribute("login_password", pass_login);
        sesion_login.setAttribute("ok", log);
            
            response.sendRedirect("/Restaurante17Marzo/altas.htm");
            
        }else {
            response.sendRedirect("/Restaurante17Marzo/login.html");
        }
        }
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogRestaurante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LogRestaurante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogRestaurante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LogRestaurante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
