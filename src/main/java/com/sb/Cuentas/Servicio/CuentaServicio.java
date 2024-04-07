package com.sb.Cuentas.Servicio;

import com.sb.Cuentas.Modelo.Cuenta;
import com.sb.Cuentas.Repositorio.ICuentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service //es una notacion para la farica de sprint
public class CuentaServicio implements ICuentaServicio{

    @Autowired //implementacion de la interface de repositorio
    private ICuentaRepositorio iCuentaRepositorio;

    @Override
    public List<Cuenta> listaCuentas() {
        //regresa de la interfaz todos los campos
        return iCuentaRepositorio.findAll();
    }

    @Override
    public Cuenta buscarCuentaporId(Integer idCuenta) {
        Cuenta cuenta =iCuentaRepositorio.findById(idCuenta) .orElse(null);
        return cuenta;
    }

    @Override
    public void guardarCuenta(Cuenta cuenta) {
        iCuentaRepositorio.save(cuenta);

    }

    @Override
    public void eliminarCuenta(Cuenta cuenta) {
    iCuentaRepositorio.delete(cuenta);
    }

}
