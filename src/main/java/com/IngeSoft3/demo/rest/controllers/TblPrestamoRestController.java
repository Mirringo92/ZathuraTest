package com.IngeSoft3.demo.rest.controllers;

import com.IngeSoft3.demo.dto.mapper.ITblPrestamoMapper;
import com.IngeSoft3.demo.modelo.*;
import com.IngeSoft3.demo.modelo.dto.TblPrestamoDTO;
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
@RequestMapping("/tblPrestamo")
public class TblPrestamoRestController {
    private static final Logger log = LoggerFactory.getLogger(TblPrestamoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ITblPrestamoMapper tblPrestamoMapper;

    @PostMapping(value = "/saveTblPrestamo")
    public void saveTblPrestamo(@RequestBody
    TblPrestamoDTO tblPrestamoDTO) throws Exception {
        try {
            TblPrestamo tblPrestamo = tblPrestamoMapper.tblPrestamoDTOToTblPrestamo(tblPrestamoDTO);

            businessDelegatorView.saveTblPrestamo(tblPrestamo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTblPrestamo/{idPrestamo}")
    public void deleteTblPrestamo(@PathVariable("idPrestamo")
    Long idPrestamo) throws Exception {
        try {
            TblPrestamo tblPrestamo = businessDelegatorView.getTblPrestamo(idPrestamo);

            businessDelegatorView.deleteTblPrestamo(tblPrestamo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTblPrestamo/")
    public void updateTblPrestamo(@RequestBody
    TblPrestamoDTO tblPrestamoDTO) throws Exception {
        try {
            TblPrestamo tblPrestamo = tblPrestamoMapper.tblPrestamoDTOToTblPrestamo(tblPrestamoDTO);

            businessDelegatorView.updateTblPrestamo(tblPrestamo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTblPrestamo")
    public List<TblPrestamoDTO> getDataTblPrestamo() throws Exception {
        try {
            return businessDelegatorView.getDataTblPrestamo();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTblPrestamo/{idPrestamo}")
    public TblPrestamoDTO getTblPrestamo(
        @PathVariable("idPrestamo")
    Long idPrestamo) throws Exception {
        try {
            TblPrestamo tblPrestamo = businessDelegatorView.getTblPrestamo(idPrestamo);

            return tblPrestamoMapper.tblPrestamoToTblPrestamoDTO(tblPrestamo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
