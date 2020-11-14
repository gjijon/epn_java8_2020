package net.flat.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import net.flat.streams.datos.ClimaDatos;
import net.flat.streams.dto.Clima;

/**
 *
 * @author gjijon
 */
public class ActividadEMideTiempo {

    public static void ejecutaEjemploMedicionTiempos(List<Clima> climas) {
        long tiempoInicial = System.currentTimeMillis();
        ClimaDatos.imprimeEnunciado("Midientdo tiempo de ordenamiento con Stream y dos campos (radiacion y luego nombre):");
        List<Clima> climasOrdenadosPorRadiacionYNombre = climas
                .stream()
                .sorted(Comparator
                        .comparing(Clima::getRadiacion)
                        .thenComparing(Clima::getNombreCiudad)
                )
                .collect(Collectors.toList());
        long tiempoFinal = System.currentTimeMillis() - tiempoInicial;
        System.out.println("Demoró: " + tiempoFinal);
        
        tiempoInicial = System.currentTimeMillis();
        ClimaDatos.imprimeEnunciado("Midientdo tiempo de ordenamiento con Parallel Stream y dos campos (radiacion y luego nombre):");
        climasOrdenadosPorRadiacionYNombre = climas
                .parallelStream()
                .sorted(Comparator
                        .comparing(Clima::getRadiacion)
                        .thenComparing(Clima::getNombreCiudad)
                )
                .collect(Collectors.toList());
        tiempoFinal = System.currentTimeMillis() - tiempoInicial;
        System.out.println("Demoró: " + tiempoFinal);
    }
}
