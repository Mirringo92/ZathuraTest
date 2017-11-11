package com.IngeSoft3.demo.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class TblSancionesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TblSancionesDTO.class);
    private String activo;
    private Long idSancion;
    private Long idDetalle_TblDetallePrestamo;

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Long getIdSancion() {
        return idSancion;
    }

    public void setIdSancion(Long idSancion) {
        this.idSancion = idSancion;
    }

    public Long getIdDetalle_TblDetallePrestamo() {
        return idDetalle_TblDetallePrestamo;
    }

    public void setIdDetalle_TblDetallePrestamo(
        Long idDetalle_TblDetallePrestamo) {
        this.idDetalle_TblDetallePrestamo = idDetalle_TblDetallePrestamo;
    }
}
