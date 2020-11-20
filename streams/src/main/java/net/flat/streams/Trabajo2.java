package net.flat.streams;

import java.io.IOException;
import java.util.List;
import net.flat.streams.actividad2.T2ActividadALecturaArchivo;
import net.flat.streams.actividad2.T2ActividadBValidacionesArchivo;
import net.flat.streams.actividad2.T2ActividadCReduccion;
import net.flat.streams.datos.UtilDatos;
import net.flat.streams.dto.Nomina;

/**
 *
 * @author gjijon
 */
public class Trabajo2 {

    public static void main(String[] args) throws IOException {
        UtilDatos.imprimeEnunciado("TAREA 2");
        
        UtilDatos.imprimeEnunciado("Pregunta a) Leer un archivo que tenga como mínimo 20 líneas...");
        T2ActividadALecturaArchivo.ejecutaLecturaArchivo();

        UtilDatos.imprimeEnunciado("Pregunta b) Implementar tres validaciones para procesar esos valores, y con los registros válidos construirse una colección de objetos...");
        List<Nomina> datosFiltrados = T2ActividadBValidacionesArchivo.ejecutaValidacionesArchivo();
        
        UtilDatos.imprimeEnunciado("Pregunta c) Con la colección ejecutar una operación de reducción...");
        T2ActividadCReduccion.ejecutaOperacionReduccion(datosFiltrados);
    }
}
