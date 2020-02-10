package nl.cge.jakartaee8.transakties.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity
public class ZoekOpdracht {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
