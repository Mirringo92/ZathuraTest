package com.IngeSoft3.demo.dto.mapper;

import com.IngeSoft3.demo.modelo.*;
import com.IngeSoft3.demo.modelo.TblPrestamo;
import com.IngeSoft3.demo.modelo.control.*;
import com.IngeSoft3.demo.modelo.dto.TblPrestamoDTO;

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
public class TblPrestamoMapper implements ITblPrestamoMapper {
    private static final Logger log = LoggerFactory.getLogger(TblPrestamoMapper.class);

    @Transactional(readOnly = true)
    public TblPrestamoDTO tblPrestamoToTblPrestamoDTO(TblPrestamo tblPrestamo)
        throws Exception {
        try {
            TblPrestamoDTO tblPrestamoDTO = new TblPrestamoDTO();

            tblPrestamoDTO.setIdPrestamo(tblPrestamo.getIdPrestamo());
            tblPrestamoDTO.setFecha(tblPrestamo.getFecha());
            tblPrestamoDTO.setFechaFin(tblPrestamo.getFechaFin());
            tblPrestamoDTO.setUsuario((tblPrestamo.getUsuario() != null)
                ? tblPrestamo.getUsuario() : null);
            tblPrestamoDTO.setVencido((tblPrestamo.getVencido() != null)
                ? tblPrestamo.getVencido() : null);

            return tblPrestamoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TblPrestamo tblPrestamoDTOToTblPrestamo(
        TblPrestamoDTO tblPrestamoDTO) throws Exception {
        try {
            TblPrestamo tblPrestamo = new TblPrestamo();

            tblPrestamo.setIdPrestamo(tblPrestamoDTO.getIdPrestamo());
            tblPrestamo.setFecha(tblPrestamoDTO.getFecha());
            tblPrestamo.setFechaFin(tblPrestamoDTO.getFechaFin());
            tblPrestamo.setUsuario((tblPrestamoDTO.getUsuario() != null)
                ? tblPrestamoDTO.getUsuario() : null);
            tblPrestamo.setVencido((tblPrestamoDTO.getVencido() != null)
                ? tblPrestamoDTO.getVencido() : null);

            return tblPrestamo;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TblPrestamoDTO> listTblPrestamoToListTblPrestamoDTO(
        List<TblPrestamo> listTblPrestamo) throws Exception {
        try {
            List<TblPrestamoDTO> tblPrestamoDTOs = new ArrayList<TblPrestamoDTO>();

            for (TblPrestamo tblPrestamo : listTblPrestamo) {
                TblPrestamoDTO tblPrestamoDTO = tblPrestamoToTblPrestamoDTO(tblPrestamo);

                tblPrestamoDTOs.add(tblPrestamoDTO);
            }

            return tblPrestamoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TblPrestamo> listTblPrestamoDTOToListTblPrestamo(
        List<TblPrestamoDTO> listTblPrestamoDTO) throws Exception {
        try {
            List<TblPrestamo> listTblPrestamo = new ArrayList<TblPrestamo>();

            for (TblPrestamoDTO tblPrestamoDTO : listTblPrestamoDTO) {
                TblPrestamo tblPrestamo = tblPrestamoDTOToTblPrestamo(tblPrestamoDTO);

                listTblPrestamo.add(tblPrestamo);
            }

            return listTblPrestamo;
        } catch (Exception e) {
            throw e;
        }
    }
}
