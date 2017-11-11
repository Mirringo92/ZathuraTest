package com.IngeSoft3.demo.modelo.control;

import com.IngeSoft3.demo.modelo.TblDetallePrestamo;
import com.IngeSoft3.demo.modelo.dto.TblDetallePrestamoDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ITblDetallePrestamoLogic {
    public List<TblDetallePrestamo> getTblDetallePrestamo()
        throws Exception;

    /**
         * Save an new TblDetallePrestamo entity
         */
    public void saveTblDetallePrestamo(TblDetallePrestamo entity)
        throws Exception;

    /**
         * Delete an existing TblDetallePrestamo entity
         *
         */
    public void deleteTblDetallePrestamo(TblDetallePrestamo entity)
        throws Exception;

    /**
        * Update an existing TblDetallePrestamo entity
        *
        */
    public void updateTblDetallePrestamo(TblDetallePrestamo entity)
        throws Exception;

    /**
         * Load an existing TblDetallePrestamo entity
         *
         */
    public TblDetallePrestamo getTblDetallePrestamo(Long idDetalle)
        throws Exception;

    public List<TblDetallePrestamo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TblDetallePrestamo> findPageTblDetallePrestamo(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTblDetallePrestamo() throws Exception;

    public List<TblDetallePrestamoDTO> getDataTblDetallePrestamo()
        throws Exception;

    public void validateTblDetallePrestamo(
        TblDetallePrestamo tblDetallePrestamo) throws Exception;
}
