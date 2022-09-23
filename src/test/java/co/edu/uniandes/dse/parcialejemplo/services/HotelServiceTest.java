package co.edu.uniandes.dse.parcialejemplo.services;


import co.edu.uniandes.dse.parcialejemplo.entities.HotelEntity;
import co.edu.uniandes.dse.parcialejemplo.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialejemplo.exceptions.IllegalOperationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(HotelService.class)


 class HotelServiceTest {

    @Autowired
    HotelService hotelService;

    @Autowired
    private TestEntityManager entityManager;

    private PodamFactory factory = new PodamFactoryImpl();


    private List<HotelEntity> hotelList = new ArrayList<>();

    /*
     * Metodos que debe correr siempre antes.
     */
    @BeforeEach
    void setUp() {
        clearData();
        insertData();

    }

    /*
     * Limpia las tablas que estan implicadas en la prueba.
     */

    public void clearData() {
        entityManager.getEntityManager().createQuery("delete from HotelEntity");
    }

    /*
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     */

    public void insertData() {

        for (int i = 0; i < 3; i++) {
            HotelEntity hotelEntity = factory.manufacturePojo(HotelEntity.class);
            entityManager.persist(hotelEntity);
            hotelList.add(hotelEntity);
        }

    }

    @Test
    void CreateHotel() throws EntityNotFoundException, IllegalOperationException {
        HotelEntity newEntity = factory.manufacturePojo(HotelEntity.class);
        HotelEntity result = hotelService.createHotel(newEntity);
        assertNotNull(result);
        HotelEntity entity = entityManager.find(HotelEntity.class, result.getId());
        assertEquals(newEntity.getId(), entity.getId());
        assertEquals(newEntity.getNombre(), entity.getNombre());
    }
}
