package com.IngeSoft3.demo.dto.mapper;

import com.IngeSoft3.demo.modelo.TblPrestamo;
import com.IngeSoft3.demo.modelo.dto.TblPrestamoDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ITblPrestamoMapper {
    public TblPrestamoDTO tblPrestamoToTblPrestamoDTO(TblPrestamo tblPrestamo)
        throws Exception;

    public TblPrestamo tblPrestamoDTOToTblPrestamo(
        TblPrestamoDTO tblPrestamoDTO) throws Exception;

    public List<TblPrestamoDTO> listTblPrestamoToListTblPrestamoDTO(
        List<TblPrestamo> tblPrestamos) throws Exception;

    public List<TblPrestamo> listTblPrestamoDTOToListTblPrestamo(
        List<TblPrestamoDTO> tblPrestamoDTOs) throws Exception;
}
