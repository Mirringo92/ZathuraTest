package com.IngeSoft3.demo.rest.controllers;

import com.IngeSoft3.demo.dto.mapper.ITblSancionesMapper;
import com.IngeSoft3.demo.modelo.*;
import com.IngeSoft3.demo.modelo.dto.TblSancionesDTO;
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
@RequestMapping("/tblSanciones")
public class TblSancionesRestController {
    private static final Logger log = LoggerFactory.getLogger(TblSancionesRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ITblSancionesMapper tblSancionesMapper;

    @PostMapping(value = "/saveTblSanciones")
    public void saveTblSanciones(@RequestBody
    TblSancionesDTO tblSancionesDTO) throws Exception {
        try {
            TblSanciones tblSanciones = tblSancionesMapper.tblSancionesDTOToTblSanciones(tblSancionesDTO);

            businessDelegatorView.saveTblSanciones(tblSanciones);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTblSanciones/{idSancion}")
    public void deleteTblSanciones(@PathVariable("idSancion")
    Long idSancion) throws Exception {
        try {
            TblSanciones tblSanciones = businessDelegatorView.getTblSanciones(idSancion);

            businessDelegatorView.deleteTblSanciones(tblSanciones);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTblSanciones/")
    public void updateTblSanciones(@RequestBody
    TblSancionesDTO tblSancionesDTO) throws Exception {
        try {
            TblSanciones tblSanciones = tblSancionesMapper.tblSancionesDTOToTblSanciones(tblSancionesDTO);

            businessDelegatorView.updateTblSanciones(tblSanciones);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTblSanciones")
    public List<TblSancionesDTO> getDataTblSanciones()
        throws Exception {
        try {
            return businessDelegatorView.getDataTblSanciones();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTblSanciones/{idSancion}")
    public TblSancionesDTO getTblSanciones(
        @PathVariable("idSancion")
    Long idSancion) throws Exception {
        try {
            TblSanciones tblSanciones = businessDelegatorView.getTblSanciones(idSancion);

            return tblSancionesMapper.tblSancionesToTblSancionesDTO(tblSanciones);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
