package imb.progra3.grupo2.service;

import java.util.List;

import imb.progra3.grupo2.entity.Producto;

public interface ICompraService {
    List<Producto> getProductosRecomendados(Long id_Cliente);
}
