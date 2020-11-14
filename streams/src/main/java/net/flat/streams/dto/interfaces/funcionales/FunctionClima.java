package net.flat.streams.dto.interfaces.funcionales;

import net.flat.streams.dto.Clima;

/**
 *
 * @author gjijon
 */
@FunctionalInterface
public interface FunctionClima {

    public boolean filtrar(Clima climas);
}
