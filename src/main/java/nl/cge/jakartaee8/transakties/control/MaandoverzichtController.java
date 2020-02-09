package nl.cge.jakartaee8.transakties.control;

import nl.cge.jakartaee8.transakties.entity.Periode;
import nl.cge.jakartaee8.transakties.entity.Transaktie;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

public class MaandoverzichtController {

    public Map<String, BigDecimal> aggregeer(List<Transaktie> transakties) {
        Map<String, BigDecimal> result = new TreeMap<>();
        Periode periode = bepaalPeriode(transakties).beperkMaanden(12);
        Map<String, BigDecimal> maandoverzicht = transakties.stream().filter(tr -> periode.isDatumInPeriode(tr.getDatum()))
                .collect(
                        groupingBy(tr -> String.format("%s-%02d", tr.getDatum().getYear(), tr.getDatum().getMonthValue()),
                                reducing(BigDecimal.ZERO, Transaktie::getBedrag, BigDecimal::add)));
        return new TreeMap<>(maandoverzicht);
    }

    private Periode bepaalPeriode(List<Transaktie> transakties) {
        LocalDate begindatum = transakties.stream()
                .min(comparing(Transaktie::getDatum))
                .map(tr -> tr.getDatum().with(TemporalAdjusters.firstDayOfMonth()).plusMonths(1))
                .orElseThrow(() -> new IllegalStateException("geen transakties gevonden voor maandoverzicht"));
        LocalDate einddatum = transakties.stream()
                .max(comparing(Transaktie::getDatum))
                .map(tr -> tr.getDatum().minusMonths(1).with(TemporalAdjusters.lastDayOfMonth()))
                .orElseThrow(() -> new IllegalStateException("geen transakties gevonden voor maandoverzicht"));
        return new Periode(begindatum, einddatum);
    }

}