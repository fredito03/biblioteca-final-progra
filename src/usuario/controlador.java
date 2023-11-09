package usuario;

import java.util.ArrayList;
import java.util.List;

public class controlador {
    private List<Usuario> usuarios;

    public controlador() {
        this.usuarios = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario){
        int id = usuario.getId() + 1;
        String nombre = usuario.getNombre();
        String apellido = usuario.getApellido();
        String contrasena = usuario.getContrasena();
        int dpi = usuario.getDPI();
        Usuario usuarioExiste = obtenerUsuarioPorDPI(dpi);
        if(usuarioExiste != null){
            System.out.println("El usuario con DPI " + dpi + " ya existe");
            return;
        }
        Usuario nuevoUsuario = new Usuario(id, nombre, apellido, contrasena, dpi);
        usuarios.add(nuevoUsuario);
    }

    public Usuario obtenerUsuarioPorDPI(int dpi){
        for(Usuario usuario : usuarios){
            if(usuario.getDPI() == dpi){
                return usuario;
            }
        }
        return null;
    }
}
