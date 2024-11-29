package imb.progra3.grupo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import imb.progra3.grupo2.entity.Producto;
import imb.progra3.grupo2.service.ICompraService;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class CompraController {

    @Autowired
    private ICompraService compraService;

    @GetMapping("/recomendaciones/{clienteId}")
    public List<Producto> getProductosRecomendados(@PathVariable Long clienteId) {
        return compraService.getProductosRecomendados(clienteId);
    }
}
