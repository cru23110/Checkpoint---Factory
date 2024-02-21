package Users;
import java.io.Serializable;

public abstract class Usuario implements Serializable {
    private String nombre;
    private String apellido;
    private String usuario;
    private String contraseña;
    
    public Usuario(String nombre, String apellido, String usuario, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    public abstract void login();
    
    public abstract void logout();
}
