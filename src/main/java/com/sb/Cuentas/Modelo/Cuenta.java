package com.sb.Cuentas.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//esta es una anotacion para indicar que es un objeto que registra en la base de datos
//data nos ayuda a crear los metodos get y set de manera automatica
//constructor vacio esto es por la impelemtacion lambda
//constructor con todos los argumentos
//to string hacer la implementacion dde tosoa los atributos

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cuenta {
    //atributos de cuenta
    @Id
    //este emtodo es para generar el id de forma autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idCuenta;
    String nombre;
    String tipoCuenta;
    Double saldo;



}
