package Menu;
import libro.ControladorLibro;
import libro.Libro;
import prestamos.ControladorPrestamos;
import prestamos.Prestamo;
import usuario.Usuario;

import java.util.List;
import java.util.Scanner;

public class MenuUsuario {
    private Scanner entrada = new Scanner(System.in);
    private Usuario usuario = null;
    private ControladorLibro controladorLibro = new ControladorLibro();
    private ControladorPrestamos controladorPrestamos = new ControladorPrestamos();
    public void mostrarMenu(){
        System.out.println("--- MENU ---");
        System.out.println("1. Buscar Libro");
        System.out.println("2. Prestar Libro");
        System.out.println("3. Devolver Libro");
        System.out.println("4. Salir");
        int opcion = entrada.nextInt();
        entrada.nextLine();
        switch (opcion) {
            case 1:
                buscarLibro();
                mostrarMenu();
                break;
            case 2:
                prestarLibro();
                mostrarMenu();
                break;
            case 3:
                devolverLibro();
                mostrarMenu();
                break;
            case 4:
                salir();
                break;
            default:
                System.out.println("Opcion invalida");
                mostrarMenu();
                break;
        }
    }

    public void buscarLibro(){
        System.out.println("Ingrese el nombre del libro que desea buscar");
        String titulo = entrada.nextLine();
        Libro libroEncontrado = controladorLibro.buscarLibroPorTitulo(titulo);
        if (libroEncontrado == null) {
            System.out.println("El libro no pudo ser encontrado, por favor revisa el titulo e intentalo de nuevo");
            return;
        }
        System.out.println("Libro encontrado:");
        System.out.println(libroEncontrado.toString());
    }

    public void prestarLibro() {
        try{
            controladorLibro.imprimirLibros();
            System.out.println("Ingresa el id del libro que deseas prestar");
            int idLibro = entrada.nextInt();
            controladorPrestamos.prestarLibro(idLibro, usuario.getId());
        }catch (Exception e){
            System.out.println("Ocurrio un error al prestar el libro, intentalo mas tarde" +  e);
            throw e;
        }
    }

    public void devolverLibro() {
        try{
            controladorPrestamos.imprimirLibrosPrestadosPorUsuario(usuario.getId());
            System.out.println("Ingresa el id del libro que deseas devolver");
            int idLibro = entrada.nextInt();
            controladorPrestamos.devolverLibro(idLibro);
        }catch (Exception e){
            System.out.println("Ocurrio un error al devolver el libro, intentalo mas tarde" +  e);
            throw e;
        }
    }

    public void salir() {
        System.out.println("Gracias por utilizar el sistema");
        System.exit(0);
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
