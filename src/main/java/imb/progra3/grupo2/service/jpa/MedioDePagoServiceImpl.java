package imb.progra3.grupo2.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.progra3.grupo2.entity.MedioDePago;
import imb.progra3.grupo2.repository.MedioDePagoRepository;
import imb.progra3.grupo2.service.IMedioDePagoService;

import java.util.List;
import java.util.Optional;

@Service
public class MedioDePagoServiceImpl implements IMedioDePagoService {

    @Autowired
    private MedioDePagoRepository medioDePagoRepository;

    @Override
    public List<MedioDePago> getAll() {
        return medioDePagoRepository.findAll();
    }

    @Override
    public MedioDePago getById(Long id) {
        return medioDePagoRepository.findById(id).orElse(null);
    }

    @Override
    public MedioDePago save(MedioDePago medioDePago) {
        return medioDePagoRepository.save(medioDePago);
    }

    @Override
    public void delete(Long id) {
        medioDePagoRepository.deleteById(id);
    }

    @Override
    public boolean exists(Long id) {
        return medioDePagoRepository.existsById(id);
    }
    
    @Override
    public Optional<MedioDePago> MedioDePago(String nombre) {
        return medioDePagoRepository.findByNombre(nombre);
    }
}