package com.IngeSoft3.demo.modelo.control;

import com.IngeSoft3.demo.modelo.TblPrestamo;
import com.IngeSoft3.demo.modelo.dto.TblPrestamoDTO;

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
public interface ITblPrestamoLogic {
    public List<TblPrestamo> getTblPrestamo() throws Exception;

    /**
         * Save an new TblPrestamo entity
         */
    public void saveTblPrestamo(TblPrestamo entity) throws Exception;

    /**
         * Delete an existing TblPrestamo entity
         *
         */
    public void deleteTblPrestamo(TblPrestamo entity) throws Exception;

    /**
        * Update an existing TblPrestamo entity
        *
        */
    public void updateTblPrestamo(TblPrestamo entity) throws Exception;

    /**
         * Load an existing TblPrestamo entity
         *
         */
    public TblPrestamo getTblPrestamo(Long idPrestamo)
        throws Exception;

    public List<TblPrestamo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TblPrestamo> findPageTblPrestamo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTblPrestamo() throws Exception;

    public List<TblPrestamoDTO> getDataTblPrestamo() throws Exception;

    public void validateTblPrestamo(TblPrestamo tblPrestamo)
        throws Exception;
}
