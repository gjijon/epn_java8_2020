package net.flat.streams.actividad2;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import net.flat.streams.datos.UtilDatos;
import net.flat.streams.dto.Nomina;

/**
 *
 * @author gjijon
 */
public class T2ActividadCReduccion {

    public static void ejecutaOperacionReduccion(List<Nomina> datosNominaFiltrados) {
        UtilDatos.imprimeEnunciado("Entrando a reducir datos:");
        BigDecimal sumaTotalNomina = datosNominaFiltrados
                .parallelStream()
                .map(nomina -> nomina.getSueldo())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        UtilDatos.imprimeDato(Optional.of(String.format("Total a pagar de nómina este mes: USD $ %s", sumaTotalNomina.toString())));
    }
}
