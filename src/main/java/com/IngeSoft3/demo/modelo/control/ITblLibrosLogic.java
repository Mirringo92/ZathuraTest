package com.IngeSoft3.demo.modelo.control;

import com.IngeSoft3.demo.modelo.TblLibros;
import com.IngeSoft3.demo.modelo.dto.TblLibrosDTO;

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
public interface ITblLibrosLogic {
    public List<TblLibros> getTblLibros() throws Exception;

    /**
         * Save an new TblLibros entity
         */
    public void saveTblLibros(TblLibros entity) throws Exception;

    /**
         * Delete an existing TblLibros entity
         *
         */
    public void deleteTblLibros(TblLibros entity) throws Exception;

    /**
        * Update an existing TblLibros entity
        *
        */
    public void updateTblLibros(TblLibros entity) throws Exception;

    /**
         * Load an existing TblLibros entity
         *
         */
    public TblLibros getTblLibros(Long idLibro) throws Exception;

    public List<TblLibros> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TblLibros> findPageTblLibros(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTblLibros() throws Exception;

    public List<TblLibrosDTO> getDataTblLibros() throws Exception;

    public void validateTblLibros(TblLibros tblLibros)
        throws Exception;
}
