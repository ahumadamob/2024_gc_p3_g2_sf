package imb.progra3.grupo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imb.progra3.grupo2.entity.ItemCarrito;
import imb.progra3.grupo2.service.IItemCarritoService;

@RestController
@RequestMapping("/item-carrito")
public class ItemCarritoController {

    @Autowired
    private IItemCarritoService itemCarritoService;

    @PostMapping
    public ItemCarrito createItemCarrito(@RequestBody ItemCarrito itemCarrito) {
        return itemCarritoService.saveItemCarrito(itemCarrito);
    }

    @GetMapping("/{id}")
    public ItemCarrito getItemCarritoById(@PathVariable("id") Long id) {
        return itemCarritoService.getItemCarritoById(id).orElse(null);
    }

    @GetMapping("/carrito/{carritoId}")
    public List<ItemCarrito> getAllItemsInCarrito(@PathVariable("carritoId") Long carritoId) {
        return itemCarritoService.getAllItemsInCarrito(carritoId);
    }

    @DeleteMapping("/{id}")
    public void deleteItemCarrito(@PathVariable("id") Long id) {
        itemCarritoService.deleteItemCarrito(id);
    }

    @GetMapping("/carrito/{carritoId}/verificar-stock")
    public List<ItemCarrito> verificarStock(@PathVariable("carritoId") Long carritoId) {
        return itemCarritoService.verificarStock(carritoId);
    }
}