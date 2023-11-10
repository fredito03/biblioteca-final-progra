package Menu;
import java.util.Scanner;

public class MenuUsuario {

    private Scanner entrada = new Scanner(System.in);
    public void mostrarMenu(){
        System.out.println("--- MENU ---");
        System.out.println("1. Buscar Libro");
        System.out.println("2. Prestar Libro");
        System.out.println("3. Devolver Libro");
        System.out.println("4. Salir");
        int opcion = entrada.nextInt();
        switch (opcion) {
            case 1:
                buscarLibro();
                break;
            case 2:
                prestarLibro();
                break;
            case 3:
                devolverLibro();

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
