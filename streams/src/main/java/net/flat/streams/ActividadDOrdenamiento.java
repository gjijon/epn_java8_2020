package net.flat.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import net.flat.streams.datos.ClimaDatos;
import net.flat.streams.dto.Clima;
import net.flat.streams.dto.comparadores.ClimaRadiacionComparador;

/**
 *
 * @author gjijon
 */
public class ActividadDOrdenamiento {

    public static void ejecutaEjemploOrdenamiento(List<Clima> climas) {

        ClimaDatos.imprimeEnunciado("Ordenamiento con comparable:");
        List<Clima> climasOrdenadosPorNombre = new ArrayList<>(climas);
        Collections.sort(climasOrdenadosPorNombre);
        ClimaDatos.imprimeClimas(climasOrdenadosPorNombre);

        ClimaDatos.imprimeEnunciado("Ordenamiento con comparator:");
        List<Clima> climasOrdenadosRadiacion = new ArrayList<>(climas);
        Collections.sort(climasOrdenadosRadiacion, new ClimaRadiacionComparador());
        ClimaDatos.imprimeClimas(climasOrdenadosRadiacion);

        ClimaDatos.imprimeEnunciado("Ordenamiento con Streams y dos campos:");
        List<Clima> climasOrdenadosPorLongitudYLatitud = climas
                .stream()
                .sorted(Comparator.comparing(Clima::getLongitud))
                .sorted(Comparator.comparing(Clima::getLatitud))
                .collect(Collectors.toList());
        ClimaDatos.imprimeClimas(climasOrdenadosPorLongitudYLatitud);

        ClimaDatos.imprimeEnunciado("Ordenamiento con Streams y dos campos (radiacion y luego nombre):");
        List<Clima> climasOrdenadosPorRadiacionYNombre = climas
                .stream()
                .sorted(Comparator.comparing(Clima::getRadiacion))
                .sorted(Comparator.comparing(Clima::getNombreCiudad))
                .collect(Collectors.toList());
        ClimaDatos.imprimeClimas(climasOrdenadosPorRadiacionYNombre);
    }
}
