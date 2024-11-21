package imb.progra3.grupo2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Venta;
    private double total;
    private Date fecha;  // Fecha de la venta

    private Date dueDate;  // Nueva propiedad: Fecha de vencimiento de la venta
    private boolean done;  // Nueva propiedad: Indicador de si la venta está completada

    @ManyToOne
    @JoinColumn(name = "id_MediodePago")
    private MediodePago mediodePago;

    @ManyToOne
    @JoinColumn(name = "id_Cliente")
    private Cliente cliente;

    // Constructor vacío requerido por JPA
    public Ventas() {
    }

    // Constructor con parámetros
    public Ventas(double total, Date fecha, Date dueDate, boolean done, MediodePago mediodePago, Cliente cliente) {
        this.total = total;
        this.fecha = fecha;
        this.dueDate = dueDate;
        this.done = done;
        this.mediodePago = mediodePago;
        this.cliente = cliente;
    }

    // Getters y setters
    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public MediodePago getMedioDePago() {
        return mediodePago;
    }

    public void setMediodePago(MediodePago mediodePago) {
        this.mediodePago = mediodePago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Método toString para representación de cadena
    @Override
    public String toString() {
        return "Ventas{" +
                "idVenta=" + idVenta +
                ", total=" + total +
                ", fecha=" + fecha +
                ", dueDate=" + dueDate +
                ", done=" + done +
                ", mediodePago=" + mediodePago +
                ", cliente=" + cliente +
                '}';
    }
}

