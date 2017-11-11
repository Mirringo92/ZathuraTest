package com.IngeSoft3.demo.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "tbl_sanciones", schema = "public")
public class TblSanciones implements java.io.Serializable {
    @NotNull
    private Long idSancion;
    @NotNull
    private TblDetallePrestamo tblDetallePrestamo;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String activo;

    public TblSanciones() {
    }

    public TblSanciones(Long idSancion, String activo,
        TblDetallePrestamo tblDetallePrestamo) {
        this.idSancion = idSancion;
        this.tblDetallePrestamo = tblDetallePrestamo;
        this.activo = activo;
    }

    @Id
    @Column(name = "id_sancion", unique = true, nullable = false)
    public Long getIdSancion() {
        return this.idSancion;
    }

    public void setIdSancion(Long idSancion) {
        this.idSancion = idSancion;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_detalle")
    public TblDetallePrestamo getTblDetallePrestamo() {
        return this.tblDetallePrestamo;
    }

    public void setTblDetallePrestamo(TblDetallePrestamo tblDetallePrestamo) {
        this.tblDetallePrestamo = tblDetallePrestamo;
    }

    @Column(name = "activo", nullable = false)
    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
}
