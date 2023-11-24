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

    public void actualizarLibro(int idLibro, Libro nuevosDatos){
        Libro libro = obtenerLibroPorId(idLibro);
        if(libro != null){
            libro.setTitulo(nuevosDatos.getTitulo());
            libro.setAutor(nuevosDatos.getAutor());
            libro.setFechaPublicacion(nuevosDatos.getFechaPublicacion());
            libro.setNumPaginas(nuevosDatos.getNumPaginas());
            libro.setCategorias(nuevosDatos.getCategorias());
            libro.setEtiqueta(nuevosDatos.getEtiqueta());
            libro.setNumCopias(nuevosDatos.getNumCopias());
        }else{
            System.out.println("El libro no existe o no pudimos encontrarlo, por favor intenta con un id de la lista");
        }

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

    public int obtenerUltimoId(){
        if(librosRegistrados.isEmpty()){
            return 0;
        }
        return librosRegistrados.get(librosRegistrados.size() - 1).getId();
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


    public Libro obtenerLibroPorId(int id){
        for (Libro libro : librosRegistrados) {
            if(libro.getId() == id){
                return libro;
            }
        }
        return null;
    }

    public void crearLibrosDefault(){
        Libro libro1 = new Libro(1, "El señor de los anillos", "J.R.R. Tolkien", "12/20/1954", 500, List.of("accion", "drama", "aventura"), 1431, 1);
        Libro libro2 = new Libro(2, "El hobbit", "J.R.R. Tolkien", "20/10/1937", 300, List.of("accion", "comedia", "aventura"), 24312, 2);
        Libro libro3 = new Libro(3, "El príncipe", "Nicolas Sparks", "10/10/2022", 400, List.of("amor", "drama", "aventura"), 354123, 3);
        librosRegistrados.add(libro1);
        librosRegistrados.add(libro2);
        librosRegistrados.add(libro3);
    }

}
