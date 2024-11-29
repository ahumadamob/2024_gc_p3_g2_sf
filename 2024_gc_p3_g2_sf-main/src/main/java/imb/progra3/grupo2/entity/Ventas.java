package imb.progra3.grupo2.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ventas extends BaseEntity{
    
    private double total;
    private Date fecha;  // Fecha de la venta

    private Date dueDate;  // Nueva propiedad: Fecha de vencimiento de la venta
    private boolean done;  // Nueva propiedad: Indicador de si la venta está completada

    @ManyToOne
    @JoinColumn(name = "id_MediodePago")
    private MedioDePago mediodePago;

    @ManyToOne
    @JoinColumn(name = "id_Cliente")
    private Cliente cliente;

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

	public MedioDePago getMediodePago() {
		return mediodePago;
	}

	public void setMediodePago(MedioDePago mediodePago) {
		this.mediodePago = mediodePago;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

    
}

