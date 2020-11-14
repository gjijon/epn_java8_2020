package net.flat.streams.datos;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import net.flat.streams.dto.Clima;

/**
 *
 * @author gjijon
 */
public final class ClimaDatos {
    
    public static final String VAR_PRECIPITACIONES_SOLEADO  = "Soleado";
    public static final String VAR_PRECIPITACIONES_LLUVIA   = "Lluvia";
    public static final String VAR_PRECIPITACIONES_GRANIZO  = "Granizo";
    public static final String VAR_PRECIPITACIONES_NUBLADO  = "Nublado";
    public static final String VAR_PRECIPITACIONES_NIEBLA   = "Niebla";
    
    public static final String MODELO_IMPRIMIR_PANTALLA = ""
            + "\n"
            + "****************************************************************************************************\n"
            + "* %s\n"
            + "****************************************************************************************************";

    public static List<Clima> obtieneDatos() {
        Date fecha1 = new Date(System.currentTimeMillis());
        Date fecha2 = new Date(System.currentTimeMillis() - 1500000L);
        return Arrays.asList(
                new Clima("Quito"       , fecha1, VAR_PRECIPITACIONES_SOLEADO   , new BigDecimal("1.0"), new BigDecimal("1.3"), 9),
                new Clima("Guayaquil"   , fecha1, VAR_PRECIPITACIONES_LLUVIA    , new BigDecimal("2.1"), new BigDecimal("2.4"), 8),
                new Clima("Tulcan"      , fecha2, VAR_PRECIPITACIONES_GRANIZO   , new BigDecimal("1.2"), new BigDecimal("3.5"), 7),
                new Clima("Cuenca"      , fecha2, VAR_PRECIPITACIONES_NUBLADO   , new BigDecimal("2.3"), new BigDecimal("4.6"), 6),
                new Clima("Portoviejo"  , fecha2, VAR_PRECIPITACIONES_NIEBLA    , new BigDecimal("3.4"), new BigDecimal("5.7"), 5),
                new Clima("Ibarra"      , fecha2, VAR_PRECIPITACIONES_LLUVIA    , new BigDecimal("4.5"), new BigDecimal("1.8"), 4),
                new Clima("Manta"       , fecha1, VAR_PRECIPITACIONES_GRANIZO   , new BigDecimal("5.6"), new BigDecimal("2.9"), 13),
                new Clima("Loja"        , fecha1, VAR_PRECIPITACIONES_NUBLADO   , new BigDecimal("2.7"), new BigDecimal("3.0"), 12),
                new Clima("Tena"        , fecha2, VAR_PRECIPITACIONES_NIEBLA    , new BigDecimal("2.8"), new BigDecimal("4.1"), 11),
                new Clima("Azogues"     , fecha2, VAR_PRECIPITACIONES_SOLEADO   , new BigDecimal("3.9"), new BigDecimal("5.2"), 9),
                new Clima("Guaranda"    , fecha1, VAR_PRECIPITACIONES_SOLEADO   , new BigDecimal("4.1"), new BigDecimal("6.3"), 8),
                new Clima("Ambato"      , fecha1, VAR_PRECIPITACIONES_LLUVIA    , new BigDecimal("2.2"), new BigDecimal("7.4"), 7),
                new Clima("Cayambe"     , fecha2, VAR_PRECIPITACIONES_GRANIZO   , new BigDecimal("3.3"), new BigDecimal("1.5"), 6),
                new Clima("Machala"     , fecha2, VAR_PRECIPITACIONES_NUBLADO   , new BigDecimal("4.4"), new BigDecimal("2.6"), 5),
                new Clima("Riobamba"    , fecha1, VAR_PRECIPITACIONES_NIEBLA    , new BigDecimal("5.5"), new BigDecimal("2.7"), 14),
                new Clima("Babahoyo"    , fecha1, VAR_PRECIPITACIONES_SOLEADO   , new BigDecimal("5.6"), new BigDecimal("3.8"), 13),
                new Clima("El Empalme"  , fecha2, VAR_PRECIPITACIONES_LLUVIA    , new BigDecimal("3.7"), new BigDecimal("4.9"), 2),
                new Clima("Salinas"     , fecha2, VAR_PRECIPITACIONES_NIEBLA    , new BigDecimal("2.8"), new BigDecimal("5.3"), 11)
        );
    }
    
    public static void imprimeClimas(List<Clima> climas) {
        climas.forEach(System.out::println);
    }
    
    public static void imprimeClima(Optional<Clima> clima) {
        if (clima.isPresent()) {
            System.out.println(clima.get());
        }
    }
    
    public static void imprimeEnunciado(String enunciado) {
        if (enunciado!= null && !"".equals(enunciado.trim())) {
            System.out.println(String.format(MODELO_IMPRIMIR_PANTALLA, enunciado));
        }
    }
}
