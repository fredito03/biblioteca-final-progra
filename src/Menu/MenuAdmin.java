package Menu;
import java.util.Scanner;

public class MenuAdmin {

    private Scanner entrada = new Scanner(System.in);
    public void mostrarMenu(){
        System.out.println("--- MENU ---");
        System.out.println("1. Agregar Libro");
        System.out.println("2. Agregar Categoria");
        System.out.println("3. Eliminar Libro");
        System.out.println("4. Eliminar Categoria");
        System.out.println("5. Salir");
        int opcion = entrada.nextInt();
        switch (opcion) {
            case 1:
                agregarLibro();
                break;
            case 2:
                agregarCategoria();
                break;
            case 3:
                eliminarLibro();
                break;
            case 4:
                eliminarCategoria();
                break;
            case 5:
                salir();
                break;
            default:
                System.out.println("Opcion invalida");
                mostrarMenu();
                break;
        }
    }

    public void agregarLibro(){

    }
    public void agregarCategoria(){

    }

    public void eliminarLibro() {
    }


    public void eliminarCategoria() {
    }

    public void salir() {
        System.out.println("Gracias por utilizar el sistema");
        System.exit(0);
    }

}
