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
    private String tag;
    private String tag2add;

    public boolean isZoekenOpTegenpartij() {
        return !"".equals(tegenpartij.trim());
    }

    public boolean isZoekenOpOmschrijving() {
        return !"".equals(omschrijving.trim());
    }

    public boolean isZoekenOpTag() {
        return !"".equals(tag.trim());
    }
}
