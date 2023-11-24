package categoria;
public class Categoria {
    private static int ultimoIdUsuario = 0;
    private int id;
    private String nombre;
    private String ubicacion;

    public Categoria(String nombre, String ubicacion) {
        this.id = ++ultimoIdUsuario;
        this.nombre = nombre.toLowerCase();
        this.ubicacion = ubicacion;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getUbicacion() {
        return ubicacion;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Ubicación: " + ubicacion;
    }
}
