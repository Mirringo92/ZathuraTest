package com.IngeSoft3.demo.dto.mapper;

import com.IngeSoft3.demo.modelo.TblSanciones;
import com.IngeSoft3.demo.modelo.dto.TblSancionesDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ITblSancionesMapper {
    public TblSancionesDTO tblSancionesToTblSancionesDTO(
        TblSanciones tblSanciones) throws Exception;

    public TblSanciones tblSancionesDTOToTblSanciones(
        TblSancionesDTO tblSancionesDTO) throws Exception;

    public List<TblSancionesDTO> listTblSancionesToListTblSancionesDTO(
        List<TblSanciones> tblSancioness) throws Exception;

    public List<TblSanciones> listTblSancionesDTOToListTblSanciones(
        List<TblSancionesDTO> tblSancionesDTOs) throws Exception;
}
