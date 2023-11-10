package Menu;
import java.util.Scanner;

import enums.Rol;
import usuario.Usuario;
import usuario.controlador;
import Menu.MenuUsuario;

public class Login {

    private Scanner entrada = new Scanner(System.in);
    private controlador controladorUsuario = new controlador();
    private MenuUsuario menuUsuario = new MenuUsuario();
    private void IniciarSesion(){
        System.out.println("Bienvenido al sistema de biblioteca");
        System.out.println("Ingrese su correo electronico");
        String correo = entrada.next();
        System.out.println("Ingrese su contraseña");
        String contrasena = entrada.next();
        Usuario usuarioEncontrado = controladorUsuario.obtenerUsuarioPorCorreo(correo);
        if(usuarioEncontrado == null){
            System.out.println("El usuario no existe, ¿Deseas registrarte?");
            // flujo para registro
            return;
        }
        String contrasenaEncontrada = usuarioEncontrado.getContrasena();
        while (!contrasena.equals(contrasenaEncontrada)) {
            System.out.println("Contraseña incorrecta, intente nuevamente");
            contrasena = entrada.nextLine();
        }
        MostrarMenu(usuarioEncontrado);
    }

    private void MostrarMenu(Usuario usuarioEncontrado){
        Rol rol = usuarioEncontrado.getRol();
        switch (rol) {
            case ADMINISTRADOR:
                System.out.println("Hola " + usuarioEncontrado.getNombre() + " Bienvenido al sistema, tienes el rol de: " + usuarioEncontrado.getRol());
                // flujo para administrador
                break;
            case USUARIO:
                System.out.println("Hola " + usuarioEncontrado.getNombre() + " Bienvenido al sistema, tienes el rol de: " + usuarioEncontrado.getRol());
                menuUsuario.mostrarMenu();
                break;
        }
    }


    public static void main(String[] args) {
        Login login = new Login();
        login.IniciarSesion();
        System.out.println("Hasta luego!");
        System.exit(0);
    }
}
