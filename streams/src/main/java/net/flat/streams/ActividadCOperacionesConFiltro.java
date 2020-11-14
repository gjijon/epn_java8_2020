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

        ClimaDatos.imprimeEnunciado("Filtrar usando filter (1):");
        List<Clima> climasFiltradosRadiacionAlta = climas
                .stream()
                .filter(clima -> clima.getRadiacion() > 10)
                .collect(Collectors.toList());
        ClimaDatos.imprimeClimas(climasFiltradosRadiacionAlta);

        ClimaDatos.imprimeEnunciado("Filtrar usando filter (2):");
        BigDecimal latitudInicial = new BigDecimal("2");
        BigDecimal longitudInicial = new BigDecimal("1");
        List<Clima> climasFiltradosCuadranteCreciente = climas
                .stream()
                .filter(clima -> clima.getLongitud().compareTo(latitudInicial) > 0 && clima.getLongitud().compareTo(longitudInicial) > 0)
                .collect(Collectors.toList());
        ClimaDatos.imprimeClimas(climasFiltradosCuadranteCreciente);

        ClimaDatos.imprimeEnunciado("Filtrar usando filter (3):");
        Optional<Clima> climaFiltradosQuito = climas
                .stream()
                .filter(clima -> "QUITO".equals(clima.getNombreCiudad().toUpperCase()))
                .findFirst();
        ClimaDatos.imprimeClima(climaFiltradosQuito);
    }
}
