package co.edu.uniandes.dse.parcialejemplo.services;
import co.edu.uniandes.dse.parcialejemplo.entities.HabitacionEntity;
import co.edu.uniandes.dse.parcialejemplo.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialejemplo.repositories.HabitacionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service

public class HabitacionService {
    @Autowired
    HabitacionRepository habitacionRepository;

    @Transactional
    public HabitacionEntity createHabitacion(HabitacionEntity habitacion) throws IllegalOperationException{
        log.info("Iniciando el proceso de crear un Habitacion");
        Integer x =habitacionRepository.findByBanios(habitacion.getBanios());
        Integer y = (habitacionRepository.findByCamas(habitacion.getCamas()));
        if (x<=y){
            throw new IllegalOperationException("No se puede crear la habitacion");
        }
        log.info("Terminando el proceso de crear la habitacion");
        return habitacionRepository.save(habitacion);
    }
    
}
