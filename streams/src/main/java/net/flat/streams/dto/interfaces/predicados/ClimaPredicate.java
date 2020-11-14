package net.flat.streams.dto.interfaces.predicados;

import net.flat.streams.dto.Clima;

/**
 *
 * @author gjijon
 */
@FunctionalInterface
public interface ClimaPredicate {

    public boolean filtrar(Clima clima);
}
