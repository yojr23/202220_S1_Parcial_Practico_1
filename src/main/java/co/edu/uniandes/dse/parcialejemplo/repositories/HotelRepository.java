package co.edu.uniandes.dse.parcialejemplo.repositories;

import co.edu.uniandes.dse.parcialejemplo.entities.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
    List<HotelEntity> findByNombre(String nombre);
    List<HotelEntity> findByDireccion(String direccion);
    List<HotelEntity> findByEstrellas(Integer estrellas);
    HotelEntity findbyID(Long id);

    

}
