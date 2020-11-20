package net.flat.streams.actividad1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import net.flat.streams.datos.UtilDatos;
import net.flat.streams.dto.Clima;
import net.flat.streams.dto.comparadores.ClimaRadiacionComparador;

/**
 *
 * @author gjijon
 */
public class T1ActividadDOrdenamiento {

    public static void ejecutaEjemploOrdenamiento(List<Clima> climas) {

        UtilDatos.imprimeEnunciado("Ordenamiento con comparable (por nombre de ciudad):");
        List<Clima> climasOrdenadosPorNombre = new ArrayList<>(climas);
        Collections.sort(climasOrdenadosPorNombre);
        UtilDatos.imprimeDatos(climasOrdenadosPorNombre);

        UtilDatos.imprimeEnunciado("Ordenamiento con comparator (por radiación) :");
        List<Clima> climasOrdenadosRadiacion = new ArrayList<>(climas);
        Collections.sort(climasOrdenadosRadiacion, new ClimaRadiacionComparador());
        UtilDatos.imprimeDatos(climasOrdenadosRadiacion);

        UtilDatos.imprimeEnunciado("Ordenamiento con Streams y dos campos (longitud y luego latitud):");
        List<Clima> climasOrdenadosPorLongitudYLatitud = climas
                .stream()
                .sorted(Comparator
                        .comparing(Clima::getLongitud)
                        .thenComparing(Clima::getLatitud)
                )
                .collect(Collectors.toList());
        UtilDatos.imprimeDatos(climasOrdenadosPorLongitudYLatitud);

        UtilDatos.imprimeEnunciado("Ordenamiento con Streams y dos campos (radiacion y luego nombre):");
        List<Clima> climasOrdenadosPorRadiacionYNombre = climas
                .stream()
                .sorted(Comparator
                        .comparing(Clima::getRadiacion)
                        .thenComparing(Clima::getNombreCiudad)
                )
                .collect(Collectors.toList());
        UtilDatos.imprimeDatos(climasOrdenadosPorRadiacionYNombre);
    }
}
