package com.IngeSoft3.demo.dto.mapper;

import com.IngeSoft3.demo.modelo.*;
import com.IngeSoft3.demo.modelo.TblSanciones;
import com.IngeSoft3.demo.modelo.control.*;
import com.IngeSoft3.demo.modelo.dto.TblSancionesDTO;

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
public class TblSancionesMapper implements ITblSancionesMapper {
    private static final Logger log = LoggerFactory.getLogger(TblSancionesMapper.class);

    /**
    * Logic injected by Spring that manages TblDetallePrestamo entities
    *
    */
    @Autowired
    ITblDetallePrestamoLogic logicTblDetallePrestamo1;

    @Transactional(readOnly = true)
    public TblSancionesDTO tblSancionesToTblSancionesDTO(
        TblSanciones tblSanciones) throws Exception {
        try {
            TblSancionesDTO tblSancionesDTO = new TblSancionesDTO();

            tblSancionesDTO.setIdSancion(tblSanciones.getIdSancion());
            tblSancionesDTO.setActivo((tblSanciones.getActivo() != null)
                ? tblSanciones.getActivo() : null);
            tblSancionesDTO.setIdDetalle_TblDetallePrestamo((tblSanciones.getTblDetallePrestamo()
                                                                         .getIdDetalle() != null)
                ? tblSanciones.getTblDetallePrestamo().getIdDetalle() : null);

            return tblSancionesDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TblSanciones tblSancionesDTOToTblSanciones(
        TblSancionesDTO tblSancionesDTO) throws Exception {
        try {
            TblSanciones tblSanciones = new TblSanciones();

            tblSanciones.setIdSancion(tblSancionesDTO.getIdSancion());
            tblSanciones.setActivo((tblSancionesDTO.getActivo() != null)
                ? tblSancionesDTO.getActivo() : null);

            TblDetallePrestamo tblDetallePrestamo = new TblDetallePrestamo();

            if (tblSancionesDTO.getIdDetalle_TblDetallePrestamo() != null) {
                tblDetallePrestamo = logicTblDetallePrestamo1.getTblDetallePrestamo(tblSancionesDTO.getIdDetalle_TblDetallePrestamo());
            }

            if (tblDetallePrestamo != null) {
                tblSanciones.setTblDetallePrestamo(tblDetallePrestamo);
            }

            return tblSanciones;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TblSancionesDTO> listTblSancionesToListTblSancionesDTO(
        List<TblSanciones> listTblSanciones) throws Exception {
        try {
            List<TblSancionesDTO> tblSancionesDTOs = new ArrayList<TblSancionesDTO>();

            for (TblSanciones tblSanciones : listTblSanciones) {
                TblSancionesDTO tblSancionesDTO = tblSancionesToTblSancionesDTO(tblSanciones);

                tblSancionesDTOs.add(tblSancionesDTO);
            }

            return tblSancionesDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TblSanciones> listTblSancionesDTOToListTblSanciones(
        List<TblSancionesDTO> listTblSancionesDTO) throws Exception {
        try {
            List<TblSanciones> listTblSanciones = new ArrayList<TblSanciones>();

            for (TblSancionesDTO tblSancionesDTO : listTblSancionesDTO) {
                TblSanciones tblSanciones = tblSancionesDTOToTblSanciones(tblSancionesDTO);

                listTblSanciones.add(tblSanciones);
            }

            return listTblSanciones;
        } catch (Exception e) {
            throw e;
        }
    }
}
