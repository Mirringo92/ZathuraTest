package com.IngeSoft3.demo.dto.mapper;

import com.IngeSoft3.demo.modelo.*;
import com.IngeSoft3.demo.modelo.TblDetallePrestamo;
import com.IngeSoft3.demo.modelo.control.*;
import com.IngeSoft3.demo.modelo.dto.TblDetallePrestamoDTO;

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
public class TblDetallePrestamoMapper implements ITblDetallePrestamoMapper {
    private static final Logger log = LoggerFactory.getLogger(TblDetallePrestamoMapper.class);

    /**
    * Logic injected by Spring that manages TblLibros entities
    *
    */
    @Autowired
    ITblLibrosLogic logicTblLibros1;

    /**
    * Logic injected by Spring that manages TblPrestamo entities
    *
    */
    @Autowired
    ITblPrestamoLogic logicTblPrestamo2;

    @Transactional(readOnly = true)
    public TblDetallePrestamoDTO tblDetallePrestamoToTblDetallePrestamoDTO(
        TblDetallePrestamo tblDetallePrestamo) throws Exception {
        try {
            TblDetallePrestamoDTO tblDetallePrestamoDTO = new TblDetallePrestamoDTO();

            tblDetallePrestamoDTO.setIdDetalle(tblDetallePrestamo.getIdDetalle());
            tblDetallePrestamoDTO.setActivo((tblDetallePrestamo.getActivo() != null)
                ? tblDetallePrestamo.getActivo() : null);
            tblDetallePrestamoDTO.setIdLibro_TblLibros((tblDetallePrestamo.getTblLibros()
                                                                          .getIdLibro() != null)
                ? tblDetallePrestamo.getTblLibros().getIdLibro() : null);
            tblDetallePrestamoDTO.setIdPrestamo_TblPrestamo((tblDetallePrestamo.getTblPrestamo()
                                                                               .getIdPrestamo() != null)
                ? tblDetallePrestamo.getTblPrestamo().getIdPrestamo() : null);

            return tblDetallePrestamoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TblDetallePrestamo tblDetallePrestamoDTOToTblDetallePrestamo(
        TblDetallePrestamoDTO tblDetallePrestamoDTO) throws Exception {
        try {
            TblDetallePrestamo tblDetallePrestamo = new TblDetallePrestamo();

            tblDetallePrestamo.setIdDetalle(tblDetallePrestamoDTO.getIdDetalle());
            tblDetallePrestamo.setActivo((tblDetallePrestamoDTO.getActivo() != null)
                ? tblDetallePrestamoDTO.getActivo() : null);

            TblLibros tblLibros = new TblLibros();

            if (tblDetallePrestamoDTO.getIdLibro_TblLibros() != null) {
                tblLibros = logicTblLibros1.getTblLibros(tblDetallePrestamoDTO.getIdLibro_TblLibros());
            }

            if (tblLibros != null) {
                tblDetallePrestamo.setTblLibros(tblLibros);
            }

            TblPrestamo tblPrestamo = new TblPrestamo();

            if (tblDetallePrestamoDTO.getIdPrestamo_TblPrestamo() != null) {
                tblPrestamo = logicTblPrestamo2.getTblPrestamo(tblDetallePrestamoDTO.getIdPrestamo_TblPrestamo());
            }

            if (tblPrestamo != null) {
                tblDetallePrestamo.setTblPrestamo(tblPrestamo);
            }

            return tblDetallePrestamo;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TblDetallePrestamoDTO> listTblDetallePrestamoToListTblDetallePrestamoDTO(
        List<TblDetallePrestamo> listTblDetallePrestamo)
        throws Exception {
        try {
            List<TblDetallePrestamoDTO> tblDetallePrestamoDTOs = new ArrayList<TblDetallePrestamoDTO>();

            for (TblDetallePrestamo tblDetallePrestamo : listTblDetallePrestamo) {
                TblDetallePrestamoDTO tblDetallePrestamoDTO = tblDetallePrestamoToTblDetallePrestamoDTO(tblDetallePrestamo);

                tblDetallePrestamoDTOs.add(tblDetallePrestamoDTO);
            }

            return tblDetallePrestamoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TblDetallePrestamo> listTblDetallePrestamoDTOToListTblDetallePrestamo(
        List<TblDetallePrestamoDTO> listTblDetallePrestamoDTO)
        throws Exception {
        try {
            List<TblDetallePrestamo> listTblDetallePrestamo = new ArrayList<TblDetallePrestamo>();

            for (TblDetallePrestamoDTO tblDetallePrestamoDTO : listTblDetallePrestamoDTO) {
                TblDetallePrestamo tblDetallePrestamo = tblDetallePrestamoDTOToTblDetallePrestamo(tblDetallePrestamoDTO);

                listTblDetallePrestamo.add(tblDetallePrestamo);
            }

            return listTblDetallePrestamo;
        } catch (Exception e) {
            throw e;
        }
    }
}
