package nl.cge.jakartaee8.transakties.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

@Getter
@AllArgsConstructor
public class Maandtotaal {

    private String maand;
    private BigDecimal bedrag;

    public static List<Maandtotaal> create(Map<String, BigDecimal> maandtotalen) {
        return maandtotalen.entrySet().stream()
                .map(entry -> new Maandtotaal(entry.getKey(), entry.getValue()))
                .sorted(comparing(Maandtotaal::getMaand))
                .collect(Collectors.toList());
    }

}
