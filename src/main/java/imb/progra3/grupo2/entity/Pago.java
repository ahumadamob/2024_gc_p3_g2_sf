package imb.progra3.grupo2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Pago;
    private double monto;
    private Date fecha;

    private LocalDate fecha;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Venta")
    private Ventas venta;

    @ManyToOne
    @JoinColumn(name = "id_MedioDePago")
    private MediodePago medioDePago;

    // Constructor vacío requerido por JPA
    public Pago() {
    }

    // Constructor con parámetros
    public Pago(double monto, LocalDate fecha, Ventas venta, MediodePago medioDePago) {
        this.monto = monto;
        this.fecha = fecha;
        this.venta = venta;
        this.medioDePago = medioDePago;
    }

    // Getters y setters
    public Long getId_Pago() {
        return id_Pago;
    }

    public void setId_Pago(Long id_Pago) {
        this.id_Pago = id_Pago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Ventas getVenta() {
        return venta;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }

    public MediodePago getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(MediodePago medioDePago) {
        this.medioDePago = medioDePago;
    }

    // Método toString para representación de cadena
    @Override
    public String toString() {
        return "Pago{" +
                "id_Pago=" + id_Pago +
                ", monto=" + monto +
                ", fecha=" + fecha +
                ", venta=" + venta +
                ", medioDePago=" + medioDePago +
                '}';
    }
}

