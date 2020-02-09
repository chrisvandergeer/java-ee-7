package nl.cge.jakartaee8.transakties.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import static java.time.temporal.TemporalAdjusters.*;

@Getter
@AllArgsConstructor
@ToString
public class Periode {

    private LocalDate begindatum;
    private LocalDate einddatum;


    public Periode beperkMaanden(Integer aantalMaanden) {
        LocalDate beperkingOpBegindatum = einddatum.minusMonths(aantalMaanden).with(firstDayOfMonth());
        LocalDate nieuweBegindatum = beperkingOpBegindatum.isAfter(begindatum) ? beperkingOpBegindatum : begindatum;
        return new Periode(nieuweBegindatum, einddatum);
    }

    public boolean isDatumInPeriode(LocalDate datum) {
        return !datum.isBefore(begindatum) && !datum.isAfter(einddatum);
    }
}
