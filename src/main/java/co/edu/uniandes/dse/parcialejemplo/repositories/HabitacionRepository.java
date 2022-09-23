package co.edu.uniandes.dse.parcialejemplo.repositories;

import co.edu.uniandes.dse.parcialejemplo.entities.HabitacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitacionRepository extends JpaRepository<HabitacionEntity, Long> {
    List<HabitacionEntity> findByCuartoId(Integer cuartoid);
    List<HabitacionEntity> findByPersonas(Integer personas);
    Integer findByCamas(Integer camas);
    Integer findByBanios(Integer banios);
    HabitacionEntity findbyID(Long id);

    

}
