package prestamos;

import libro.ControladorLibro;
import libro.Libro;

import java.util.ArrayList;
import java.util.List;


public class ControladorPrestamos {
    private List<Prestamo> prestamos = new ArrayList<>();
    ControladorLibro controladorLibro = new ControladorLibro();


    public void prestarLibro(int idLibro, int idUsuario){
        Prestamo prestamo = new Prestamo(idLibro, idUsuario, false);
        Boolean prestamoValido = verificarSiLibroPuedePrestarse(prestamo);
        Libro libro = controladorLibro.obtenerLibroPorId(prestamo.getIdLibro());
        if(prestamoValido){
            prestamo.setPrestado(true);
            libro.setNumCopiasDisponibles(libro.getNumCopiasDisponibles() - 1);
            prestamos.add(prestamo);
            System.out.println("El libro " + libro.getTitulo() + " ha sido prestado tienes hasta el " + prestamo.getFechaVencimiento() + " para devolver el libro");
            System.out.println("Que lo disfrutes!!");
        }else{
            System.out.println("El libro " + libro.getTitulo() + " no puede ser prestado, ya que no hay mas copias disponibles" + "(" + libro.getNumCopiasDisponibles() + "/" + libro.getNumCopias() + ")");
            System.out.println("Intenta con otro libro");
        }
    }

    public void devolverLibro(int idLibro){
        Libro libro = controladorLibro.obtenerLibroPorId(idLibro);
        for (Prestamo prestamo : prestamos) {
            if(prestamo.getIdLibro() == idLibro & prestamo.getPrestado()){
                prestamo.setPrestado(false);
                libro.setNumCopiasDisponibles(libro.getNumCopiasDisponibles() + 1);
                prestamos.remove(prestamo);
            }
        }
        System.out.println("El libro " + libro.getTitulo() + " ha sido devuelto");
    }

    public List<Prestamo> obtenerLibrosPrestadosPorUsuario(int idUsuario){
        List<Prestamo> prestamosUsuario = new ArrayList<>();
        for (Prestamo prestamo : prestamos) {
            if(prestamo.getIdUsuario() == idUsuario & prestamo.getPrestado()){
                prestamosUsuario.add(prestamo);
            }
        }
        return prestamosUsuario;
    }

    public void imprimirLibrosPrestadosPorUsuario(int idUsuario){
        List<Prestamo> prestamosUsuario = obtenerLibrosPrestadosPorUsuario(idUsuario);
        System.out.println("--- Libros Prestados ---");
        for (Prestamo libroPrestado: prestamosUsuario) {
            System.out.println(libroPrestado.toString());
        }
    }

    private Boolean verificarSiLibroPuedePrestarse(Prestamo prestamo){
        Libro libro = controladorLibro.obtenerLibroPorId(prestamo.getIdLibro());
        if (libro != null){
            int totalCopias = libro.getNumCopias();
            int totalCopiasDisponibles = libro.getNumCopiasDisponibles();
            Boolean prestamoValido = totalCopiasDisponibles > 0;
            return prestamoValido;
        }else{
            throw new Error("No se encontro el libro con el id " + prestamo.getIdLibro() + " en la base de datos");
        }

    }


}
