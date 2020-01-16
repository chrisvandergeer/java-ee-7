package nl.cge.jakartaee8.transakties.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ZoekOpdracht {

    private String tegenpartij;

    public boolean isZoekenOpTegenpartij() {
        return !"".equals(tegenpartij.trim());
    }
}
