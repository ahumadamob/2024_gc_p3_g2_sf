package imb.progra3.grupo2.service;

import java.util.List;

import imb.progra3.grupo2.entity.Ventas;

public interface IVentasService {
	
	
	 List<Ventas> getAll();
	    Ventas getById(Long id);
	    Ventas save(Ventas ventas);
	    void delete(Long id);
	    boolean exists(Long id);

}
