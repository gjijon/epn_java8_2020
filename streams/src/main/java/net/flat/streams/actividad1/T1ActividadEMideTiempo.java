package net.flat.streams.actividad1;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import net.flat.streams.datos.UtilDatos;
import net.flat.streams.dto.Clima;

/**
 *
 * @author gjijon
 */
public class T1ActividadEMideTiempo {

    public static void ejecutaEjemploMedicionTiempos(List<Clima> climas) {
        UtilDatos.imprimeEnunciado(String.format("Cantidad de datos de clima a usar: %s", String.valueOf(climas.size())));

        long tiempoInicial = System.currentTimeMillis();
        UtilDatos.imprimeEnunciado("Midientdo tiempo de ordenamiento con Stream y dos campos (radiacion y luego nombre):");
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
        UtilDatos.imprimeEnunciado("Midientdo tiempo de ordenamiento con Parallel Stream y dos campos (radiacion y luego nombre):");
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
