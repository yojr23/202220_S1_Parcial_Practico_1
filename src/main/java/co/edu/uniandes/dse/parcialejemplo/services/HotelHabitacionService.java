package co.edu.uniandes.dse.parcialejemplo.services;

import co.edu.uniandes.dse.parcialejemplo.entities.HabitacionEntity;
import co.edu.uniandes.dse.parcialejemplo.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialejemplo.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialejemplo.repositories.HabitacionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialejemplo.entities.HotelEntity;
import co.edu.uniandes.dse.parcialejemplo.repositories.HotelRepository;

import java.util.Optional;


@Slf4j
@Service

public class HotelHabitacionService {

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    HabitacionRepository habitacionRepository;

    @Transactional
    public HabitacionEntity addHabitacion(Long hotelId, Long habitacionId) throws EntityNotFoundException, IllegalOperationException {
        log.info("Inicia el proceso de agregar una habitacion a un hotel con id = {}", hotelId);

        Optional<HotelEntity> hotelEntity = hotelRepository.findById(hotelId);
        if (hotelEntity.isEmpty())
            throw new IllegalOperationException("Hotel no encontrado");

        Optional<HabitacionEntity> habitacionEntity = habitacionRepository.findById(habitacionId);
        if (habitacionEntity.isEmpty())
            throw new IllegalOperationException("Habitacion no encontrada");

        habitacionEntity.get().setHotel(hotelEntity.get());
        log.info("Termina el proceso de agregar una habitacion a un hotel con id = {}", hotelId);
        return habitacionEntity.get();
    }
    
}
