package imb.progra3.grupo2.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.progra3.grupo2.entity.Cliente;
import imb.progra3.grupo2.repository.ClienteRepository;
import imb.progra3.grupo2.service.IClienteService;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImplJpa implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getById(Long id_Cliente) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id_Cliente);
        return clienteOptional.orElse(null);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void delete(Long id_Cliente) {
        clienteRepository.deleteById(id_Cliente);
    }

    @Override
    public boolean exists(Long id_Cliente) {
        return clienteRepository.existsById(id_Cliente);
    }
}
