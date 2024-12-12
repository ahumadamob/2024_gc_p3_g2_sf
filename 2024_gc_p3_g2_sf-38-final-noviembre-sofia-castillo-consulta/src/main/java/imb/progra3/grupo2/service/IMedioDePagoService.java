package imb.progra3.grupo2.service;

import java.util.List;

import imb.progra3.grupo2.entity.MedioDePago;
import imb.progra3.grupo2.service.IMedioDePagoService;

public interface IMedioDePagoService {

   	public List<MedioDePago> findAll();
	public MedioDePago findById(Long id);
	public boolean exists(Long id);
	public MedioDePago save(MedioDePago medioDePago);
	public void delete(Long id);
    // Otros métodos de negocio específicos para la entidad MedioDePago
}