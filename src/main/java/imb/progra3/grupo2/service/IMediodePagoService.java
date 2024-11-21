package imb.progra3.grupo2.service;

import java.util.List;

import imb.progra3.grupo2.entity.MediodePago;
import imb.progra3.grupo2.service.IMediodePagoService;

public interface IMediodePagoService {

   	public List<MediodePago> findAll();
	public MediodePago findById(Long id);
	public boolean exists(Long id);
	public MediodePago save(MediodePago medioDePago);
	public void delete(Long id);
    // Otros métodos de negocio específicos para la entidad MedioDePago
}