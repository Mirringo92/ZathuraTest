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
@Table(name = "tbl_detalle_prestamo", schema = "public")
public class TblDetallePrestamo implements java.io.Serializable {
    @NotNull
    private Long idDetalle;
    @NotNull
    private TblLibros tblLibros;
    @NotNull
    private TblPrestamo tblPrestamo;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String activo;
    private Set<TblSanciones> tblSancioneses = new HashSet<TblSanciones>(0);

    public TblDetallePrestamo() {
    }

    public TblDetallePrestamo(Long idDetalle, String activo,
        TblLibros tblLibros, TblPrestamo tblPrestamo,
        Set<TblSanciones> tblSancioneses) {
        this.idDetalle = idDetalle;
        this.tblLibros = tblLibros;
        this.tblPrestamo = tblPrestamo;
        this.activo = activo;
        this.tblSancioneses = tblSancioneses;
    }

    @Id
    @Column(name = "id_detalle", unique = true, nullable = false)
    public Long getIdDetalle() {
        return this.idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_libro")
    public TblLibros getTblLibros() {
        return this.tblLibros;
    }

    public void setTblLibros(TblLibros tblLibros) {
        this.tblLibros = tblLibros;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prestamo")
    public TblPrestamo getTblPrestamo() {
        return this.tblPrestamo;
    }

    public void setTblPrestamo(TblPrestamo tblPrestamo) {
        this.tblPrestamo = tblPrestamo;
    }

    @Column(name = "activo", nullable = false)
    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tblDetallePrestamo")
    public Set<TblSanciones> getTblSancioneses() {
        return this.tblSancioneses;
    }

    public void setTblSancioneses(Set<TblSanciones> tblSancioneses) {
        this.tblSancioneses = tblSancioneses;
    }
}
