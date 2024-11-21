package imb.progra3.grupo2.service;

import java.util.List;

public interface IVentasService {
    List<List<Object>> obtenerInformePorMetodoPago();

	List<Object[]> findInformePorMetodoDePago();
}



