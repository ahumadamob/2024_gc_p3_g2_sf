package imb.progra3.grupo2.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.progra3.grupo2.entity.Producto;
import imb.progra3.grupo2.repository.CompraRepository;
import imb.progra3.grupo2.service.ICompraService;

import java.util.List;

@Service
public class CompraServiceImplJpa implements ICompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Override
    public List<Producto> getProductosRecomendados(Long id_Cliente) {
        return compraRepository.findProductosRecomendados(id_Cliente);
    }
}
