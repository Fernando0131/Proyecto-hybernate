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
 * @author FERNANDO
 */
@Entity
@Table(name="CUENTA")

public class CUENTA implements Serializable {

 @Id
 @SequenceGenerator(name="CUE_seq", sequenceName="seq_CUENTA", allocationSize = 1 )
 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CUE_seq")
 @Column(name="ID")
 private Integer codigo;
  
 @Column (name="NOMBRE_CUENTA")
 private String NOMBRE_CUENTA;
 
 @Column (name="FECHA")
 private String FECHA;
 
 @Column (name="CUENTA_1")
 private Integer CUENTA_1;
 
 @Column (name="CUENTA_2")
 private Integer CUENTA_2;
 

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return NOMBRE_CUENTA;
    }

    public void setNombres(String nombres) {
        this.NOMBRE_CUENTA = nombres;
    }

    public String getFecha() {
        return FECHA;
    }

    public void setFecha(String fechas) {
        this.FECHA = fechas;
    }

    public Integer getCuenta_1() {
        return CUENTA_1;
    }

    public void setCuenta_1(Integer cuenta_1) {
        this.CUENTA_1 = cuenta_1;
    }

    public Integer getCuenta_2() {
        return CUENTA_2;
    }

    public void setCuenta_2(Integer cuenta_2) {
        this.CUENTA_2 = cuenta_2;
    }


    @Override
    public String toString() {
        return "{" + "codigo=" + codigo + ", nombre_cuenta=" + NOMBRE_CUENTA + ", fecha=" + FECHA + ", cuenta_1=" + CUENTA_1 + ", cuenta_2=" + CUENTA_2 + '}';
    }

    public void setCuenta_1(String cuenta_1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setCuenta_2(String cuenta_2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
    
    
}

    

