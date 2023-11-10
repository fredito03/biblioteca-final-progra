package biblioteca;
import java.util.Date;

public class Biblioteca {
    private int id;
    private int idLibro;
    private int idUsuario;
    private Date fechaPrestamo;
    private Date fechaVencimiento;
    private boolean prestado;

    public Biblioteca(int id, int idLibro, int idUsuario, Date fechaPrestamo, Date fechaVencimiento, boolean prestado) {
        this.id = id;
        this.idLibro = idLibro;
        this.idUsuario = idUsuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaVencimiento = fechaVencimiento;
        this.prestado = prestado;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", ID Libro: " + idLibro +
                ", ID Usuario: " + idUsuario +
                ", Fecha de Préstamo: " + fechaPrestamo +
                ", Fecha de Vencimiento: " + fechaVencimiento +
                ", Prestado: " + prestado;
    }
}
