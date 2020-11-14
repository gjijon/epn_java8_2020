package net.flat.streams;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import net.flat.streams.datos.ClimaDatos;
import net.flat.streams.dto.Clima;

/**
 *
 * @author gjijon
 */
public class ActividadCOperacionesConFiltro {

    public static void ejecutaEjemploFiltros(List<Clima> climas) {

        ClimaDatos.imprimeEnunciado("(1) Filtrar usando filter: Radiación mayor que 10");
        List<Clima> climasFiltradosRadiacionAlta = climas
                .stream()
                .filter(clima -> clima.getRadiacion() > 10)
                .collect(Collectors.toList());
        ClimaDatos.imprimeClimas(climasFiltradosRadiacionAlta);

        ClimaDatos.imprimeEnunciado("(2) Filtrar usando filter: latitud > 2 y longitud > 1");
        BigDecimal latitudInicial = new BigDecimal("2");
        BigDecimal longitudInicial = new BigDecimal("1");
        List<Clima> climasFiltradosCuadranteCreciente = climas
                .stream()
                .filter(clima -> clima.getLatitud().compareTo(latitudInicial) > 0 && clima.getLongitud().compareTo(longitudInicial) > 0)
                .collect(Collectors.toList());
        ClimaDatos.imprimeClimas(climasFiltradosCuadranteCreciente);

        ClimaDatos.imprimeEnunciado("(3) Filtrar usando filter: Nombre sea Quito");
        Optional<Clima> climaFiltradosQuito = climas
                .stream()
                .filter(clima -> "QUITO".equals(clima.getNombreCiudad().toUpperCase()))
                .findFirst();
        ClimaDatos.imprimeClima(climaFiltradosQuito);
    }
}
