package imb.progra3.grupo2.service;

import java.util.List;
import java.util.Optional;

import imb.progra3.grupo2.entity.MedioDePago;

public interface IMedioDePagoService {
    List<MedioDePago> getAll();
    MedioDePago getById(Long id);
    MedioDePago save(MedioDePago medioDePago);
    void delete(Long id);
    boolean exists(Long id);
	Optional<MedioDePago> MedioDePago(String nombre);
}
