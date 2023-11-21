package libro;
import java.util.ArrayList;
import java.util.List;

public class ControladorLibro {

    private List<Libro> librosRegistrados = new ArrayList<>();


    public ControladorLibro(){
        crearLibrosDefault();
    }

    public void crearLibro(Libro libro){
        Libro libroExistente = buscarLibroPorTitulo(libro.getTitulo());
        if(libroExistente != null){
            throw new RuntimeException("El libro ya existe");
        }
        librosRegistrados.add(libro);
    }

    public void eliminarLibro(int id){
        for (Libro libro : librosRegistrados) {
            if(libro.getId() == id){
                librosRegistrados.remove(libro);
                return;
            }
        }
    }

    public List<Libro> obtenerLibros(){
        return librosRegistrados;
    }


    public Libro buscarLibroPorTitulo(String titulo){
        if(librosRegistrados.isEmpty()){
            return null;
        }
        for (Libro libro : librosRegistrados) {
            if(libro.getTitulo().equals(titulo)){
                return libro;
            }
        }
        return null;
    }

    public void imprimirLibros(){
        System.out.println("Libros registrados:");
        if(librosRegistrados.isEmpty()){
            System.out.println(" ---- No hay libros registrados ----");
            return;
        }
        for (Libro libro : librosRegistrados) {
            System.out.println(libro.toString());
        }
    }

    public void crearLibrosDefault(){
        Libro libro1 = new Libro("El señor de los anillos", "J.R.R. Tolkien", "12/20/1954", 500, List.of("accion", "drama", "aventura"), 1431, 10);
        Libro libro2 = new Libro("El hobbit", "J.R.R. Tolkien", "20/10/1937", 300, List.of("accion", "comedia", "aventura"), 24312, 9);
        Libro libro3 = new Libro("El príncipe", "Nicolas Sparks", "10/10/2022", 400, List.of("amor", "drama", "aventura"), 354123, 16);
        librosRegistrados.add(libro1);
        librosRegistrados.add(libro2);
        librosRegistrados.add(libro3);
    }

}
