package com.IngeSoft3.demo.rest.controllers;

import com.IngeSoft3.demo.dto.mapper.ITblDetallePrestamoMapper;
import com.IngeSoft3.demo.modelo.*;
import com.IngeSoft3.demo.modelo.dto.TblDetallePrestamoDTO;
import com.IngeSoft3.demo.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/tblDetallePrestamo")
public class TblDetallePrestamoRestController {
    private static final Logger log = LoggerFactory.getLogger(TblDetallePrestamoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ITblDetallePrestamoMapper tblDetallePrestamoMapper;

    @PostMapping(value = "/saveTblDetallePrestamo")
    public void saveTblDetallePrestamo(
        @RequestBody
    TblDetallePrestamoDTO tblDetallePrestamoDTO) throws Exception {
        try {
            TblDetallePrestamo tblDetallePrestamo = tblDetallePrestamoMapper.tblDetallePrestamoDTOToTblDetallePrestamo(tblDetallePrestamoDTO);

            businessDelegatorView.saveTblDetallePrestamo(tblDetallePrestamo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTblDetallePrestamo/{idDetalle}")
    public void deleteTblDetallePrestamo(
        @PathVariable("idDetalle")
    Long idDetalle) throws Exception {
        try {
            TblDetallePrestamo tblDetallePrestamo = businessDelegatorView.getTblDetallePrestamo(idDetalle);

            businessDelegatorView.deleteTblDetallePrestamo(tblDetallePrestamo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTblDetallePrestamo/")
    public void updateTblDetallePrestamo(
        @RequestBody
    TblDetallePrestamoDTO tblDetallePrestamoDTO) throws Exception {
        try {
            TblDetallePrestamo tblDetallePrestamo = tblDetallePrestamoMapper.tblDetallePrestamoDTOToTblDetallePrestamo(tblDetallePrestamoDTO);

            businessDelegatorView.updateTblDetallePrestamo(tblDetallePrestamo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTblDetallePrestamo")
    public List<TblDetallePrestamoDTO> getDataTblDetallePrestamo()
        throws Exception {
        try {
            return businessDelegatorView.getDataTblDetallePrestamo();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTblDetallePrestamo/{idDetalle}")
    public TblDetallePrestamoDTO getTblDetallePrestamo(
        @PathVariable("idDetalle")
    Long idDetalle) throws Exception {
        try {
            TblDetallePrestamo tblDetallePrestamo = businessDelegatorView.getTblDetallePrestamo(idDetalle);

            return tblDetallePrestamoMapper.tblDetallePrestamoToTblDetallePrestamoDTO(tblDetallePrestamo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
