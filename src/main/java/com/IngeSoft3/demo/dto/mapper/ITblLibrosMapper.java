package com.IngeSoft3.demo.dto.mapper;

import com.IngeSoft3.demo.modelo.TblLibros;
import com.IngeSoft3.demo.modelo.dto.TblLibrosDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ITblLibrosMapper {
    public TblLibrosDTO tblLibrosToTblLibrosDTO(TblLibros tblLibros)
        throws Exception;

    public TblLibros tblLibrosDTOToTblLibros(TblLibrosDTO tblLibrosDTO)
        throws Exception;

    public List<TblLibrosDTO> listTblLibrosToListTblLibrosDTO(
        List<TblLibros> tblLibross) throws Exception;

    public List<TblLibros> listTblLibrosDTOToListTblLibros(
        List<TblLibrosDTO> tblLibrosDTOs) throws Exception;
}
