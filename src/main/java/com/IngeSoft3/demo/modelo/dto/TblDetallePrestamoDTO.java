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
public class TblDetallePrestamoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TblDetallePrestamoDTO.class);
    private String activo;
    private Long idDetalle;
    private Long idLibro_TblLibros;
    private Long idPrestamo_TblPrestamo;

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Long getIdLibro_TblLibros() {
        return idLibro_TblLibros;
    }

    public void setIdLibro_TblLibros(Long idLibro_TblLibros) {
        this.idLibro_TblLibros = idLibro_TblLibros;
    }

    public Long getIdPrestamo_TblPrestamo() {
        return idPrestamo_TblPrestamo;
    }

    public void setIdPrestamo_TblPrestamo(Long idPrestamo_TblPrestamo) {
        this.idPrestamo_TblPrestamo = idPrestamo_TblPrestamo;
    }
}
