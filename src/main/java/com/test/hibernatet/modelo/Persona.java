/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.hibernatet.modelo;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author GERSON
 */
@Entity
@Table(name="persona")

public class Persona implements Serializable {

 @Id
 @SequenceGenerator(name="per_sec", sequenceName="sec_personas", allocationSize = 1 )
 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="per_sec")
 @Column(name="id")
 private Integer codigo;
  
 @Column (name="nombres")
 private String nombres;
 
 @Column (name="apellidos")
 private String apellidos;
 
 @Column (name="direccion")
 private String direccion;
 
 @Column (name="email")
 private String correo;
 
 @Column (name="dui")
 private String dui;
 
 @Column (name="tip_sangre")
 private String tipo_sangre;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getTipo_sangre() {
        return tipo_sangre;
    }

    public void setTipo_sangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }

    @Override
    public String toString() {
        return "{" + "codigo=" + codigo + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion + ", correo=" + correo + ", dui=" + dui + ", tipo_sangre=" + tipo_sangre + '}';
    }

  
    
    
    
}
