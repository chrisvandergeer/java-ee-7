package nl.cge.jakartaee8.transakties.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class ZoekResultaat {

    private List<Transaktie> transakties = new ArrayList<>();
    Map<String, BigDecimal> maandoverzicht;

    public ZoekResultaat(List<Transaktie> transakties) {
        this.transakties = transakties;
    }

}
