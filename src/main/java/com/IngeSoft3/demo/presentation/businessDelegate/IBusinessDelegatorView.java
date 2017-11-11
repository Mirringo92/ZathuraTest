package com.IngeSoft3.demo.presentation.businessDelegate;

import com.IngeSoft3.demo.modelo.TblDetallePrestamo;
import com.IngeSoft3.demo.modelo.TblLibros;
import com.IngeSoft3.demo.modelo.TblPrestamo;
import com.IngeSoft3.demo.modelo.TblSanciones;
import com.IngeSoft3.demo.modelo.control.ITblDetallePrestamoLogic;
import com.IngeSoft3.demo.modelo.control.ITblLibrosLogic;
import com.IngeSoft3.demo.modelo.control.ITblPrestamoLogic;
import com.IngeSoft3.demo.modelo.control.ITblSancionesLogic;
import com.IngeSoft3.demo.modelo.control.TblDetallePrestamoLogic;
import com.IngeSoft3.demo.modelo.control.TblLibrosLogic;
import com.IngeSoft3.demo.modelo.control.TblPrestamoLogic;
import com.IngeSoft3.demo.modelo.control.TblSancionesLogic;
import com.IngeSoft3.demo.modelo.dto.TblDetallePrestamoDTO;
import com.IngeSoft3.demo.modelo.dto.TblLibrosDTO;
import com.IngeSoft3.demo.modelo.dto.TblPrestamoDTO;
import com.IngeSoft3.demo.modelo.dto.TblSancionesDTO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IBusinessDelegatorView {
    public List<TblDetallePrestamo> getTblDetallePrestamo()
        throws Exception;

    public void saveTblDetallePrestamo(TblDetallePrestamo entity)
        throws Exception;

    public void deleteTblDetallePrestamo(TblDetallePrestamo entity)
        throws Exception;

    public void updateTblDetallePrestamo(TblDetallePrestamo entity)
        throws Exception;

    public TblDetallePrestamo getTblDetallePrestamo(Long idDetalle)
        throws Exception;

    public List<TblDetallePrestamo> findByCriteriaInTblDetallePrestamo(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<TblDetallePrestamo> findPageTblDetallePrestamo(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTblDetallePrestamo() throws Exception;

    public List<TblDetallePrestamoDTO> getDataTblDetallePrestamo()
        throws Exception;

    public void validateTblDetallePrestamo(
        TblDetallePrestamo tblDetallePrestamo) throws Exception;

    public List<TblLibros> getTblLibros() throws Exception;

    public void saveTblLibros(TblLibros entity) throws Exception;

    public void deleteTblLibros(TblLibros entity) throws Exception;

    public void updateTblLibros(TblLibros entity) throws Exception;

    public TblLibros getTblLibros(Long idLibro) throws Exception;

    public List<TblLibros> findByCriteriaInTblLibros(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TblLibros> findPageTblLibros(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTblLibros() throws Exception;

    public List<TblLibrosDTO> getDataTblLibros() throws Exception;

    public void validateTblLibros(TblLibros tblLibros)
        throws Exception;

    public List<TblPrestamo> getTblPrestamo() throws Exception;

    public void saveTblPrestamo(TblPrestamo entity) throws Exception;

    public void deleteTblPrestamo(TblPrestamo entity) throws Exception;

    public void updateTblPrestamo(TblPrestamo entity) throws Exception;

    public TblPrestamo getTblPrestamo(Long idPrestamo)
        throws Exception;

    public List<TblPrestamo> findByCriteriaInTblPrestamo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TblPrestamo> findPageTblPrestamo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTblPrestamo() throws Exception;

    public List<TblPrestamoDTO> getDataTblPrestamo() throws Exception;

    public void validateTblPrestamo(TblPrestamo tblPrestamo)
        throws Exception;

    public List<TblSanciones> getTblSanciones() throws Exception;

    public void saveTblSanciones(TblSanciones entity) throws Exception;

    public void deleteTblSanciones(TblSanciones entity)
        throws Exception;

    public void updateTblSanciones(TblSanciones entity)
        throws Exception;

    public TblSanciones getTblSanciones(Long idSancion)
        throws Exception;

    public List<TblSanciones> findByCriteriaInTblSanciones(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TblSanciones> findPageTblSanciones(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTblSanciones() throws Exception;

    public List<TblSancionesDTO> getDataTblSanciones()
        throws Exception;

    public void validateTblSanciones(TblSanciones tblSanciones)
        throws Exception;
}
