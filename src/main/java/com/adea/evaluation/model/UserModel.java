package com.adea.evaluation.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.cglib.core.Local;

@Entity
public class UserModel {
    @Id
    @NotNull
    @Column(length = 20)
    private String login;

    @NotNull
    @Column(length = 170)
    private String password;

    @NotNull
    @Column(length = 50)
    private String nombre;

    @NotNull
    private float cliente;

    @Column(length = 45)
    private String email;

    @NotNull
    private LocalDate fechaAlta;

    private LocalDate fechaBaja;

    @NotNull
    private Character status;

    @NotNull
    private float intentos;

    private LocalDate fechaRevocado;

    private LocalDate fechaVigencia;

    private int noAcceso;

    @Column(length = 50)
    private String apellidoPaterno;

    @Column(length = 50)
    private String apellidoMaterno;

    // Check format
    private float area;

    @NotNull
    private LocalDate fechaModificacion;

    public UserModel() {
        this.setDefaultValues();
    }

    public UserModel(String login, String password, String nombre, float cliente){
        this.login = login;
        this.password = password;
        this.nombre = nombre;
        this.cliente = cliente;
        this.setDefaultValues();
    }

    private void setDefaultValues(){
        this.fechaAlta = LocalDate.now();
        this.status = 'A';
        this.intentos = 0;
        this.fechaModificacion = LocalDate.now();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCliente() {
        return cliente;
    }

    public void setCliente(float cliente) {
        this.cliente = cliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public float getIntentos() {
        return intentos;
    }

    public void setIntentos(float intentos) {
        this.intentos = intentos;
    }

    public LocalDate getFechaRevocado() {
        return fechaRevocado;
    }

    public void setFechaRevocado(LocalDate fechaRevocado) {
        this.fechaRevocado = fechaRevocado;
    }

    public LocalDate getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(LocalDate fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public int getNoAcceso() {
        return noAcceso;
    }

    public void setNoAcceso(int noAcceso) {
        this.noAcceso = noAcceso;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public LocalDate getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDate fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}
