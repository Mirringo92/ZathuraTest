package com.IngeSoft3.demo.dto.mapper;

import com.IngeSoft3.demo.modelo.TblDetallePrestamo;
import com.IngeSoft3.demo.modelo.dto.TblDetallePrestamoDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ITblDetallePrestamoMapper {
    public TblDetallePrestamoDTO tblDetallePrestamoToTblDetallePrestamoDTO(
        TblDetallePrestamo tblDetallePrestamo) throws Exception;

    public TblDetallePrestamo tblDetallePrestamoDTOToTblDetallePrestamo(
        TblDetallePrestamoDTO tblDetallePrestamoDTO) throws Exception;

    public List<TblDetallePrestamoDTO> listTblDetallePrestamoToListTblDetallePrestamoDTO(
        List<TblDetallePrestamo> tblDetallePrestamos) throws Exception;

    public List<TblDetallePrestamo> listTblDetallePrestamoDTOToListTblDetallePrestamo(
        List<TblDetallePrestamoDTO> tblDetallePrestamoDTOs)
        throws Exception;
}
