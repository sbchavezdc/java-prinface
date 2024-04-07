package com.sb.Cuentas.Controlador;


import com.sb.Cuentas.Modelo.Cuenta;
import com.sb.Cuentas.Servicio.ICuentaServicio;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
//el tiempo de la vista que vamos abtener miestras estemos en la pagina
@ViewScoped

public class IndexControlador {
    //este es el metodo para hacer la refrencia las sub clases deicuentas
@Autowired
    ICuentaServicio iCuentaServicio;
    private List <Cuenta> cuentas;
    private  Cuenta cuentaSeleccionada;
    private  static  final Logger logger = LoggerFactory.getLogger(IndexControlador.class);
    //cargar los datos de nuestra pagina
    @PostConstruct
    public  void  init(){
        cargarDatos();

    }

    public  void  cargarDatos(){
        //por esta linea se manda a imprimir en la consola los datos
        this.cuentas= iCuentaServicio.listaCuentas();
        cuentas.forEach((cuenta -> logger.info(cuenta.toString())));
    }

    public  void  agregarCuenta(){
        logger.info("Se creo objeto para el caso agregar");
        this.cuentaSeleccionada = new Cuenta();

    }
    public void guardarCuenta(){
        logger.info("Cuenta a guardar"+this.cuentaSeleccionada);
        //agregar
        if (this.cuentaSeleccionada.getIdCuenta()==null){
            this.iCuentaServicio.guardarCuenta(this.cuentaSeleccionada);
            this.cuentas.add(this.cuentaSeleccionada);
           FacesContext.getCurrentInstance().addMessage(null,
                   new FacesMessage("Cuenta Agregada"));
           //modificar
        }else {
            this.iCuentaServicio.guardarCuenta(this.cuentaSeleccionada);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Cuenta actualizada"));
        }
        //ocultar Ventana
        PrimeFaces.current().executeScript("PF('ventanaModalCuenta').hide()");
        //actualiza Tabla
        PrimeFaces.current().ajax().update("forma-cuentas:mensajes","forma-cuentas:cuentas-tabla");
        //reset de el objeto
        this.cuentaSeleccionada = null;

    }
    public void eliminarCuenta(){
        logger.info("Cuenta seleccionada"+ this.cuentaSeleccionada);
        this.iCuentaServicio.eliminarCuenta(this.cuentaSeleccionada);
        //eliminar registro cuentas
        this.cuentas.remove(this.cuentaSeleccionada);
        //reset el objeto
        this.cuentaSeleccionada= null;
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Cuenta eliminada"));
        PrimeFaces.current().ajax().update("formas-cuentas:mensajes","forma-cuentas:cuentas-tabla");

    }

}
