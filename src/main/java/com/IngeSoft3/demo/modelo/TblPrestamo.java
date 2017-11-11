package com.IngeSoft3.demo.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "tbl_prestamo", schema = "public")
public class TblPrestamo implements java.io.Serializable {
    @NotNull
    private Long idPrestamo;
    @NotNull
    private Date fecha;
    private Date fechaFin;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String usuario;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String vencido;
    private Set<TblDetallePrestamo> tblDetallePrestamos = new HashSet<TblDetallePrestamo>(0);

    public TblPrestamo() {
    }

    public TblPrestamo(Long idPrestamo, Date fecha, Date fechaFin,
        Set<TblDetallePrestamo> tblDetallePrestamos, String usuario,
        String vencido) {
        this.idPrestamo = idPrestamo;
        this.fecha = fecha;
        this.fechaFin = fechaFin;
        this.usuario = usuario;
        this.vencido = vencido;
        this.tblDetallePrestamos = tblDetallePrestamos;
    }

    @Id
    @Column(name = "id_prestamo", unique = true, nullable = false)
    public Long getIdPrestamo() {
        return this.idPrestamo;
    }

    public void setIdPrestamo(Long idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    @Column(name = "fecha", nullable = false)
    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "fecha_fin")
    public Date getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Column(name = "usuario", nullable = false)
    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Column(name = "vencido", nullable = false)
    public String getVencido() {
        return this.vencido;
    }

    public void setVencido(String vencido) {
        this.vencido = vencido;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tblPrestamo")
    public Set<TblDetallePrestamo> getTblDetallePrestamos() {
        return this.tblDetallePrestamos;
    }

    public void setTblDetallePrestamos(
        Set<TblDetallePrestamo> tblDetallePrestamos) {
        this.tblDetallePrestamos = tblDetallePrestamos;
    }
}
