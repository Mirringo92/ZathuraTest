package com.IngeSoft3.demo.presentation.backingBeans;

import com.IngeSoft3.demo.exceptions.*;
import com.IngeSoft3.demo.modelo.*;
import com.IngeSoft3.demo.modelo.dto.TblDetallePrestamoDTO;
import com.IngeSoft3.demo.presentation.businessDelegate.*;
import com.IngeSoft3.demo.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class TblDetallePrestamoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TblDetallePrestamoView.class);
    private InputText txtActivo;
    private InputText txtIdLibro_TblLibros;
    private InputText txtIdPrestamo_TblPrestamo;
    private InputText txtIdDetalle;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TblDetallePrestamoDTO> data;
    private TblDetallePrestamoDTO selectedTblDetallePrestamo;
    private TblDetallePrestamo entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public TblDetallePrestamoView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedTblDetallePrestamo = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTblDetallePrestamo = null;

        if (txtActivo != null) {
            txtActivo.setValue(null);
            txtActivo.setDisabled(true);
        }

        if (txtIdLibro_TblLibros != null) {
            txtIdLibro_TblLibros.setValue(null);
            txtIdLibro_TblLibros.setDisabled(true);
        }

        if (txtIdPrestamo_TblPrestamo != null) {
            txtIdPrestamo_TblPrestamo.setValue(null);
            txtIdPrestamo_TblPrestamo.setDisabled(true);
        }

        if (txtIdDetalle != null) {
            txtIdDetalle.setValue(null);
            txtIdDetalle.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtId() {
        try {
            Long idDetalle = FacesUtils.checkLong(txtIdDetalle);
            entity = (idDetalle != null)
                ? businessDelegatorView.getTblDetallePrestamo(idDetalle) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtActivo.setDisabled(false);
            txtIdLibro_TblLibros.setDisabled(false);
            txtIdPrestamo_TblPrestamo.setDisabled(false);
            txtIdDetalle.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtActivo.setValue(entity.getActivo());
            txtActivo.setDisabled(false);
            txtIdLibro_TblLibros.setValue(entity.getTblLibros().getIdLibro());
            txtIdLibro_TblLibros.setDisabled(false);
            txtIdPrestamo_TblPrestamo.setValue(entity.getTblPrestamo()
                                                     .getIdPrestamo());
            txtIdPrestamo_TblPrestamo.setDisabled(false);
            txtIdDetalle.setValue(entity.getIdDetalle());
            txtIdDetalle.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTblDetallePrestamo = (TblDetallePrestamoDTO) (evt.getComponent()
                                                                 .getAttributes()
                                                                 .get("selectedTblDetallePrestamo"));
        txtActivo.setValue(selectedTblDetallePrestamo.getActivo());
        txtActivo.setDisabled(false);
        txtIdLibro_TblLibros.setValue(selectedTblDetallePrestamo.getIdLibro_TblLibros());
        txtIdLibro_TblLibros.setDisabled(false);
        txtIdPrestamo_TblPrestamo.setValue(selectedTblDetallePrestamo.getIdPrestamo_TblPrestamo());
        txtIdPrestamo_TblPrestamo.setDisabled(false);
        txtIdDetalle.setValue(selectedTblDetallePrestamo.getIdDetalle());
        txtIdDetalle.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTblDetallePrestamo == null) && (entity == null)) {
                action_create();
            } else {
                action_modify();
            }

            data = null;
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_create() {
        try {
            entity = new TblDetallePrestamo();

            Long idDetalle = FacesUtils.checkLong(txtIdDetalle);

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setIdDetalle(idDetalle);
            entity.setTblLibros((FacesUtils.checkLong(txtIdLibro_TblLibros) != null)
                ? businessDelegatorView.getTblLibros(FacesUtils.checkLong(
                        txtIdLibro_TblLibros)) : null);
            entity.setTblPrestamo((FacesUtils.checkLong(
                    txtIdPrestamo_TblPrestamo) != null)
                ? businessDelegatorView.getTblPrestamo(FacesUtils.checkLong(
                        txtIdPrestamo_TblPrestamo)) : null);
            businessDelegatorView.saveTblDetallePrestamo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            entity = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            if (entity == null) {
                Long idDetalle = new Long(selectedTblDetallePrestamo.getIdDetalle());
                entity = businessDelegatorView.getTblDetallePrestamo(idDetalle);
            }

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setTblLibros((FacesUtils.checkLong(txtIdLibro_TblLibros) != null)
                ? businessDelegatorView.getTblLibros(FacesUtils.checkLong(
                        txtIdLibro_TblLibros)) : null);
            entity.setTblPrestamo((FacesUtils.checkLong(
                    txtIdPrestamo_TblPrestamo) != null)
                ? businessDelegatorView.getTblPrestamo(FacesUtils.checkLong(
                        txtIdPrestamo_TblPrestamo)) : null);
            businessDelegatorView.updateTblDetallePrestamo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTblDetallePrestamo = (TblDetallePrestamoDTO) (evt.getComponent()
                                                                     .getAttributes()
                                                                     .get("selectedTblDetallePrestamo"));

            Long idDetalle = new Long(selectedTblDetallePrestamo.getIdDetalle());
            entity = businessDelegatorView.getTblDetallePrestamo(idDetalle);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long idDetalle = FacesUtils.checkLong(txtIdDetalle);
            entity = businessDelegatorView.getTblDetallePrestamo(idDetalle);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTblDetallePrestamo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data = null;
        } catch (Exception e) {
            throw e;
        }
    }

    public String action_closeDialog() {
        setShowDialog(false);
        action_clear();

        return "";
    }

    public String action_modifyWitDTO(String activo, Long idDetalle,
        Long idLibro_TblLibros, Long idPrestamo_TblPrestamo)
        throws Exception {
        try {
            entity.setActivo(FacesUtils.checkString(activo));
            businessDelegatorView.updateTblDetallePrestamo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TblDetallePrestamoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtActivo() {
        return txtActivo;
    }

    public void setTxtActivo(InputText txtActivo) {
        this.txtActivo = txtActivo;
    }

    public InputText getTxtIdLibro_TblLibros() {
        return txtIdLibro_TblLibros;
    }

    public void setTxtIdLibro_TblLibros(InputText txtIdLibro_TblLibros) {
        this.txtIdLibro_TblLibros = txtIdLibro_TblLibros;
    }

    public InputText getTxtIdPrestamo_TblPrestamo() {
        return txtIdPrestamo_TblPrestamo;
    }

    public void setTxtIdPrestamo_TblPrestamo(
        InputText txtIdPrestamo_TblPrestamo) {
        this.txtIdPrestamo_TblPrestamo = txtIdPrestamo_TblPrestamo;
    }

    public InputText getTxtIdDetalle() {
        return txtIdDetalle;
    }

    public void setTxtIdDetalle(InputText txtIdDetalle) {
        this.txtIdDetalle = txtIdDetalle;
    }

    public List<TblDetallePrestamoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTblDetallePrestamo();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TblDetallePrestamoDTO> tblDetallePrestamoDTO) {
        this.data = tblDetallePrestamoDTO;
    }

    public TblDetallePrestamoDTO getSelectedTblDetallePrestamo() {
        return selectedTblDetallePrestamo;
    }

    public void setSelectedTblDetallePrestamo(
        TblDetallePrestamoDTO tblDetallePrestamo) {
        this.selectedTblDetallePrestamo = tblDetallePrestamo;
    }

    public CommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(CommandButton btnSave) {
        this.btnSave = btnSave;
    }

    public CommandButton getBtnModify() {
        return btnModify;
    }

    public void setBtnModify(CommandButton btnModify) {
        this.btnModify = btnModify;
    }

    public CommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(CommandButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public CommandButton getBtnClear() {
        return btnClear;
    }

    public void setBtnClear(CommandButton btnClear) {
        this.btnClear = btnClear;
    }

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }

    public IBusinessDelegatorView getBusinessDelegatorView() {
        return businessDelegatorView;
    }

    public void setBusinessDelegatorView(
        IBusinessDelegatorView businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }
}
