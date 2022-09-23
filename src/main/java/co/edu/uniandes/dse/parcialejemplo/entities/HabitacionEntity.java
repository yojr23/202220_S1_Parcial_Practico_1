package co.edu.uniandes.dse.parcialejemplo.entities;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Getter
@Setter
@Entity

public class HabitacionEntity extends BaseEntity{
    @PodamExclude
    @ManyToOne
    private HotelEntity hotel;

    private Integer cuartoid;
    private Integer personas;
    private Integer camas;
    private Integer banios;
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
