package imb.progra3.grupo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import imb.progra3.grupo2.entity.MedioDePago;
import imb.progra3.grupo2.service.IMedioDePagoService;
import imb.progra3.grupo2.exception.ResourceNotFoundException;
import imb.progra3.grupo2.exception.ValidationException;
import imb.progra3.grupo2.repository.MedioDePagoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/mediosdepago")   
public class MedioDePagoController {

    @Autowired
    private IMedioDePagoService IMedioDePagoService;

    @Autowired
    private MedioDePagoRepository MedioDePagoRepository;

    @GetMapping   //Crear un nuevo medio de pago           //http://localhost:8080/api/mediosdepago
    public List<MedioDePago> getAllMediosDePago() {
        //return IMedioDePagoService.getAll();
    	return null;
    }

    @GetMapping("/{id}")		//Obtener un cliente por ID  //http://localhost:8080/api/mediosdepago/5
    public ResponseEntity<MedioDePago> getMedioDePagoById(@PathVariable Long id) {
        MedioDePago medioDePago = IMedioDePagoService.findById(id);
        if (medioDePago == null) {
            throw new ResourceNotFoundException("Medio de pago con ID " + id + " no encontrado.");
        }
        return ResponseEntity.ok(medioDePago);
    }

    @PostMapping		 //Crear un nuevo cliente //http://localhost:8080/api/mediosdepago
    public ResponseEntity<MedioDePago> createMedioDePago(@RequestBody MedioDePago medioDePago) {
        validateMedioDePago(medioDePago);
        MedioDePago nuevoMedioDePago = IMedioDePagoService.save(medioDePago);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/mediosdepago/" + nuevoMedioDePago.getId());
        return new ResponseEntity<>(nuevoMedioDePago, headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")  //Actualizar un cliente existente	//http://localhost:8080/api/mediosdepago/5
    public ResponseEntity<MedioDePago> updateMedioDePago(@PathVariable Long id, @RequestBody MedioDePago medioDePago) {
        if (!IMedioDePagoService.exists(id)) {
            throw new ResourceNotFoundException("Medio de pago con ID " + id + " no encontrado.");
        }
        validateMedioDePago(medioDePago);
        medioDePago.setId(id);
        MedioDePago updatedMedioDePago = IMedioDePagoService.save(medioDePago);
        return ResponseEntity.ok(updatedMedioDePago);
    }

    @DeleteMapping("/{id}")	//Eliminar un cliente por ID	//http://localhost:8080/api/v1/cliente/5
    public ResponseEntity<Void> deleteMedioDePago(@PathVariable Long id) {
        if (!IMedioDePagoService.exists(id)) {
            throw new ResourceNotFoundException("Medio de pago con ID " + id + " no encontrado.");
        }
        IMedioDePagoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Validación de MedioDePago
    private void validateMedioDePago(MedioDePago medioDePago) {
        if (medioDePago.getNombre() == null || medioDePago.getNombre().isEmpty()) {
            throw new ValidationException("El nombre del medio de pago no puede estar vacío.");
        }
        // Agregar más validaciones según sea necesario
    }

    // Manejo de excepciones
    @ControllerAdvice
    public static class GlobalExceptionHandler {

        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException e) {
            ErrorResponse errorResponse = new ErrorResponse("Recurso no encontrado", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(ValidationException.class)
        public ResponseEntity<ErrorResponse> handleValidationException(ValidationException e) {
            ErrorResponse errorResponse = new ErrorResponse("Error de validación", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorResponse> handleGeneralException(Exception e) {
            ErrorResponse errorResponse = new ErrorResponse("Error interno del servidor", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Clase para respuestas de error
    public static class ErrorResponse {
        private String error;
        private String message;

        public ErrorResponse(String error, String message) {
            this.error = error;
            this.message = message;
        }

        // Getters y setters
        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}

