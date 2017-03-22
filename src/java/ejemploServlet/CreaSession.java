
package ejemploServlet;

import entidades.Camarero;
import entidades.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CreaSession extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            /* El objeto SESSION sirve para recoger el user y el pass o cualquier informacion y poder trasladar
             esa informacion de un apagina a otra*/

            // Creamos una sesion y la asociamos al usuario.
            // Se guardan objetos, listas, variables ...
        HttpSession sesionRestaurante = request.getSession(true);
       
        
        // Este es el objeto, como podia haber sido una lista o variable.
        Camarero ultimoCamarero = new Camarero();
        ultimoCamarero.setIdcamarero("1");
        ultimoCamarero.setNombre("Juan");
        ultimoCamarero.setApellido("Froilan");
       
        // Coloca el objeto en la session.
        // Tenemos que recuperar la sesion (ES UNICA). 
        sesionRestaurante.setAttribute("ejemploSession", ultimoCamarero);
        
        
        PrintWriter pw = response.getWriter();
        pw.println("<html><body>Producto en session");
        pw.println("<h2>" + sesionRestaurante.isNew() + "</h2>");
        pw.close();
    }


@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
        public String getServletInfo() {
        return "Short description";
    }

}
