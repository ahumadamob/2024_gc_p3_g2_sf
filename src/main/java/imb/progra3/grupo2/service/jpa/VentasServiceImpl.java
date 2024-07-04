package imb.progra3.grupo2.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.progra3.grupo2.entity.Ventas;
import imb.progra3.grupo2.repository.VentasRepository;
import imb.progra3.grupo2.service.IVentasService;

@Service
public class VentasServiceImpl implements IVentasService{
	
	 @Autowired
	    private VentasRepository ventasRepository;

	@Override
	public List<Ventas> getAll() {
		return ventasRepository.findAll();
	}

	@Override
	public Ventas getById(Long id_Venta) {
		Optional<Ventas> ventasOptional = ventasRepository.findById(id_Venta);
        return ventasOptional.orElse(null);
	}

	@Override
	public Ventas save(Ventas ventas) {
		return ventasRepository.save(ventas);
	}

	@Override
	public void delete(Long id_Venta) {
		 ventasRepository.deleteById(id_Venta);
		
	}

	@Override
	public boolean exists(Long id_Venta) {
		return ventasRepository.existsById(id_Venta);
	}

}
