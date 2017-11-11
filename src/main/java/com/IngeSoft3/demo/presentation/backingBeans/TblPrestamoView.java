package com.IngeSoft3.demo.presentation.backingBeans;

import com.IngeSoft3.demo.exceptions.*;
import com.IngeSoft3.demo.modelo.*;
import com.IngeSoft3.demo.modelo.dto.TblPrestamoDTO;
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
public class TblPrestamoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TblPrestamoView.class);
    private InputText txtUsuario;
    private InputText txtVencido;
    private InputText txtIdPrestamo;
    private Calendar txtFecha;
    private Calendar txtFechaFin;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TblPrestamoDTO> data;
    private TblPrestamoDTO selectedTblPrestamo;
    private TblPrestamo entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public TblPrestamoView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedTblPrestamo = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTblPrestamo = null;

        if (txtUsuario != null) {
            txtUsuario.setValue(null);
            txtUsuario.setDisabled(true);
        }

        if (txtVencido != null) {
            txtVencido.setValue(null);
            txtVencido.setDisabled(true);
        }

        if (txtFecha != null) {
            txtFecha.setValue(null);
            txtFecha.setDisabled(true);
        }

        if (txtFechaFin != null) {
            txtFechaFin.setValue(null);
            txtFechaFin.setDisabled(true);
        }

        if (txtIdPrestamo != null) {
            txtIdPrestamo.setValue(null);
            txtIdPrestamo.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtFecha() {
        Date inputDate = (Date) txtFecha.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtFechaFin() {
        Date inputDate = (Date) txtFechaFin.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Long idPrestamo = FacesUtils.checkLong(txtIdPrestamo);
            entity = (idPrestamo != null)
                ? businessDelegatorView.getTblPrestamo(idPrestamo) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtUsuario.setDisabled(false);
            txtVencido.setDisabled(false);
            txtFecha.setDisabled(false);
            txtFechaFin.setDisabled(false);
            txtIdPrestamo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtFecha.setValue(entity.getFecha());
            txtFecha.setDisabled(false);
            txtFechaFin.setValue(entity.getFechaFin());
            txtFechaFin.setDisabled(false);
            txtUsuario.setValue(entity.getUsuario());
            txtUsuario.setDisabled(false);
            txtVencido.setValue(entity.getVencido());
            txtVencido.setDisabled(false);
            txtIdPrestamo.setValue(entity.getIdPrestamo());
            txtIdPrestamo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTblPrestamo = (TblPrestamoDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedTblPrestamo"));
        txtFecha.setValue(selectedTblPrestamo.getFecha());
        txtFecha.setDisabled(false);
        txtFechaFin.setValue(selectedTblPrestamo.getFechaFin());
        txtFechaFin.setDisabled(false);
        txtUsuario.setValue(selectedTblPrestamo.getUsuario());
        txtUsuario.setDisabled(false);
        txtVencido.setValue(selectedTblPrestamo.getVencido());
        txtVencido.setDisabled(false);
        txtIdPrestamo.setValue(selectedTblPrestamo.getIdPrestamo());
        txtIdPrestamo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTblPrestamo == null) && (entity == null)) {
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
            entity = new TblPrestamo();

            Long idPrestamo = FacesUtils.checkLong(txtIdPrestamo);

            entity.setFecha(FacesUtils.checkDate(txtFecha));
            entity.setFechaFin(FacesUtils.checkDate(txtFechaFin));
            entity.setIdPrestamo(idPrestamo);
            entity.setUsuario(FacesUtils.checkString(txtUsuario));
            entity.setVencido(FacesUtils.checkString(txtVencido));
            businessDelegatorView.saveTblPrestamo(entity);
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
                Long idPrestamo = new Long(selectedTblPrestamo.getIdPrestamo());
                entity = businessDelegatorView.getTblPrestamo(idPrestamo);
            }

            entity.setFecha(FacesUtils.checkDate(txtFecha));
            entity.setFechaFin(FacesUtils.checkDate(txtFechaFin));
            entity.setUsuario(FacesUtils.checkString(txtUsuario));
            entity.setVencido(FacesUtils.checkString(txtVencido));
            businessDelegatorView.updateTblPrestamo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTblPrestamo = (TblPrestamoDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedTblPrestamo"));

            Long idPrestamo = new Long(selectedTblPrestamo.getIdPrestamo());
            entity = businessDelegatorView.getTblPrestamo(idPrestamo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long idPrestamo = FacesUtils.checkLong(txtIdPrestamo);
            entity = businessDelegatorView.getTblPrestamo(idPrestamo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTblPrestamo(entity);
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

    public String action_modifyWitDTO(Date fecha, Date fechaFin,
        Long idPrestamo, String usuario, String vencido)
        throws Exception {
        try {
            entity.setFecha(FacesUtils.checkDate(fecha));
            entity.setFechaFin(FacesUtils.checkDate(fechaFin));
            entity.setUsuario(FacesUtils.checkString(usuario));
            entity.setVencido(FacesUtils.checkString(vencido));
            businessDelegatorView.updateTblPrestamo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TblPrestamoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(InputText txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public InputText getTxtVencido() {
        return txtVencido;
    }

    public void setTxtVencido(InputText txtVencido) {
        this.txtVencido = txtVencido;
    }

    public Calendar getTxtFecha() {
        return txtFecha;
    }

    public void setTxtFecha(Calendar txtFecha) {
        this.txtFecha = txtFecha;
    }

    public Calendar getTxtFechaFin() {
        return txtFechaFin;
    }

    public void setTxtFechaFin(Calendar txtFechaFin) {
        this.txtFechaFin = txtFechaFin;
    }

    public InputText getTxtIdPrestamo() {
        return txtIdPrestamo;
    }

    public void setTxtIdPrestamo(InputText txtIdPrestamo) {
        this.txtIdPrestamo = txtIdPrestamo;
    }

    public List<TblPrestamoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTblPrestamo();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TblPrestamoDTO> tblPrestamoDTO) {
        this.data = tblPrestamoDTO;
    }

    public TblPrestamoDTO getSelectedTblPrestamo() {
        return selectedTblPrestamo;
    }

    public void setSelectedTblPrestamo(TblPrestamoDTO tblPrestamo) {
        this.selectedTblPrestamo = tblPrestamo;
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
