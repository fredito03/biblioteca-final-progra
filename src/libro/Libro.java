import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private Date fechaPublicacion;
    private int numPaginas;
    private List<Integer> categorias;
    private int etiqueta;
    private int numCopias;

    public Libro(int id, String titulo, String autor, Date fechaPublicacion, int numPaginas, List<Integer> categorias, int etiqueta, int numCopias) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.numPaginas = numPaginas;
        this.categorias = new ArrayList<>(categorias);
        this.etiqueta = etiqueta;
        this.numCopias = numCopias;
    }


    @Override
    public String toString() {
        return "ID: " + id +
                ", Título: " + titulo +
                ", Autor: " + autor +
                ", Fecha de Publicación: " + fechaPublicacion +
                ", Número de Páginas: " + numPaginas +
                ", Categorías: " + categorias +
                ", Etiqueta: " + etiqueta +
                ", Número de Copias: " + numCopias;
    }
}

