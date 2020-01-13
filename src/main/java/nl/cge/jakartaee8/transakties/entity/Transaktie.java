package nl.cge.jakartaee8.transakties.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Accessors(chain = true)
@Getter
@Setter
@ToString
@Entity
public class Transaktie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String volgnummer;
    private LocalDate datum;
    private LocalDate rentedatum;

    @Column(precision = 7, scale = 2)
    private BigDecimal bedrag;
    @Column(precision = 7, scale = 2)
    private BigDecimal saldoNaTransaktie;
    private String tegenrekening;
    private String naamTegenpartij;
    private String code;
    private String omschrijving1;
    private String omschrijving2;
    private String omschrijving3;

}
