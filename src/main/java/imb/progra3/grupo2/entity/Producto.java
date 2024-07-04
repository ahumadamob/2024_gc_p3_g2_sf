package imb.progra3.grupo2.entity;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Producto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_Producto;
	private String nombre;
	private String precio;
	private double descripcion;
	private Date dueDate;
	private Boolean done;
	public Long getId() {
		return id_Producto;
		
	}
    // Constructor vacío requerido por JPA
    public Producto() {
    }

    // Constructor con parámetros
    public Producto(String nombre) {
        this.nombre = nombre;
    }
	
    // Getters y setters
	public Long getId_Producto() {
		return id_Producto;
	}
	public void setId_Producto(Long id_Producto) {
		this.id_Producto = id_Producto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public double getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(double descripcion) {
		this.descripcion = descripcion;
	}
	public void setVentas(Object object) {
		// TODO Auto-generated method stub
		
	}
	public void setDone(boolean done) {
		// TODO Auto-generated method stub
		
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Boolean getDone() {
		return done;
	}
	public void setDone(Boolean done) {
		this.done = done;
	}
	
}