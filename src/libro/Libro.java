package libro;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Libro {
    private static int ultimoIdUsuario = 0;
    private int id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;
    private int numPaginas;
    private List<String> categorias;
    private int etiqueta;
    private int numCopias;

    public Libro(String titulo, String autor, String fechaPublicacion, int numPaginas, List<String> categorias, int etiqueta, int numCopias) {
        this.id = ++ultimoIdUsuario;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.numPaginas = numPaginas;
        this.categorias = categorias;
        this.etiqueta = etiqueta;
        this.numCopias = numCopias;
    }
    public int getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public String getFechaPublicacion() {
        return fechaPublicacion;
    }
    public int getNumPaginas() {
        return numPaginas;
    }
    public List<String> getCategorias() {
        return categorias;
    }
    public int getEtiqueta() {
        return etiqueta;
    }
    public int getNumCopias() {
        return numCopias;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }
    public void setEtiqueta(int etiqueta) {
        this.etiqueta = etiqueta;
    }
    public void setNumCopias(int numCopias) {
        this.numCopias = numCopias;
    }


    @Override
    public String toString() {
        return "ID: " + id + ", Título: " + titulo + ", Autor: " + autor + ", Fecha de Publicación: " + fechaPublicacion +  ", Número de Páginas: " + numPaginas + ", Categorías: " + categorias + ", Etiqueta: " + etiqueta + ", Número de Copias: " + numCopias;
    }
}

