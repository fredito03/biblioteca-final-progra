package prestamos;

import libro.ControladorLibro;
import libro.Libro;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Prestamo {
    private static int ultimoIdUsuario = 0;
    private int id;
    private int idLibro;
    private int idUsuario;
    private String fechaPrestamo;
    private String fechaVencimiento;
    private boolean prestado;

    ControladorLibro controladorLibro = new ControladorLibro();

    LocalDate localDate = LocalDate.now();
    public Prestamo(int idLibro, int idUsuario, boolean prestado) {
        this.id = ++ultimoIdUsuario;
        this.idLibro = idLibro;
        this.idUsuario = idUsuario;
        this.fechaPrestamo = localDate.toString();
        this.fechaVencimiento = localDate.plusMonths(1).toString();
        this.prestado = prestado;
    }

    public int getId() {
        return id;
    }
    public int getIdLibro() {
        return idLibro;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public String getFechaPrestamo() {
        return fechaPrestamo;
    }
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }
    public boolean getPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    @Override
    public String toString() {
        Libro libro = controladorLibro.obtenerLibroPorId(idLibro);
        return "ID de prestamo: " + id +  ", Nombre: " + libro.getTitulo() +  ", Fecha de Préstamo: " + fechaPrestamo +  ", Fecha de Vencimiento: " + fechaVencimiento;
    }
}
