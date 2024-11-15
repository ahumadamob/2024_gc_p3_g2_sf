package imb.progra3.grupo2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import imb.progra3.grupo2.entity.Ventas;

public interface VentasRepository extends JpaRepository<Ventas, Long> {

    // Métodos para realizar consultas específicas basadas en `dueDate` y `done`

    // Buscar ventas con dueDate no nulo y ordenar por dueDate
    List<Ventas> findByDueDateNotNullOrderByDueDate();

    // Buscar ventas con dueDate nulo
    List<Ventas> findByDueDateNull();

    // Buscar ventas con dueDate no nulo, que estén marcadas como completadas, y ordenar por dueDate
    List<Ventas> findByDueDateNotNullAndDoneTrueOrderByDueDate();

    // Buscar ventas con dueDate nulo que estén marcadas como completadas
    List<Ventas> findByDueDateNullAndDoneTrue();

    // Buscar ventas con dueDate no nulo que no estén completadas, y ordenar por dueDate
    List<Ventas> findByDueDateNotNullAndDoneFalseOrderByDueDate();

    // Buscar ventas con dueDate nulo que no estén completadas
    List<Ventas> findByDueDateNullAndDoneFalse();
}
