package imb.progra3.grupo2.service;

import java.util.List;

import imb.progra3.grupo2.entity.Cliente;

public interface IClienteService {
    public List<Cliente> getAll();
    public Cliente getById(Long id_Cliente);
    public Cliente save(Cliente cliente);
    public void delete(Long id_Cliente);
    public boolean exists(Long id_Cliente);
}
