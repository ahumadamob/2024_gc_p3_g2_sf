package imb.progra3.grupo2.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.progra3.grupo2.entity.MediodePago;
import imb.progra3.grupo2.repository.MediodePagoRepository;
import imb.progra3.grupo2.service.IMediodePagoService;

@Service
public class MediodePagoServiceImplJpa implements IMediodePagoService {

    @Autowired
    private MediodePagoRepository mediodePagoRepository;

	@Override
	public List<MediodePago> findAll() {
		return mediodePagoRepository.findAll();
	}

	@Override
	public MediodePago findById(Long id) {
		return mediodePagoRepository.findById(id).orElse(null);
	}

	@Override
	public boolean exists(Long id) {
		return id == null ? false : mediodePagoRepository.existsById(id);
	}

	@Override
	public MediodePago save(MediodePago mediodePago) {
		return mediodePagoRepository.save(mediodePago);
	}

	@Override
	public void delete(Long id) {
		mediodePagoRepository.deleteById(id);
	}

}