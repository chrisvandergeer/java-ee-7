package nl.cge.jakartaee8.transakties.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ZoekOpdracht {

    private String tegenpartij;
    private String omschrijving;

    public boolean isZoekenOpTegenpartij() {
        return !"".equals(tegenpartij.trim());
    }

    public boolean isZoekenOpOmschrijving() {
        return !"".equals(omschrijving.trim());
    }
}
