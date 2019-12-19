package nl.cge.jakartaee8.jaxrs20.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OutputDto {

    private Date datum;
    private BigDecimal bedrag;

}
