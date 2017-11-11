package com.IngeSoft3.demo.presentation.backingBeans;

import com.IngeSoft3.demo.exceptions.*;
import com.IngeSoft3.demo.modelo.*;
import com.IngeSoft3.demo.modelo.dto.TblSancionesDTO;
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
public class TblSancionesView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TblSancionesView.class);
    private InputText txtActivo;
    private InputText txtIdDetalle_TblDetallePrestamo;
    private InputText txtIdSancion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TblSancionesDTO> data;
    private TblSancionesDTO selectedTblSanciones;
    private TblSanciones entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public TblSancionesView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedTblSanciones = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTblSanciones = null;

        if (txtActivo != null) {
            txtActivo.setValue(null);
            txtActivo.setDisabled(true);
        }

        if (txtIdDetalle_TblDetallePrestamo != null) {
            txtIdDetalle_TblDetallePrestamo.setValue(null);
            txtIdDetalle_TblDetallePrestamo.setDisabled(true);
        }

        if (txtIdSancion != null) {
            txtIdSancion.setValue(null);
            txtIdSancion.setDisabled(false);
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
            Long idSancion = FacesUtils.checkLong(txtIdSancion);
            entity = (idSancion != null)
                ? businessDelegatorView.getTblSanciones(idSancion) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtActivo.setDisabled(false);
            txtIdDetalle_TblDetallePrestamo.setDisabled(false);
            txtIdSancion.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtActivo.setValue(entity.getActivo());
            txtActivo.setDisabled(false);
            txtIdDetalle_TblDetallePrestamo.setValue(entity.getTblDetallePrestamo()
                                                           .getIdDetalle());
            txtIdDetalle_TblDetallePrestamo.setDisabled(false);
            txtIdSancion.setValue(entity.getIdSancion());
            txtIdSancion.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTblSanciones = (TblSancionesDTO) (evt.getComponent()
                                                     .getAttributes()
                                                     .get("selectedTblSanciones"));
        txtActivo.setValue(selectedTblSanciones.getActivo());
        txtActivo.setDisabled(false);
        txtIdDetalle_TblDetallePrestamo.setValue(selectedTblSanciones.getIdDetalle_TblDetallePrestamo());
        txtIdDetalle_TblDetallePrestamo.setDisabled(false);
        txtIdSancion.setValue(selectedTblSanciones.getIdSancion());
        txtIdSancion.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTblSanciones == null) && (entity == null)) {
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
            entity = new TblSanciones();

            Long idSancion = FacesUtils.checkLong(txtIdSancion);

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setIdSancion(idSancion);
            entity.setTblDetallePrestamo((FacesUtils.checkLong(
                    txtIdDetalle_TblDetallePrestamo) != null)
                ? businessDelegatorView.getTblDetallePrestamo(
                    FacesUtils.checkLong(txtIdDetalle_TblDetallePrestamo)) : null);
            businessDelegatorView.saveTblSanciones(entity);
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
                Long idSancion = new Long(selectedTblSanciones.getIdSancion());
                entity = businessDelegatorView.getTblSanciones(idSancion);
            }

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setTblDetallePrestamo((FacesUtils.checkLong(
                    txtIdDetalle_TblDetallePrestamo) != null)
                ? businessDelegatorView.getTblDetallePrestamo(
                    FacesUtils.checkLong(txtIdDetalle_TblDetallePrestamo)) : null);
            businessDelegatorView.updateTblSanciones(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTblSanciones = (TblSancionesDTO) (evt.getComponent()
                                                         .getAttributes()
                                                         .get("selectedTblSanciones"));

            Long idSancion = new Long(selectedTblSanciones.getIdSancion());
            entity = businessDelegatorView.getTblSanciones(idSancion);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long idSancion = FacesUtils.checkLong(txtIdSancion);
            entity = businessDelegatorView.getTblSanciones(idSancion);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTblSanciones(entity);
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

    public String action_modifyWitDTO(String activo, Long idSancion,
        Long idDetalle_TblDetallePrestamo) throws Exception {
        try {
            entity.setActivo(FacesUtils.checkString(activo));
            businessDelegatorView.updateTblSanciones(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TblSancionesView").requestRender();
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

    public InputText getTxtIdDetalle_TblDetallePrestamo() {
        return txtIdDetalle_TblDetallePrestamo;
    }

    public void setTxtIdDetalle_TblDetallePrestamo(
        InputText txtIdDetalle_TblDetallePrestamo) {
        this.txtIdDetalle_TblDetallePrestamo = txtIdDetalle_TblDetallePrestamo;
    }

    public InputText getTxtIdSancion() {
        return txtIdSancion;
    }

    public void setTxtIdSancion(InputText txtIdSancion) {
        this.txtIdSancion = txtIdSancion;
    }

    public List<TblSancionesDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTblSanciones();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TblSancionesDTO> tblSancionesDTO) {
        this.data = tblSancionesDTO;
    }

    public TblSancionesDTO getSelectedTblSanciones() {
        return selectedTblSanciones;
    }

    public void setSelectedTblSanciones(TblSancionesDTO tblSanciones) {
        this.selectedTblSanciones = tblSanciones;
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
