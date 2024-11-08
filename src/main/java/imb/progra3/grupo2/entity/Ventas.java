package imb.progra3.grupo2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Ventas extends BaseEntity{
    
    private double total;
    private Date fecha;

  
    @ManyToOne
    private MedioDePago medioDePago;

   
    @ManyToOne
    private Cliente cliente;

    // Constructor vacío requerido por JPA
    public Ventas() {
    }

    // Constructor con parámetros
    public Ventas(double total, Date fecha, MedioDePago medioDePago, Cliente cliente) {
        this.total = total;
        this.fecha = fecha;
        this.medioDePago = medioDePago;
        this.cliente = cliente;
    }

    // Getters y setters
  

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

    public MedioDePago getMedioDePago() {
        return medioDePago;
    }

    public void setMediodePago(MedioDePago medioDePago) {
        this.medioDePago = medioDePago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}

