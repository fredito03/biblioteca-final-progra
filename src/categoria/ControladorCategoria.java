package categoria;
import java.util.ArrayList;
import java.util.List;

public class ControladorCategoria {

    private List<Categoria> categoriasRegistradas = new ArrayList<>();

    public ControladorCategoria() {
        crearCategoriasDefault();
    }

   public void crearCategoria(Categoria categoria){
       Categoria categoriaExiste = buscarCategoriaPorNombre(categoria.getNombre());
       if(categoriaExiste != null){
           System.out.println("La categoria " + categoria.getNombre() + " Ya existe");
       }else{
           categoriasRegistradas.add(categoria);
           System.out.println("Categoria " + categoria.getNombre() + " Se ha creado correctamente");
       }
}

    public void eliminarCategoria(String nombreCategoria){
        for (Categoria categoria: categoriasRegistradas){
            boolean categoriaExiste = categoria.getNombre().equals(nombreCategoria);
            if(categoriaExiste){
                categoriasRegistradas.remove(categoria);
                return;
            }

        }
    }

    public Categoria buscarCategoriaPorNombre(String nombre){
        if(categoriasRegistradas.isEmpty()){
            return null;
        }
        for (Categoria categoria : categoriasRegistradas) {
            if(categoria.getNombre().equals(nombre)){
                return categoria;
            }
        }
        return null;
    }

    public void imprimirCategorias(){
        if(categoriasRegistradas.isEmpty()){
           System.out.println("No hay categorias registradas");
           return;
       }
       System.out.println("Categorias Registradas: ");
       for (Categoria categoria : categoriasRegistradas) {
           System.out.println(categoria.toString());
       }
    }

    public List<Categoria> obtenerCategorias(){
       return categoriasRegistradas;
    }


    private void crearCategoriasDefault(){
            Categoria Categoria1 = new Categoria("accion","Estanteria 2, Pasillo 3");
            Categoria Categoria2 = new Categoria("drama","Estanteria 5, Pasillo 6");
            Categoria Categoria3 = new Categoria("aventura","Estanteria 2, Pasillo 3");
            Categoria Categoria4 = new Categoria("comedia","Estanteria 8, Pasillo 9");
            Categoria Categoria5 = new Categoria("amor","Estanteria 10, Pasillo 11");
            categoriasRegistradas.add(Categoria1);
            categoriasRegistradas.add(Categoria2);
            categoriasRegistradas.add(Categoria3);
            categoriasRegistradas.add(Categoria4);
            categoriasRegistradas.add(Categoria5);
    }

}
