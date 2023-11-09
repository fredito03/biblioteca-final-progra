package usuario;

public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String contrasena;
    private int DPI;

    public Usuario(int id, String nombre, String apellido, String contrasena, int DPI) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.DPI = DPI;
    }

    // generate getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public int getDPI() {
        return DPI;
    }
    public void setDPI(int DPI) {
        this.DPI = DPI;
    }
    // generate toString method
    @Override
    public String toString() {
        return "usuario [apellido=" + apellido + ", contrasena=" + contrasena + ", DPI=" + DPI + ", id=" + id
                + ", nombre=" + nombre + "]";
    }
}
