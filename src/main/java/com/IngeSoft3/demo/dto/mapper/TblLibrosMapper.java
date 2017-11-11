package com.IngeSoft3.demo.dto.mapper;

import com.IngeSoft3.demo.modelo.*;
import com.IngeSoft3.demo.modelo.TblLibros;
import com.IngeSoft3.demo.modelo.control.*;
import com.IngeSoft3.demo.modelo.dto.TblLibrosDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class TblLibrosMapper implements ITblLibrosMapper {
    private static final Logger log = LoggerFactory.getLogger(TblLibrosMapper.class);

    @Transactional(readOnly = true)
    public TblLibrosDTO tblLibrosToTblLibrosDTO(TblLibros tblLibros)
        throws Exception {
        try {
            TblLibrosDTO tblLibrosDTO = new TblLibrosDTO();

            tblLibrosDTO.setIdLibro(tblLibros.getIdLibro());
            tblLibrosDTO.setAutor((tblLibros.getAutor() != null)
                ? tblLibros.getAutor() : null);
            tblLibrosDTO.setDescripcionLibro((tblLibros.getDescripcionLibro() != null)
                ? tblLibros.getDescripcionLibro() : null);
            tblLibrosDTO.setNombreLibro((tblLibros.getNombreLibro() != null)
                ? tblLibros.getNombreLibro() : null);

            return tblLibrosDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TblLibros tblLibrosDTOToTblLibros(TblLibrosDTO tblLibrosDTO)
        throws Exception {
        try {
            TblLibros tblLibros = new TblLibros();

            tblLibros.setIdLibro(tblLibrosDTO.getIdLibro());
            tblLibros.setAutor((tblLibrosDTO.getAutor() != null)
                ? tblLibrosDTO.getAutor() : null);
            tblLibros.setDescripcionLibro((tblLibrosDTO.getDescripcionLibro() != null)
                ? tblLibrosDTO.getDescripcionLibro() : null);
            tblLibros.setNombreLibro((tblLibrosDTO.getNombreLibro() != null)
                ? tblLibrosDTO.getNombreLibro() : null);

            return tblLibros;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TblLibrosDTO> listTblLibrosToListTblLibrosDTO(
        List<TblLibros> listTblLibros) throws Exception {
        try {
            List<TblLibrosDTO> tblLibrosDTOs = new ArrayList<TblLibrosDTO>();

            for (TblLibros tblLibros : listTblLibros) {
                TblLibrosDTO tblLibrosDTO = tblLibrosToTblLibrosDTO(tblLibros);

                tblLibrosDTOs.add(tblLibrosDTO);
            }

            return tblLibrosDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TblLibros> listTblLibrosDTOToListTblLibros(
        List<TblLibrosDTO> listTblLibrosDTO) throws Exception {
        try {
            List<TblLibros> listTblLibros = new ArrayList<TblLibros>();

            for (TblLibrosDTO tblLibrosDTO : listTblLibrosDTO) {
                TblLibros tblLibros = tblLibrosDTOToTblLibros(tblLibrosDTO);

                listTblLibros.add(tblLibros);
            }

            return listTblLibros;
        } catch (Exception e) {
            throw e;
        }
    }
}
