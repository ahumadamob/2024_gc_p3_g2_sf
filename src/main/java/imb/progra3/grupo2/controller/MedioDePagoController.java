package imb.progra3.grupo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import imb.progra3.grupo2.entity.MedioDePago;
import imb.progra3.grupo2.service.IMedioDePagoService;

import java.util.List;

@RestController
@RequestMapping("/api/mediosdepago")  								//Obtener		 // http://localhost:8080/api/mediosdepago
public class MedioDePagoController {

    @Autowired
    private IMedioDePagoService medioDePagoService;

    @GetMapping
    public List<MedioDePago> getAllMediosDePago() {
        return medioDePagoService.getAll();
    }

    @GetMapping("/{id}")											//Obtener por id //http://localhost:8080/api/mediosdepago/4
    public ResponseEntity<MedioDePago> getMedioDePagoById(@PathVariable Long id) {
        MedioDePago medioDePago = medioDePagoService.getById(id);
        return ResponseEntity.ok(medioDePago);
    }

    @PostMapping  													//CREAR			//http://localhost:8080/api/mediosdepago
    public ResponseEntity<MedioDePago> createMedioDePago(@RequestBody MedioDePago medioDePago) {
        MedioDePago nuevoMedioDePago = medioDePagoService.save(medioDePago);
        return new ResponseEntity<>(nuevoMedioDePago, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")										//ACTUALIZAR  //http://localhost:8080/api/mediosdepago/7
    public ResponseEntity<MedioDePago> updateMedioDePago(@PathVariable Long id, @RequestBody MedioDePago medioDePago) {
        if (!medioDePagoService.exists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        medioDePago.setId(id);
        MedioDePago updatedMedioDePago = medioDePagoService.save(medioDePago);
        return ResponseEntity.ok(updatedMedioDePago);
    }

    @DeleteMapping("/{id}")									//Borrar  // http://localhost:8080/api/mediosdepago/2
    public ResponseEntity<Void> deleteMedioDePago(@PathVariable Long id) {
        if (!medioDePagoService.exists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        medioDePagoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
