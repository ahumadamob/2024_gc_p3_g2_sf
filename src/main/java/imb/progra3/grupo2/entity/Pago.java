package imb.progra3.grupo2.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;

    private double monto;

    private LocalDate fecha;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Venta")
    private Ventas venta;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
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

    // Getters y Setters
    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
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
}
