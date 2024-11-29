package imb.progra3.grupo2.service;

import java.util.List;

import imb.progra3.grupo2.entity.MedioDePago;
import imb.progra3.grupo2.entity.Pago;
import imb.progra3.grupo2.entity.Ventas;

public interface IVentasService {
    List<List<Object>> obtenerInformePorMetodoPago();

	List<Object[]> findInformePorMetodoDePago();
	
	 public Ventas save(Ventas ventas);
	 public boolean exists(Long id);
	 
}



