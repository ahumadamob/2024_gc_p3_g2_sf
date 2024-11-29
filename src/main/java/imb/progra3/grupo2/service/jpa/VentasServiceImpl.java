package imb.progra3.grupo2.service.jpa;

import imb.progra3.grupo2.entity.MedioDePago;
import imb.progra3.grupo2.entity.Ventas;
import imb.progra3.grupo2.repository.VentasRepository;
import imb.progra3.grupo2.service.IVentasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasServiceImpl implements IVentasService {

    @Autowired
    private VentasRepository ventasRepository;

    @Override
    public List<Object[]> findInformePorMetodoDePago() {
        return ventasRepository.findInformePorMetodoDePago();
    }

	@Override
	public List<List<Object>> obtenerInformePorMetodoPago() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ventas save(Ventas ventas) {
		// TODO Auto-generated method stub
		return ventasRepository.save(ventas);
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return ventasRepository.existsById(id);
	}
	
	 
	  
}
