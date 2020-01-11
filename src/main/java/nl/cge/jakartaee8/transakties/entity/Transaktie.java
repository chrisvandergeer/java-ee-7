package nl.cge.jakartaee8.transakties.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;

@Accessors(chain = true)
@Getter
@Setter
@ToString
public class Transaktie {

    private String volgnummer;
    private LocalDate datum;
    private LocalDate rentedatum;
    private BigDecimal bedrag;
    private BigDecimal saldoNaTransaktie;
    private String tegenrekening;
    private String naamTegenpartij;
    private String code;
    private String omschrijving1;
    private String omschrijving2;
    private String omschrijving3;


}
