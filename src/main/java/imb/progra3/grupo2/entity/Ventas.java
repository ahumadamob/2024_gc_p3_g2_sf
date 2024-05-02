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
    private Date fecha;

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
    public Ventas(double total, Date fecha, MediodePago mediodePago, Cliente cliente) {
        this.total = total;
        this.fecha = fecha;
        this.mediodePago = mediodePago;
        this.cliente = cliente;
    }

    // Getters y setters
    public Long getId_Venta() {
        return id_Venta;
    }

    public void setId_Venta(Long id_Venta) {
        this.id_Venta = id_Venta;
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

    public MediodePago getMedioDePago() {
        return mediodePago;
    }

    public void setMediodePago(MediodePago medioDePago) {
        this.mediodePago = medioDePago;
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
        return "Venta{" +
                "id_Venta=" + id_Venta +
                ", total=" + total +
                ", fecha=" + fecha +
                ", mediodePago=" + mediodePago +
                ", cliente=" + cliente +
                '}';
    }
}

