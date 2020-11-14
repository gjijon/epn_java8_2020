package net.flat.streams.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author gjijon
 */
public class Clima implements Comparable<Clima> {

    private String nombreCiudad;
    private Date fecha;
    private String precipitaciones;
    private BigDecimal longitud;
    private BigDecimal latitud;
    private int radiacion;

    public Clima(String nombreCiudad, Date fecha, String precipitaciones, BigDecimal longitud, BigDecimal latitud, int radiacion) {
        this.nombreCiudad = nombreCiudad;
        this.fecha = fecha;
        this.precipitaciones = precipitaciones;
        this.longitud = longitud;
        this.latitud = latitud;
        this.radiacion = radiacion;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPrecipitaciones() {
        return precipitaciones;
    }

    public void setPrecipitaciones(String precipitaciones) {
        this.precipitaciones = precipitaciones;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public int getRadiacion() {
        return radiacion;
    }

    public void setRadiacion(int radiacion) {
        this.radiacion = radiacion;
    }

    @Override
    public int hashCode() {
        return this.nombreCiudad.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Clima other = (Clima) obj;
        if (this.radiacion != other.radiacion) {
            return false;
        }
        if (!Objects.equals(this.nombreCiudad, other.nombreCiudad)) {
            return false;
        }
        if (!Objects.equals(this.precipitaciones, other.precipitaciones)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.longitud, other.longitud)) {
            return false;
        }
        if (!Objects.equals(this.latitud, other.latitud)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clima{" + "nombreCiudad=" + nombreCiudad + ", fecha=" + fecha + ", precipitaciones=" + precipitaciones + ", longitud=" + longitud + ", latitud=" + latitud + ", radiacion=" + radiacion + '}';
    }

    @Override
    public int compareTo(Clima o) {
        return this.getNombreCiudad().compareTo(o.getNombreCiudad());
    }

}
