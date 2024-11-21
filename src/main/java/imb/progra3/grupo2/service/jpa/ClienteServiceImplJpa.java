package imb.progra3.grupo2.service.jpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.progra3.grupo2.entity.Cliente;
import imb.progra3.grupo2.repository.ClienteRepository;
import imb.progra3.grupo2.service.IClienteService;

import java.util.List;

 	@Service
	public class ClienteServiceImplJpa implements IClienteService{
 		
 		
 		@Autowired
 		private ClienteRepository clienteRepository;

 		@Override
 		public List<Cliente> getAll() {
 			return clienteRepository.findAll();
 		}

 		@Override
 		public Cliente getById(Long id) {
 			return clienteRepository.findById(id).orElse(null);
 		}

 		@Override
 		public Cliente save(Cliente cliente) {
 			return clienteRepository.save(cliente);
 		}

 		@Override
 		public void deleteById(Long id) {
 			clienteRepository.deleteById(id);
 		}

 		@Override
 		public boolean exists(Long id) {
 			return id == null ? false : clienteRepository.existsById(id);
 		}

 		@Override
 		public List<Cliente> getAllEnabled() {
 			return clienteRepository.findByEnabledTrue();
 		}

 		@Override
 		public List<Cliente> getAllDisabled() {
 			return clienteRepository.findByEnabledFalse();
 		}

}
