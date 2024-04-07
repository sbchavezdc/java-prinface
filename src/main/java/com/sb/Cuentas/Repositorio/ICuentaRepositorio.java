package com.sb.Cuentas.Repositorio;

import com.sb.Cuentas.Modelo.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICuentaRepositorio extends JpaRepository<Cuenta, Integer> {
}
