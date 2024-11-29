package imb.progra3.grupo2.service;


import imb.progra3.grupo2.entity.Cliente;
import imb.progra3.grupo2.service.IClienteService;
import java.util.List;

public interface IClienteService {
   	 // Otros métodos de negocio específicos para la entidad Carrito
    public List<Cliente> getAll();
	public Cliente getById(Long id);
	public Cliente save(Cliente cliente);
	public void deleteById(Long id);
	public boolean exists(Long id);
	public List<Cliente>getAllEnabled();
	public List<Cliente>getAllDisabled();
	
}
