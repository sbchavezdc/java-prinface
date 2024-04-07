package com.sb.Cuentas.Servicio;

import com.sb.Cuentas.Modelo.Cuenta;

import java.util.List;

public interface ICuentaServicio {
    public List<Cuenta> listaCuentas();

    public  Cuenta buscarCuentaporId(Integer idCuenta);
    public  void  guardarCuenta (Cuenta cuenta);
    public  void  eliminarCuenta(Cuenta cuenta);


}
