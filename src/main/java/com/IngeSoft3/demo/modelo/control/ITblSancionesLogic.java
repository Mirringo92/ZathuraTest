package com.IngeSoft3.demo.modelo.control;

import com.IngeSoft3.demo.modelo.TblSanciones;
import com.IngeSoft3.demo.modelo.dto.TblSancionesDTO;

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
public interface ITblSancionesLogic {
    public List<TblSanciones> getTblSanciones() throws Exception;

    /**
         * Save an new TblSanciones entity
         */
    public void saveTblSanciones(TblSanciones entity) throws Exception;

    /**
         * Delete an existing TblSanciones entity
         *
         */
    public void deleteTblSanciones(TblSanciones entity)
        throws Exception;

    /**
        * Update an existing TblSanciones entity
        *
        */
    public void updateTblSanciones(TblSanciones entity)
        throws Exception;

    /**
         * Load an existing TblSanciones entity
         *
         */
    public TblSanciones getTblSanciones(Long idSancion)
        throws Exception;

    public List<TblSanciones> findByCriteria(Object[] variables,
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
