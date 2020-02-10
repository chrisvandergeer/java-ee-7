package nl.cge.jakartaee8.transakties.entity;

import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
public class Maand implements Comparable<Maand> {

    private LocalDate datum;
    private String jaar;
    private String maand;

    public Maand(LocalDate datum) {
        this.datum = datum;
        this.jaar = DateTimeFormatter.ofPattern("yyyy").format(datum);
        this.maand = DateTimeFormatter.ofPattern("MMM").format(datum);
    }

    @Override
    public int compareTo(Maand other) {
        return this.datum.compareTo(other.datum);
    }
}
