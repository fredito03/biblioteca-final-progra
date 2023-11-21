package Menu;
import libro.ControladorLibro;
import libro.Libro;

import java.util.Scanner;

public class MenuUsuario {

    private Scanner entrada = new Scanner(System.in);
    private ControladorLibro controladorLibro = new ControladorLibro();
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
    }


    public void devolverLibro() {
    }

    public void salir() {
        System.out.println("Gracias por utilizar el sistema");
        System.exit(0);
    }

}
