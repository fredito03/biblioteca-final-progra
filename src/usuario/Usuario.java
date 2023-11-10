package usuario;

import enums.Rol;

public class Usuario {
    private int ultimoIdUsuario = 0;
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String DPI;
    private Rol rol;


    public Usuario(String nombre, String correo, String apellido, String contrasena, String DPI, Rol rol) {
        this.id = ultimoIdUsuario += 1;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.DPI = DPI;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getDPI() {
        return DPI;
    }
    public void setDPI(String DPI) {
        this.DPI = DPI;
    }
    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    @Override
    public String toString() {
        return "Id: " + id + "Nombre: " +  nombre + " Apellido: " + apellido + " DPI:" + DPI + " Rol: " + rol;
    }
}
