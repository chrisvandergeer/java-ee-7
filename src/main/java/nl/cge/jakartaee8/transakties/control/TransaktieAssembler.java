package nl.cge.jakartaee8.transakties.control;

import nl.cge.jakartaee8.transakties.entity.Transaktie;

import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TransaktieAssembler {

    public static final int VOLGNUMMER = 3;
    public static final int DATUM = 4;
    public static final int RENTEDATUM = 5;
    public static final int BEDRAG = 6;
    public static final int SALDONATRANSAKTIE = 7;

    public List<Transaktie> assemble(InputStream csvInputStream) {
        List<Transaktie> result = new ArrayList<>();
        Scanner scanner = new Scanner(csvInputStream);
        scanner.nextLine();
        while (scanner.hasNext()) {
            String transaktieRegel = scanner.nextLine();
            String[] transaktieArray = transaktieRegel.split("\",\"");
            result.add(new Transaktie()
                    .setVolgnummer(transaktieArray[VOLGNUMMER])
                    .setDatum(LocalDate.parse(transaktieArray[DATUM]))
                    .setRentedatum(LocalDate.parse(transaktieArray[RENTEDATUM]))
                    .setBedrag(new BigDecimal(transaktieArray[BEDRAG].replace(",", ".")))
                    .setSaldoNaTransaktie(new BigDecimal(transaktieArray[SALDONATRANSAKTIE]))

            );
        }
        return result;
    }

}
