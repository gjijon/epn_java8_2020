/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.flat.streams.dto;

import java.math.BigDecimal;

/**
 *
 * @author gjijon
 */
public class Nomina {

    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private int edad;
    private BigDecimal sueldo;

    public Nomina() {
    }

    public Nomina(int id, String nombre, String apellido, String email, int edad, BigDecimal sueldo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
        this.sueldo = sueldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Nomina{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", edad=" + edad + ", sueldo=" + sueldo + '}';
    }

}
