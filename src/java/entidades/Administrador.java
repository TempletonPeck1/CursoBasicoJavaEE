
package entidades;


public class Administrador {
    
    private int idAdministrador;
    private String usuario;
    private String password;
    private String nombre_administrador;
    private String apellido_administrador;
    
    

    public Administrador(String nombre_administrador, String apellido_administrador, String usuario, String password) {
        
        this.usuario = usuario;
        this.password = password;
        this.nombre_administrador = nombre_administrador;
        this.apellido_administrador = apellido_administrador;
    }

    public Administrador() {
    }
    
    

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getNombre_administrador() {
        return nombre_administrador;
    }

    public void setNombre_administrador(String nombre_administrador) {
        this.nombre_administrador = nombre_administrador;
    }

    public String getApellido_administrador() {
        return apellido_administrador;
    }

    public void setApellido_administrador(String apellido_administrador) {
        this.apellido_administrador = apellido_administrador;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
