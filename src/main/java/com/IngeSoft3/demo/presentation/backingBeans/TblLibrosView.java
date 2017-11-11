package com.IngeSoft3.demo.presentation.backingBeans;

import com.IngeSoft3.demo.exceptions.*;
import com.IngeSoft3.demo.modelo.*;
import com.IngeSoft3.demo.modelo.dto.TblLibrosDTO;
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
public class TblLibrosView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TblLibrosView.class);
    private InputText txtAutor;
    private InputText txtDescripcionLibro;
    private InputText txtNombreLibro;
    private InputText txtIdLibro;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TblLibrosDTO> data;
    private TblLibrosDTO selectedTblLibros;
    private TblLibros entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public TblLibrosView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedTblLibros = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTblLibros = null;

        if (txtAutor != null) {
            txtAutor.setValue(null);
            txtAutor.setDisabled(true);
        }

        if (txtDescripcionLibro != null) {
            txtDescripcionLibro.setValue(null);
            txtDescripcionLibro.setDisabled(true);
        }

        if (txtNombreLibro != null) {
            txtNombreLibro.setValue(null);
            txtNombreLibro.setDisabled(true);
        }

        if (txtIdLibro != null) {
            txtIdLibro.setValue(null);
            txtIdLibro.setDisabled(false);
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
            Long idLibro = FacesUtils.checkLong(txtIdLibro);
            entity = (idLibro != null)
                ? businessDelegatorView.getTblLibros(idLibro) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtAutor.setDisabled(false);
            txtDescripcionLibro.setDisabled(false);
            txtNombreLibro.setDisabled(false);
            txtIdLibro.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtAutor.setValue(entity.getAutor());
            txtAutor.setDisabled(false);
            txtDescripcionLibro.setValue(entity.getDescripcionLibro());
            txtDescripcionLibro.setDisabled(false);
            txtNombreLibro.setValue(entity.getNombreLibro());
            txtNombreLibro.setDisabled(false);
            txtIdLibro.setValue(entity.getIdLibro());
            txtIdLibro.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTblLibros = (TblLibrosDTO) (evt.getComponent().getAttributes()
                                               .get("selectedTblLibros"));
        txtAutor.setValue(selectedTblLibros.getAutor());
        txtAutor.setDisabled(false);
        txtDescripcionLibro.setValue(selectedTblLibros.getDescripcionLibro());
        txtDescripcionLibro.setDisabled(false);
        txtNombreLibro.setValue(selectedTblLibros.getNombreLibro());
        txtNombreLibro.setDisabled(false);
        txtIdLibro.setValue(selectedTblLibros.getIdLibro());
        txtIdLibro.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTblLibros == null) && (entity == null)) {
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
            entity = new TblLibros();

            Long idLibro = FacesUtils.checkLong(txtIdLibro);

            entity.setAutor(FacesUtils.checkString(txtAutor));
            entity.setDescripcionLibro(FacesUtils.checkString(
                    txtDescripcionLibro));
            entity.setIdLibro(idLibro);
            entity.setNombreLibro(FacesUtils.checkString(txtNombreLibro));
            businessDelegatorView.saveTblLibros(entity);
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
                Long idLibro = new Long(selectedTblLibros.getIdLibro());
                entity = businessDelegatorView.getTblLibros(idLibro);
            }

            entity.setAutor(FacesUtils.checkString(txtAutor));
            entity.setDescripcionLibro(FacesUtils.checkString(
                    txtDescripcionLibro));
            entity.setNombreLibro(FacesUtils.checkString(txtNombreLibro));
            businessDelegatorView.updateTblLibros(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTblLibros = (TblLibrosDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedTblLibros"));

            Long idLibro = new Long(selectedTblLibros.getIdLibro());
            entity = businessDelegatorView.getTblLibros(idLibro);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long idLibro = FacesUtils.checkLong(txtIdLibro);
            entity = businessDelegatorView.getTblLibros(idLibro);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTblLibros(entity);
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

    public String action_modifyWitDTO(String autor, String descripcionLibro,
        Long idLibro, String nombreLibro) throws Exception {
        try {
            entity.setAutor(FacesUtils.checkString(autor));
            entity.setDescripcionLibro(FacesUtils.checkString(descripcionLibro));
            entity.setNombreLibro(FacesUtils.checkString(nombreLibro));
            businessDelegatorView.updateTblLibros(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TblLibrosView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtAutor() {
        return txtAutor;
    }

    public void setTxtAutor(InputText txtAutor) {
        this.txtAutor = txtAutor;
    }

    public InputText getTxtDescripcionLibro() {
        return txtDescripcionLibro;
    }

    public void setTxtDescripcionLibro(InputText txtDescripcionLibro) {
        this.txtDescripcionLibro = txtDescripcionLibro;
    }

    public InputText getTxtNombreLibro() {
        return txtNombreLibro;
    }

    public void setTxtNombreLibro(InputText txtNombreLibro) {
        this.txtNombreLibro = txtNombreLibro;
    }

    public InputText getTxtIdLibro() {
        return txtIdLibro;
    }

    public void setTxtIdLibro(InputText txtIdLibro) {
        this.txtIdLibro = txtIdLibro;
    }

    public List<TblLibrosDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTblLibros();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TblLibrosDTO> tblLibrosDTO) {
        this.data = tblLibrosDTO;
    }

    public TblLibrosDTO getSelectedTblLibros() {
        return selectedTblLibros;
    }

    public void setSelectedTblLibros(TblLibrosDTO tblLibros) {
        this.selectedTblLibros = tblLibros;
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
