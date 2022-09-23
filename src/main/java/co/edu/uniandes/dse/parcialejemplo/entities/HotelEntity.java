package co.edu.uniandes.dse.parcialejemplo.entities;
import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity

public class HotelEntity extends BaseEntity {
    @PodamExclude
    @OneToMany(mappedBy = "habitacion",
            cascade = CascadeType.PERSIST,
            fetch =  FetchType.LAZY,
            orphanRemoval = true
    )
    private List<HabitacionEntity> habitaciones = new ArrayList<>();

    private String nombre;
    private String direccion;
    private Integer estrellas;
    private Long id;


    @Override
    public boolean equals(Object o){
        return super.equals(o);
    }

    @Override
    public int hashCode(){
        return  super.hashCode();
    }
    
}
