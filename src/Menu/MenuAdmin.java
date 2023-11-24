package Menu;
import categoria.Categoria;
import categoria.ControladorCategoria;
import libro.ControladorLibro;
import libro.Libro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuAdmin {

    private Scanner entrada = new Scanner(System.in);
    private ControladorLibro controladorLibro = new ControladorLibro();

    private ControladorCategoria controladorCategoria = new ControladorCategoria();
    public void mostrarMenu(){
        System.out.println("--- MENU ---");
        System.out.println("1. Agregar Libro");
        System.out.println("2. Actualizar Libro");
        System.out.println("3. Eliminar Libro");
        System.out.println("4. Agregar Categoria");
        System.out.println("5. Eliminar Categoria");
        System.out.println("6. Salir");
        int opcion = entrada.nextInt();
        entrada.nextLine();
        switch (opcion) {
            case 1:
                agregarLibro();
                mostrarMenu();
                break;
            case 2:
                actualizarLibro();
                mostrarMenu();
                break;
            case 3:
                eliminarLibro();
                mostrarMenu();
                break;
            case 4:
                agregarCategoria();
                mostrarMenu();
                break;
            case 5:
                eliminarCategoria();
                mostrarMenu();
                break;
            case 6:
                salir();
                break;
            default:
                System.out.println("Opcion invalida");
                mostrarMenu();
                break;
        }
    }

    private Libro pedirDatosParaNuevoLibro() {
        List<String> categorias = new ArrayList<>();
        String decision = "si";
        System.out.println("Ingrese el titulo del libro");
        String titulo = entrada.nextLine();
        System.out.println("Ingrese el autor del libro");
        String autor = entrada.nextLine();
        System.out.println("Ingrese la fecha de publicacion del libro");
        String fechaPublicacion = entrada.nextLine();
        System.out.println("Ingrese el numero de paginas del libro");
        int numPaginas = entrada.nextInt();
        entrada.nextLine();
        controladorCategoria.imprimirCategorias();
        System.out.println("Ingrese la categoria del libro");
        while(decision.equals("si")){
            System.out.println("Ingrese el nombre de la categoria del libro");
            String nombreCategoria = entrada.nextLine().toLowerCase();
            if(categorias.contains(nombreCategoria)){
                System.out.println("La categoria ya existe dentro libro");
                continue;
            }
            categorias.add(nombreCategoria);
            System.out.println("¿Desea continuar agregando categorias?");
            decision = entrada.nextLine().toLowerCase();
        }
        System.out.println("Ingrese la etiqueta del libro");
        int etiqueta = entrada.nextInt();
        System.out.println("Ingrese el numero de copias del libro");
        int numCopias = entrada.nextInt();
        int id = controladorLibro.obtenerUltimoId() + 1;
        Libro nuevoLibro = new Libro(id, titulo, autor, fechaPublicacion, numPaginas, categorias, etiqueta, numCopias);
        return nuevoLibro;
    }

    public void agregarLibro(){
        controladorLibro.imprimirLibros();
        Libro nuevoLibro = pedirDatosParaNuevoLibro();
        controladorLibro.crearLibro(nuevoLibro);
        controladorLibro.imprimirLibros();
    }

    public void actualizarLibro(){
        controladorLibro.imprimirLibros();
        System.out.println("Ingrese el id del libro a actualizar");
        int idLibro = entrada.nextInt();
        entrada.nextLine();
        Libro nuevoLibro = pedirDatosParaNuevoLibro();
        controladorLibro.actualizarLibro(idLibro, nuevoLibro);
        controladorLibro.imprimirLibros();
    }

    public void agregarCategoria(){
        controladorCategoria.imprimirCategorias();
        System.out.println("Ingrese el nombre de la categoria");
        String nombreCategoria = entrada.nextLine();
        System.out.println("Ingrese la ubicacion de la categoria");
        String ubicacion = entrada.nextLine();
        Categoria nuevaCategoria = new Categoria(nombreCategoria, ubicacion);
        controladorCategoria.crearCategoria(nuevaCategoria);
    }

    public void eliminarLibro() {
        try{
            controladorLibro.imprimirLibros();
            List<Libro> libros = controladorLibro.obtenerLibros();
            if(libros.isEmpty()){
                System.out.println("Para poder eliminar libros debes de crear al menos 1, intentalo de nuevo");
                return;
            }
            System.out.println("Ingrese el id del libro a eliminar");
            int id = entrada.nextInt();
            controladorLibro.eliminarLibro(id);
            System.out.println("El libro ha sido eliminado correctamente");
            controladorLibro.imprimirLibros();
        }catch (Exception e){
            System.out.println("Ocurrio un error al eliminar el libro, intentalo mas tarde");
        }
    }

    public void eliminarCategoria() {
        try{
            controladorCategoria.imprimirCategorias();
            List<Categoria> categorias = controladorCategoria.obtenerCategorias();
            if(categorias.isEmpty()){
                System.out.println("Para poder eliminar categorias debes de crear al menos 1, intentalo de nuevo");
                return;
            }
            System.out.println("Ingrese el nombre de la categoria a eliminar");
            String categoriaNombre = entrada.nextLine();
            controladorCategoria.eliminarCategoria(categoriaNombre);
            System.out.println("La categoria ha sido eliminada correctamente");
        }catch (Exception e){
            System.out.println("Ocurrio un error al eliminar el libro, intentalo mas tarde");
        }
    }

    public void salir() {
        System.out.println("Gracias por utilizar el sistema");
        System.exit(0);
    }

}
