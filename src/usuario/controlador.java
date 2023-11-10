package usuario;
import java.util.ArrayList;
import java.util.List;

import enums.Rol;

public class controlador {
    private List<Usuario> usuarios;


    public controlador() {
        this.usuarios = new ArrayList<>();
        generarUsuariosPredeterminados();
    }

    public void agregarUsuario(Usuario usuario){
        String dpi = usuario.getDPI();
        Usuario usuarioExiste = obtenerUsuarioPorDPI(dpi);
        if(usuarioExiste != null){
            System.out.println("El usuario con DPI " + dpi + " ya existe");
            return;
        }
        usuarios.add(usuario);
    }

    public void listarUsuarios(){
        for (Usuario usuario: usuarios) {
            System.out.println(usuario.toString());
        }
    }

    public Usuario obtenerUsuarioPorDPI(String dpi){
        for(Usuario usuario : usuarios){
            if(usuario.getDPI().equals(dpi)){
                return usuario;
            }
        }
        return null;
    }

    public Usuario obtenerUsuarioPorCorreo(String correo){
        for(Usuario usuario : usuarios){
            if(usuario.getCorreo().equals(correo)){
                return usuario;
            }
        }
        return null;
    }

    private void generarUsuariosPredeterminados(){
        Usuario usuario1 = new Usuario( "Alma", "admin@umg.com", "Lopez", "miumg@@", "3940128410101", Rol.ADMINISTRADOR);
        Usuario usuario2 = new Usuario( "Paula", "pau@umg.com", "Leonardo", "pauxd12@@", "3629202730101", Rol.ADMINISTRADOR);
        Usuario usuario3 = new Usuario("Ximena", "ximena@.com", "Palencia", "ximenpal82_@", "36464684486", Rol.BIBLIOTECARIO);
        Usuario usuario4 = new Usuario("Marielos", "marielos@umg.com", "Leon", "marielostop491", "5319202730101", Rol.USUARIO);
        agregarUsuario(usuario1);
        agregarUsuario(usuario2);
        agregarUsuario(usuario3);
        agregarUsuario(usuario4);
    }
}
