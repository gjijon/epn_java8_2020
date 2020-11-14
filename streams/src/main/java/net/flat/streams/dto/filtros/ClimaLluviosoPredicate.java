package net.flat.streams.dto.filtros;

import net.flat.streams.datos.ClimaDatos;
import net.flat.streams.dto.Clima;
import net.flat.streams.dto.interfaces.predicados.ClimaPredicate;

/**
 *
 * @author gjijon
 */
public class ClimaLluviosoPredicate implements ClimaPredicate {

    @Override
    public boolean filtrar(Clima clima) {
        return ClimaDatos.VAR_PRECIPITACIONES_LLUVIA.equals(clima.getPrecipitaciones());
    }

}
