package com.IngeSoft3.demo.rest.controllers;

import com.IngeSoft3.demo.dto.mapper.ITblLibrosMapper;
import com.IngeSoft3.demo.modelo.*;
import com.IngeSoft3.demo.modelo.dto.TblLibrosDTO;
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
@RequestMapping("/tblLibros")
public class TblLibrosRestController {
    private static final Logger log = LoggerFactory.getLogger(TblLibrosRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ITblLibrosMapper tblLibrosMapper;

    @PostMapping(value = "/saveTblLibros")
    public void saveTblLibros(@RequestBody
    TblLibrosDTO tblLibrosDTO) throws Exception {
        try {
            TblLibros tblLibros = tblLibrosMapper.tblLibrosDTOToTblLibros(tblLibrosDTO);

            businessDelegatorView.saveTblLibros(tblLibros);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTblLibros/{idLibro}")
    public void deleteTblLibros(@PathVariable("idLibro")
    Long idLibro) throws Exception {
        try {
            TblLibros tblLibros = businessDelegatorView.getTblLibros(idLibro);

            businessDelegatorView.deleteTblLibros(tblLibros);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTblLibros/")
    public void updateTblLibros(@RequestBody
    TblLibrosDTO tblLibrosDTO) throws Exception {
        try {
            TblLibros tblLibros = tblLibrosMapper.tblLibrosDTOToTblLibros(tblLibrosDTO);

            businessDelegatorView.updateTblLibros(tblLibros);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTblLibros")
    public List<TblLibrosDTO> getDataTblLibros() throws Exception {
        try {
            return businessDelegatorView.getDataTblLibros();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTblLibros/{idLibro}")
    public TblLibrosDTO getTblLibros(@PathVariable("idLibro")
    Long idLibro) throws Exception {
        try {
            TblLibros tblLibros = businessDelegatorView.getTblLibros(idLibro);

            return tblLibrosMapper.tblLibrosToTblLibrosDTO(tblLibros);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
