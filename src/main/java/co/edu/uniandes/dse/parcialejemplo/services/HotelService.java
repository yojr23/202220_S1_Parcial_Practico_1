package co.edu.uniandes.dse.parcialejemplo.services;

import co.edu.uniandes.dse.parcialejemplo.entities.HotelEntity;
import co.edu.uniandes.dse.parcialejemplo.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialejemplo.repositories.HotelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Slf4j
@Service

public class HotelService {
    @Autowired
    HotelRepository hotelRepository;

    @Transactional
    public HotelEntity createHotel(HotelEntity hotel) throws IllegalOperationException{
        log.info("Iniciando el proceso de crear un Hotel");
        if (!hotelRepository.findByNombre(hotel.getNombre()).isEmpty()){
            throw new IllegalOperationException("El nombre del Hotel ya existe");
        }
        log.info("Terminando el proceso de crear un Hotel");
        return hotelRepository.save(hotel);
    }
    
}
