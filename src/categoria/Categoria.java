public class Categoria {
    private int id;
    private String nombre;
    private String ubicacion;

    public Categoria(int id, String nombre, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Ubicación: " + ubicacion;
    }
}
