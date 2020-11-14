package net.flat.streams.dto.filtros.behavior;

import java.util.ArrayList;
import java.util.List;
import net.flat.streams.datos.ClimaDatos;
import net.flat.streams.dto.Clima;
import net.flat.streams.dto.interfaces.predicados.ClimaPredicate;

/**
 *
 * @author gjijon
 */
public class FiltroClimaBehavior {

    public static List<Clima> filtrarClimaPorCieloSoleado(List<Clima> climas) {
        List<Clima> climasPorCiudadFiltrados = new ArrayList<>();
        for (Clima clima : climas) {
            if (ClimaDatos.VAR_PRECIPITACIONES_SOLEADO.equals(clima.getPrecipitaciones())) {
                climasPorCiudadFiltrados.add(clima);
            }
        }
        return climasPorCiudadFiltrados;
    }

    public static List<Clima> filtrarClimaPorCieloSoleado(List<Clima> climas, ClimaPredicate predicadoClima) {
        List<Clima> estudiantesRet = new ArrayList<>();
        for (Clima clima : climas) {
            if (predicadoClima.filtrar(clima)) {
                estudiantesRet.add(clima);
            }
        }
        return estudiantesRet;
    }
}
