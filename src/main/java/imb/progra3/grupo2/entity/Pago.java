package imb.progra3.grupo2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;


public class Pago extends BaseEntity{
   
    private double monto;
    private Date fecha;

   
  
    private Ventas venta;

   
   
    private MedioDePago medioDePago;

    // Constructor vacío requerido por JPA
    public Pago() {
    }

    // Constructor con parámetros
    public Pago(double monto, Date fecha, Ventas venta, MedioDePago medioDePago) {
        this.monto = monto;
        this.fecha = fecha;
        this.venta = venta;
        this.medioDePago = medioDePago;
    }

    // Getters y setters
  

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Ventas getVenta() {
        return venta;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }

    public MedioDePago getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(MedioDePago medioDePago) {
        this.medioDePago = medioDePago;
    }

    
}

